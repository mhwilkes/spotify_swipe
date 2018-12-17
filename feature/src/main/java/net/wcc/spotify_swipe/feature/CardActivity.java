package net.wcc.spotify_swipe.feature;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.yuyakaido.android.cardstackview.*;
import net.wcc.spotify_swipe.feature.SQL.SQLHandler;
import net.wcc.spotify_swipe.feature.handlers.AuthHandler;
import net.wcc.spotify_swipe.feature.models.api.Recommendations;
import net.wcc.spotify_swipe.feature.models.api.Track;
import net.wcc.spotify_swipe.feature.models.api.TrackSimple;
import net.wcc.spotify_swipe.feature.models.card.Card;
import net.wcc.spotify_swipe.feature.models.card.CardDiffCallback;
import net.wcc.spotify_swipe.feature.models.card.CardStackAdapter;
import net.wcc.spotify_swipe.feature.requests.AccessToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CardActivity extends AppCompatActivity implements CardStackListener {

    private CardStackLayoutManager manager;
    private CardStackAdapter       adapter;
    final   GestureDetector        gestureDetector = new GestureDetector(getBaseContext(),
            new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapConfirmed(MotionEvent e) {
                    Intent intent = new Intent(getApplicationContext(), PopupCardActivity.class);
                    Card   card   = adapter.getAtPosition(manager.getTopPosition());
                    intent.putExtra("song_name", card.getSong_name());
                    intent.putExtra("artist_name", card.getSong_artist(0).getName());
                    intent.putExtra("album_name", card.getAlbumSimple().getName());
                    intent.putExtra("preview_url", card.getSong_preview_url());
                    intent.putExtra("song_url", card.getSong_url());
                    intent.putExtra("album_cover", card.getImage_url());
                    startActivity(intent);
                    return true;
                }
            });
    private CardStackView          cardStackView;
    private AccessToken            mAccessToken;
    private Recommendations        recommendations;
    private SharedPreferences      sharedPreferences;
    private int                    trackBufferSize = 10;
    private FloatingActionButton   like;
    private FloatingActionButton   dislike;
    private FloatingActionButton   reload;
    private SQLHandler             sqlHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        sqlHandler = new SQLHandler(getApplicationContext());
        sqlHandler.createDatabase();
        sqlHandler.open();

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.SharedPrefsFile), 0);

        AuthHandler a = new AuthHandler(getResources().getString(R.string.client_id),
                getResources().getString(R.string.client_secret));
        try {
            mAccessToken = a.getAccessToken();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setupCardStackView();

        cardStackView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        like = findViewById(R.id.like_button);
        like.setOnClickListener(v -> cardStackView.swipe());

        dislike = findViewById(R.id.skip_button);
        dislike.setOnClickListener(v -> cardStackView.swipe());

        reload = findViewById(R.id.rewind_button);
        reload.setOnClickListener(v -> paginate());

        NavigationView nv = findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int i1 = menuItem.getItemId();
                if (i1 == R.id.viewSongs) {
                    Intent i = new Intent();
                    i.setClass(getApplicationContext(), songList.class);
                    startActivity(i);
                }
                return false;
            }
        });
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Log.d("CardStackView", "onCardDragging: d = " + direction.name() + ", r = " + ratio);
    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d("CardStackView", "onCardSwiped: p = " + manager.getTopPosition() + ", d = " + direction);
        Card   card   = adapter.getAtPosition(manager.getTopPosition());

        if (direction.equals(Direction.Right)) {
            ContentValues cv = new ContentValues();
            cv.put("songID", card.getSong_ID());
            cv.put("songTitle", card.getSong_name());
            sqlHandler.insert("songs", cv);
        }

        if (manager.getTopPosition() == adapter.getItemCount()) {
            paginate();
        }
    }

    @Override
    public void onCardRewound() {
        Log.d("CardStackView", "onCardRewound: " + manager.getTopPosition());
    }

    @Override
    public void onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled:" + manager.getTopPosition());
    }

    private void setupCardStackView() {
        initialize();
    }

    private void initialize() {
        manager = new CardStackLayoutManager(getApplicationContext(), this);
        manager.setStackFrom(StackFrom.Top);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        manager.setTranslationInterval(8f);
        adapter = new CardStackAdapter(this, createCards());
        cardStackView = findViewById(R.id.swipe);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
    }

    private void paginate() {
        List<Card> oldList = adapter.getCards();
        List<Card> newList = new ArrayList<Card>() {{
            addAll(createCards());
        }};
        CardDiffCallback callback  = new CardDiffCallback(oldList, newList);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        adapter.setCards(newList);
        result.dispatchUpdatesTo(adapter);
    }

    private List<Card> createCards() {
        List<Card> songCard = new ArrayList<>();

        Set<String> initialSeed = sharedPreferences
                .getStringSet(getResources().getString(R.string.InitialSeed), null);
        try {
            recommendations = Recommendations
                    .requestRecommendations(trackBufferSize, "US", null,
                            initialSeed.toArray(new String[initialSeed.size()]), null,
                            this.mAccessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (TrackSimple t : recommendations.getTracks()) {
                if (t.getPreview_url() != null) {
                    songCard.add(new Card(Track.requestTrack(t.getId(), this.mAccessToken)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songCard;
    }

}

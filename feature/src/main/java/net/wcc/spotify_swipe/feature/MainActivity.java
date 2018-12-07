package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.util.Log;
import android.widget.Button;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import net.wcc.spotify_swipe.feature.handlers.AuthHandler;
import net.wcc.spotify_swipe.feature.models.api.Album;
import net.wcc.spotify_swipe.feature.models.api.Artist;
import net.wcc.spotify_swipe.feature.models.api.Paging;
import net.wcc.spotify_swipe.feature.models.api.Recommendations;
import net.wcc.spotify_swipe.feature.models.api.Search;
import net.wcc.spotify_swipe.feature.models.api.Track;
import net.wcc.spotify_swipe.feature.models.api.TrackSimple;
import net.wcc.spotify_swipe.feature.models.audio_analysis.AudioFeatures;
import net.wcc.spotify_swipe.feature.models.card.FrontCard;
import net.wcc.spotify_swipe.feature.models.card.FrontCardDiffCallback;
import net.wcc.spotify_swipe.feature.models.card.FrontCardStackAdapter;
import net.wcc.spotify_swipe.feature.requests.AccessToken;

public class MainActivity extends AppCompatActivity implements CardStackListener {

    /**
     * This activity is the starting point, on-boarding portion
     *
     * @param savedInstanceState
     */

    private Button                 b;
    private CardStackLayoutManager manager;
    private FrontCardStackAdapter  adapter;
    private CardStackView          cardStackView;

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCardStackView();

        b = findViewById(R.id.start);

        b.setOnClickListener(v -> {

            try {
                AuthHandler a = new AuthHandler("3a36e58be96b4c4ab8829fb5702d05a5",
                        "9b7780574cb1414596bf3a241d15ace0");
                AccessToken at = a.getAccessToken();

                Log.w("API RESPONSE AUDIOFEATURES", AudioFeatures.requestAudioFeature("11dFghVXANMlKmJXsNCbNl", at)
                                                                 .getTrack_href());
                Log.w("API RESPONSE ARTIST", Artist.requestArtist("0oSGxfWSnnOXhD2fKuz2Gy", at).getName());
                Log.w("API RESPONSE ALBUM", Album.requestAlbum("382ObEPsp2rxGrnsizN5TX", at).getName());
                Log.w("API RESPONSE TRACK", Track.requestTrack("3n3Ppam7vgaVa1iaRUc9Lp", at).getName());

                String[] seed_genres  = {"classical", "country"};
                String[] seed_artists = {"4NHQUGzhtTLFvgF5SZesLK"};
                String[] seed_tracks  = {"0c6xIDDpzE81m2q797ordA"};
                TrackSimple[] trackSimples = Recommendations
                        .requestRecommendations(20, "ES", seed_artists, seed_genres,
                                seed_tracks, at).getTracks();

                for (TrackSimple t : trackSimples) {
                    Log.w("API RECCOMENDATION TRACK", t.getName());
                }
                Search search = new Search("upc:00602537817016", "album", "US", 10, 5);
                Paging p      = Search.requestSearch(search, at);

                Log.w("API SEARCH", String.valueOf(p.getLimit()));

            } catch (IOException e) {
                e.printStackTrace();
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
        if (manager.getTopPosition() == adapter.getItemCount() - 5) {
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
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
        adapter = new FrontCardStackAdapter(this, createCards());
        cardStackView = findViewById(R.id.swipe);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
    }

    private void paginate() {
        List<FrontCard> oldList = adapter.getFrontCards();
        List<FrontCard> newList = new ArrayList<FrontCard>() {{
            addAll(adapter.getFrontCards());
            addAll(createCards());
        }};
        FrontCardDiffCallback callback = new FrontCardDiffCallback(oldList, newList);
        DiffUtil.DiffResult   result   = DiffUtil.calculateDiff(callback);
        adapter.setFrontCards(newList);
        result.dispatchUpdatesTo(adapter);
    }

    private List<FrontCard> createCards() {
        List<FrontCard> frontCards = new ArrayList<>();
        frontCards.add(new FrontCard("Get The Hang of Swiping", "Swipe Left or Right to Choose a Song",
                "https://source.unsplash.com/4wJxtRBueho/600x800"));
        frontCards
                .add(new FrontCard("Swiping Left", "Swipe Left When you Don't Like a Song",
                        "https://source.unsplash.com/uUFzVJ98ZY8/600x800"));
        frontCards.add(new FrontCard("Swipe Right", "Swipe Right When you Want to Hear More of The Song",
                "https://source.unsplash.com/G9JYncnA5O8/600x800"));
        frontCards.add(new FrontCard("Lets Get Started!", "Continue By Clicking the Button Below",
                "https://source.unsplash.com/d1sdcauhuuc/600x800"));

        return frontCards;
    }
}

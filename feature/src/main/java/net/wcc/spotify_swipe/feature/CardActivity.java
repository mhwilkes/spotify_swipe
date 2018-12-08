package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.util.Log;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.wcc.spotify_swipe.feature.handlers.AuthHandler;
import net.wcc.spotify_swipe.feature.models.api.Track;
import net.wcc.spotify_swipe.feature.models.card.Card;
import net.wcc.spotify_swipe.feature.models.card.CardDiffCallback;
import net.wcc.spotify_swipe.feature.models.card.CardStackAdapter;
import net.wcc.spotify_swipe.feature.requests.AccessToken;

public class CardActivity extends AppCompatActivity implements CardStackListener {

    private CardStackLayoutManager manager;
    private CardStackAdapter       adapter;
    private CardStackView          cardStackView;
    private AccessToken            mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        AuthHandler a = new AuthHandler("3a36e58be96b4c4ab8829fb5702d05a5",
                "9b7780574cb1414596bf3a241d15ace0");
        try {
            mAccessToken = a.getAccessToken();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setupCardStackView();
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
        adapter = new CardStackAdapter(this, createCards());
        cardStackView = findViewById(R.id.swipe);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
    }

    private void paginate() {
        List<Card> oldList = adapter.getCards();
        List<Card> newList = new ArrayList<Card>() {{
            addAll(adapter.getCards());
            addAll(createCards());
        }};
        CardDiffCallback    callback = new CardDiffCallback(oldList, newList);
        DiffUtil.DiffResult result   = DiffUtil.calculateDiff(callback);
        adapter.setCards(newList);
        result.dispatchUpdatesTo(adapter);
    }

    private List<Card> createCards() {
        List<Card> songCard = new ArrayList<>();

        try {
            songCard.add(new Card(Track.requestTrack("3n3Ppam7vgaVa1iaRUc9Lp", mAccessToken)));
            songCard.add(new Card(Track.requestTrack("7ouMYWpwJ422jRcDASZB7P", mAccessToken)));
            songCard.add(new Card(Track.requestTrack("7xGfFoTpQ2E7fRF5lN10tr", mAccessToken)));
            songCard.add(new Card(Track.requestTrack("4VqPOruhp5EdPBeR92t6lQ", mAccessToken)));
            songCard.add(new Card(Track.requestTrack("2takcwOaAZWiXQijPHIx7B", mAccessToken)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songCard;
    }

}

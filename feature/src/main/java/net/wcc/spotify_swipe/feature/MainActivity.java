package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.ArrayList;
import java.util.List;
import net.wcc.spotify_swipe.feature.models.card.FrontCard;
import net.wcc.spotify_swipe.feature.models.card.FrontCardDiffCallback;
import net.wcc.spotify_swipe.feature.models.card.FrontCardStackAdapter;

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
    private SharedPreferences      sp;

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(getResources().getString(R.string.SharedPrefsFile), 0);

        if (!firstLaunch()) {
            Intent i = new Intent();
            if (hasInitialSeed()) {
                i.setClass(this, CardActivity.class);
            } else {
                i.setClass(this, InitialSeedActivity.class);
            }
            startActivity(i);
        }

        setupCardStackView();

        b = findViewById(R.id.start);

        b.setOnClickListener(v -> {

                // Set FirstExecution to false, once false, this activity will not be shown again.
                this.sp.edit().putBoolean(getResources().getString(R.string.FirstExecution), false).apply();

                Intent intent = new Intent(this, InitialSeedActivity.class);
                startActivity(intent);

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

    public boolean firstLaunch() {
        if (this.sp.contains(getResources().getString(R.string.FirstExecution))) {
            return this.sp.getBoolean(getResources().getString(R.string.FirstExecution), true);
        }
        return true;
    }

    public boolean hasInitialSeed() {
        return this.sp.contains(getResources().getString(R.string.InitialSeed));
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

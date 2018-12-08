package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import net.wcc.spotify_swipe.feature.models.card.FrontCardStackAdapter;

public class CardActivity extends AppCompatActivity implements CardStackListener {

    private CardStackLayoutManager manager;
    private FrontCardStackAdapter  adapter;
    private CardStackView          cardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

}

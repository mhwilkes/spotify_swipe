package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import net.wcc.spotify_swipe.feature.handlers.AuthHandler;
import net.wcc.spotify_swipe.feature.models.audio_analysis.AudioFeatures;
import net.wcc.spotify_swipe.feature.requests.AccessToken;


import java.io.IOException;
import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    /**
     * This activity is the starting point, on-boarding portion
     *
     * @param savedInstanceState
     */

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardStackLayoutManager manager       = new CardStackLayoutManager();
        CardStackAdapter       adapter       = new CardStackAdapter();
        CardStackView          cardStackView = findViewById(R.id.card_stack_view);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);

        b = findViewById(R.id.start);

        b.setOnClickListener(v -> {

            try {
                AuthHandler a   = new AuthHandler("3a36e58be96b4c4ab8829fb5702d05a5",
                        "9b7780574cb1414596bf3a241d15ace0");
                AccessToken at  = a.getAccessToken();
                String      str = AudioFeatures.requestAudioFeature("11dFghVXANMlKmJXsNCbNl", at).getTrack_href();
                Log.w("API RESPONSE TESTER", str);
                System.out.println(str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}

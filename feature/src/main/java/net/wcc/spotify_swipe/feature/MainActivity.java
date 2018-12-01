package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * This activity is the starting point, on-boarding portion
     *
     * @param savedInstanceState
     */

    private Button b;

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.start);

        b.setOnClickListener(v -> {

            Intent intent = new Intent(this, SpotActivity.class);
            MainActivity.this.startActivity(intent);

            //            try {
            //                AuthHandler a   = new AuthHandler("3a36e58be96b4c4ab8829fb5702d05a5",
            //                        "9b7780574cb1414596bf3a241d15ace0");
            //                AccessToken at  = a.getAccessToken();
            //                String      str = AudioFeatures.requestAudioFeature("11dFghVXANMlKmJXsNCbNl", at)
            // .getTrack_href();
            //                Log.w("API RESPONSE TESTER", str);
            //                System.out.println(str);
            //            } catch (MalformedURLException e) {
            //                e.printStackTrace();
            //            } catch (IOException e) {
            //                e.printStackTrace();
            //            }
        });

    }
}

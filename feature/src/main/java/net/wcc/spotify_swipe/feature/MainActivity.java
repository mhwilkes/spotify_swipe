package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import net.wcc.spotify_swipe.feature.handlers.Client;

import java.io.IOException;
import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    /**
     * This activity is the starting point, on-boarding portion
     *
     * @param savedInstanceState
     */

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.start);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Client a = new Client("3a36e58be96b4c4ab8829fb5702d05a5", "9b7780574cb1414596bf3a241d15ace0");
                    System.out.println(a.getClientCredentials());
                    System.out.println(a.getAuthorizationToken().getAccess_token());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

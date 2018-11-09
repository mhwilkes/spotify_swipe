package net.wcc.spotify_swipe.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import net.wcc.spotify_swipe.feature.models.Album;

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
                    System.out.println(Album.requestAlbum("0sNOF9WDwhWunNAHPD3Baj"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}

package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

public class PopupCardActivity extends AppCompatActivity {

    private MediaPlayer player = new MediaPlayer();
    private TextView song_name, artist_name, album_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_card);

        Intent intent = this.getIntent();

        song_name = findViewById(R.id.song_name);
        artist_name = findViewById(R.id.artist_name);
        album_name = findViewById(R.id.album_name);

        song_name.setText(intent.getStringExtra("song_name"));
        artist_name.setText(intent.getStringExtra("artist_name"));
        album_name.setText(intent.getStringExtra("album_name"));

        try {
            player.setDataSource(intent.getStringExtra("song_url"));
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.io.IOException;

public class PopupCardActivity extends AppCompatActivity {

    private MediaPlayer player = new MediaPlayer();
    private TextView    song_name, artist_name, album_name, is_preview;
    private ImageView album_cover;
    private Intent    intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_card);

        intent = this.getIntent();

        song_name = findViewById(R.id.song_name);
        artist_name = findViewById(R.id.artist_name);
        album_name = findViewById(R.id.album_name);
        album_cover = findViewById(R.id.album_cover);
        is_preview = findViewById(R.id.no_preview);

        song_name.setText(intent.getStringExtra("song_name"));
        artist_name.setText(intent.getStringExtra("artist_name"));
        album_name.setText(intent.getStringExtra("album_name"));
        Glide.with(album_cover)
             .load(intent.getStringExtra("album_cover"))
             .into(album_cover);

        try {
            if (intent.getStringExtra("song_url") != null) {
                player.setDataSource(intent.getStringExtra("song_url"));
                player.prepareAsync();
                player.setVolume(.7f, .7f);
                player.setOnPreparedListener(mp -> player.start());
            } else {
                is_preview.setText("No Preview Available!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent.getStringExtra("song_url") != null) {
            player.stop();
            player.release();
        }
    }
}

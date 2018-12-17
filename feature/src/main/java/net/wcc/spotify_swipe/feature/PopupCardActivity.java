package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import be.rijckaert.tim.animatedvector.FloatingMusicActionButton;
import be.rijckaert.tim.animatedvector.FloatingMusicActionButton.Mode;
import com.bumptech.glide.Glide;
import java.io.IOException;

public class PopupCardActivity extends AppCompatActivity {

    // Media player to play song samples.
    private MediaPlayer player = new MediaPlayer();

    // Define our views.
    private TextView    song_name, artist_name, album_name, is_preview;
    private ImageView album_cover;

    private Intent    intent;
    private FloatingMusicActionButton mFloatingActionButton;
    private int                       seekPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_card);

        intent = this.getIntent();

        // Initialize our views.
        song_name = findViewById(R.id.song_name);
        artist_name = findViewById(R.id.artist_name);
        album_name = findViewById(R.id.album_name);
        album_cover = findViewById(R.id.album_cover);
        is_preview = findViewById(R.id.is_preview);
        mFloatingActionButton = findViewById(R.id.pause_play);

        // Update text views with information related to the track.
        song_name.setText(intent.getStringExtra("song_name"));
        artist_name.setText(intent.getStringExtra("artist_name"));
        album_name.setText(intent.getStringExtra("album_name"));

        // Load the album cover.
        Glide.with(album_cover)
             .load(intent.getStringExtra("album_cover"))
             .into(album_cover);

        // Music player stuff.
        try {
            if (intent.getStringExtra("preview_url") != null) {
                player.setDataSource(intent.getStringExtra("preview_url"));
                player.prepareAsync();
                player.setVolume(.7f, .7f);
                player.setOnPreparedListener(mp -> player.start());
            } else {
                is_preview.setTypeface(Typeface.DEFAULT_BOLD);
                is_preview.setText("No preview available!");

                mFloatingActionButton
                        .setOnMusicFabClickListener(view -> {
                            if (player.isPlaying()) {
                                player.pause();
                                seekPos = player.getCurrentPosition();
                                mFloatingActionButton.changeMode(Mode.PAUSE_TO_PLAY);
                            } else {
                                player.start();
                                player.seekTo(seekPos);
                                mFloatingActionButton.changeMode(Mode.PLAY_TO_PAUSE);
                            }


                        });
                player.setOnCompletionListener(mp -> mFloatingActionButton.changeMode(Mode.PLAY_TO_STOP));
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

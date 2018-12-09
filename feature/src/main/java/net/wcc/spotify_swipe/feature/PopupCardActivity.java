package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import net.wcc.spotify_swipe.feature.models.card.Card;
import org.w3c.dom.Text;

public class PopupCardActivity extends AppCompatActivity {

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

    }
}

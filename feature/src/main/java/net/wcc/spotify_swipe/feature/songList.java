package net.wcc.spotify_swipe.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class songList extends AppCompatActivity {

    LinearLayout songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        songList = findViewById(R.id.songList);

        //initialize sql

        //query for all songs
        Map<String, String> songs = getSongs(/*sqlshit*/);

        //populate list with songs
        populate(songList);
    }

    public void populate(Map<String, String> songs, LinearLayout list) {

        //make list
        for (Map.Entry<String, String> song : songs.entrySet()) {
            TextView songItem = new TextView(this);
            songItem.setText(song.getValue());
            songItem.setOnClickListener(v -> {
                Toast.makeText(this, song.getKey(), Toast.LENGTH_LONG);
            });

            list.addView(songItem);
        }
    }

    public Map<String, String> getSongs(/*sqlShit*/) {
        Map<String, String> songList = new HashMap<>();



        return songList;
    }
}

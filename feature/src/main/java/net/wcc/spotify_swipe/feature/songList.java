package net.wcc.spotify_swipe.feature;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import net.wcc.spotify_swipe.feature.SQL.SQLHandler;

import java.util.HashMap;
import java.util.Map;

public class songList extends AppCompatActivity {

    LinearLayout songList;
    SQLHandler sqlHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        songList = findViewById(R.id.songList);

        //initialize sql
        sqlHandler = new SQLHandler(getApplicationContext());
        sqlHandler.createDatabase();
        sqlHandler.open();

        //query for all songs
        Map<String, String> songs = getSongs();

        //populate list with songs
        populate(songs, songList);
    }

    public void populate(Map<String, String> songs, LinearLayout list) {

        //make list
        for (Map.Entry<String, String> song : songs.entrySet()) {
            TextView songItem = new TextView(this);
            songItem.setText(song.getValue());
            songItem.setTextSize(24.0f);
            songItem.setOnClickListener(v -> {
                Toast.makeText(getApplicationContext(), song.getKey(), Toast.LENGTH_LONG).show();
            });

            list.addView(songItem);
        }
    }

    public Map<String, String> getSongs() {
        Map<String, String> songList = new HashMap<>();

        String query = "SELECT * FROM songs";

        Cursor resultSet = sqlHandler.query(query);
        while(resultSet.moveToNext()) {
            songList.put(resultSet.getString(1), resultSet.getString(2));
        }

        return songList;
    }
}

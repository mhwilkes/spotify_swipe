package net.wcc.spotify_swipe.feature;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.*;

public class InitialSeedActivity extends AppCompatActivity {

    final String[] genres = {"acoustic", "alternative", "anime", "chill", "classical", "dance", "death-metal", "dubstep", "hip-hop", "pop", "reggae", "soul", "soundtracks", "study", "techno"};
    TextView instructions;
    Button nextButton;
    LinearLayout seedList;

    Set<String> genreSeeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_seed);

        instructions    = findViewById(R.id.instructions);
        nextButton      = findViewById(R.id.nextButton);
        seedList        = findViewById(R.id.seedList);

        genreSeeds = new HashSet<>();

        instructions.setText("Choose 5 genres from the list, then tap next...");
        nextButton.setText("Next");
        nextButton.setOnClickListener(v -> {
            if (genreSeeds.size() == 5) {
                SharedPreferences sp = getSharedPreferences(getResources().getString(R.string.SharedPrefsFile), 0);
                sp.edit().putStringSet(getResources().getString(R.string.InitialSeed), genreSeeds).commit();
                Intent launchCards = new Intent(this, CardActivity.class);
                startActivity(launchCards);
            } else {
                Toast.makeText(getApplicationContext(), "Select at least 5 genres!", Toast.LENGTH_LONG).show();
            }
        });

        fillSeedList(genres);
    }

    public void fillSeedList(String[] options) {
        for (String s : options) {
            CheckBox option = new CheckBox(this);
            option.setText(s);
            option.setTextSize(18.f);
            option.setTextColor(getResources().getColor(android.R.color.black, null));
            option.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    if (genreSeeds.size() < 5) {
                        genreSeeds.add(s);
                    } else {
                        Toast.makeText(getApplicationContext(), "You can only choose 5 genres!", Toast.LENGTH_SHORT).show();
                        option.setChecked(false);
                    }
                } else {
                    genreSeeds.remove(s);
                }
            });

            seedList.addView(option);
        }
    }

}

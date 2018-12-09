package net.wcc.spotify_swipe.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class InitialSeedActivity extends AppCompatActivity {

    final String[] genres = {"acoustic", "alternative", "anime", "chill", "classical", "dance", "death-metal", "dubstep", "hip-hop", "pop", "reggae", "soul", "soundtracks", "study", "techno"};
    TextView instructions;
    Button nextButton;
    LinearLayout seedList;

    ArrayList<String> genreSeeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_seed);

        instructions    = findViewById(R.id.instructions);
        nextButton      = findViewById(R.id.nextButton);
        seedList        = findViewById(R.id.seedList);

        genreSeeds = new ArrayList<>();

        instructions.setText("Choose your 3 favorite genres, then tap next...");
        nextButton.setText("Next");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (genreSeeds.size() == 3) {
                    // TODO: Write next step...
                    Toast.makeText(getApplicationContext(), "You are ready to move on!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Select at least 3 genres!", Toast.LENGTH_LONG).show();
                }
            }
        });

        fillSeedList(genres);
    }

    public void fillSeedList(String[] options) {
        for (String s : options) {
            CheckBox option = new CheckBox(this);
            option.setText(s);
            option.setTextColor(getResources().getColor(android.R.color.black, null));
            option.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (genreSeeds.size() < 3) {
                            genreSeeds.add(s);
                        } else {
                            Toast.makeText(InitialSeedActivity.this, "You can only choose 3 genres!", Toast.LENGTH_SHORT);
                        }
                    } else {
                        genreSeeds.remove(s);
                    }
                    System.out.println(genreSeeds.toString());
                }
            });

            seedList.addView(option);
        }
    }

}

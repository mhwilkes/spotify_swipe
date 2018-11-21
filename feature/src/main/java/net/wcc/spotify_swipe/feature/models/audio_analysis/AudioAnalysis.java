package net.wcc.spotify_swipe.feature.models.audio_analysis;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AudioAnalysis {

    private TimeInterval[] bars;
    private TimeInterval[] beats;
    private Section[]      sections;
    private Segment[]      segments;
    private TimeInterval   tatums;

    public AudioAnalysis(TimeInterval[] bars, TimeInterval[] beats, Section[] sections, Segment[] segments,
            TimeInterval tatums) {
        this.bars = bars;
        this.beats = beats;
        this.sections = sections;
        this.segments = segments;
        this.tatums = tatums;
    }

    public static AudioAnalysis requestAnalysis(String ID, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String endpoint = "https://api.spotify.com/v1/audio-analysis/";
        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AudioAnalysis.class);
    }

    public TimeInterval[] getBars() {
        return bars;
    }

    public TimeInterval[] getBeats() {
        return beats;
    }

    public Section[] getSections() {
        return sections;
    }

    public Segment[] getSegments() {
        return segments;
    }

    public TimeInterval getTatums() {
        return tatums;
    }
}

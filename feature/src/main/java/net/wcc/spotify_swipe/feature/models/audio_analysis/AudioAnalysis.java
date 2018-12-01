package net.wcc.spotify_swipe.feature.models.audio_analysis;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AudioAnalysis {
    private static String         endpoint = "https://api.spotify.com/v1/audio-analysis/";
    private        TimeInterval[] bars;
    private        TimeInterval[] beats;
    private        Section[]      sections;
    private        Segment[]      segments;
    private        TimeInterval[] tatums;

    /**
     * @param bars
     * @param beats
     * @param sections
     * @param segments
     * @param tatums
     */
    public AudioAnalysis(TimeInterval[] bars, TimeInterval[] beats, Section[] sections, Segment[] segments,
                         TimeInterval[] tatums) {
        this.bars = bars;
        this.beats = beats;
        this.sections = sections;
        this.segments = segments;
        this.tatums = tatums;
        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /**
     * @param ID
     *
     * @return
     *
     * @throws IOException
     */
    public static AudioAnalysis requestAnalysis(String ID, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();

        Request request = new Request.Builder().url(getEndpoint() + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), AudioAnalysis.class);
    }

    public static String getEndpoint() {
        return endpoint;
    }

    /**
     * @return
     */
    public TimeInterval[] getBars() {
        return bars;
    }

    /**
     * @return
     */
    public TimeInterval[] getBeats() {
        return beats;
    }

    /**
     * @return
     */
    public Section[] getSections() {
        return sections;
    }

    /**
     * @return
     */
    public Segment[] getSegments() {
        return segments;
    }

    /**
     * @return
     */
    public TimeInterval[] getTatums() {
        return tatums;
    }

}

package net.wcc.spotify_swipe.feature.models.audio_analysis;

import android.os.StrictMode;
import net.wcc.spotify_swipe.feature.handlers.Client;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AudioAnalysis {

    private TimeInterval[] bars;
    private TimeInterval[] beats;
    private Section[]      sections;
    private Segment[]      segments;
    private TimeInterval[] tatums;

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
    public static AudioAnalysis requestAnalysis(String ID) throws IOException {

        String endpoint = "https://api.spotify.com/v1/audio-analysis/";
        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + Client
                        .getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), AudioAnalysis.class);
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

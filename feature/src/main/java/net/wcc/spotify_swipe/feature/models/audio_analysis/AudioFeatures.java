package net.wcc.spotify_swipe.feature.models.audio_analysis;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AudioFeatures {
    private static String endpoint = "https://api.spotify.com/v1/audio-features/"; //Local Endpoint
    private        int    duration_ms;
    private        int    key;
    private        int    mode;
    private        int    time_signature;
    private        float  acousticness;
    private        float  danceability;
    private        float  energy;
    private        float  instrumentalness;
    private        float  liveness;
    private        float  loudness;
    private        float  speechiness;
    private        float  valence;
    private        float  tempo;
    private        String id;
    private        String uri;
    private        String track_href;
    private        String analysis_url;
    private        String type;

    /**
     * @param duration_ms
     * @param key
     * @param mode
     * @param time_signature
     * @param acousticness
     * @param danceability
     * @param energy
     * @param instrumentalness
     * @param liveness
     * @param loudness
     * @param speechiness
     * @param valence
     * @param tempo
     * @param id
     * @param uri
     * @param track_href
     * @param analysis_url
     * @param type
     */
    public AudioFeatures(int duration_ms, int key, int mode, int time_signature, float acousticness, float
            danceability, float energy, float instrumentalness, float liveness, float loudness, float speechiness,
                         float valence, float tempo, String id, String uri, String track_href, String analysis_url,
                         String type) {
        this.duration_ms = duration_ms;
        this.key = key;
        this.mode = mode;
        this.time_signature = time_signature;
        this.acousticness = acousticness;
        this.danceability = danceability;
        this.energy = energy;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.valence = valence;
        this.tempo = tempo;
        this.id = id;
        this.uri = uri;
        this.track_href = track_href;
        this.analysis_url = analysis_url;
        this.type = type;
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
    public static AudioFeatures requestAudioFeature(String ID, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();
        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), AudioFeatures.class);
    }

    /**
     * @param IDS
     *
     * @return
     *
     * @throws IOException
     */
    public static AudioFeatures[] requestAudioFeatures(String[] IDS, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();

        StringBuilder sb = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        Request request = new Request.Builder().url(endpoint + "?ids=" + sb.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                 at.getAccess_token()).addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), AudioFeatures[].class);
    }

    /**
     * @return
     */
    public int getDuration_ms() {
        return duration_ms;
    }

    /**
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * @return
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return
     */
    public int getTime_signature() {
        return time_signature;
    }

    /**
     * @return
     */
    public float getAcousticness() {
        return acousticness;
    }

    /**
     * @return
     */
    public float getDanceability() {
        return danceability;
    }

    /**
     * @return
     */
    public float getEnergy() {
        return energy;
    }

    /**
     * @return
     */
    public float getInstrumentalness() {
        return instrumentalness;
    }

    /**
     * @return
     */
    public float getLiveness() {
        return liveness;
    }

    /**
     * @return
     */
    public float getLoudness() {
        return loudness;
    }

    /**
     * @return
     */
    public float getSpeechiness() {
        return speechiness;
    }

    /**
     * @return
     */
    public float getValence() {
        return valence;
    }

    /**
     * @return
     */
    public float getTempo() {
        return tempo;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @return
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return
     */
    public String getTrack_href() {
        return track_href;
    }

    /**
     * @return
     */
    public String getAnalysis_url() {
        return analysis_url;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }
}

package net.wcc.spotify_swipe.feature.models.audio_analysis;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AudioFeatures {
    private static String endpoint = "https://api.spotify.com/v1/audio-features/";
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

    public AudioFeatures(int duration_ms, int key, int mode, int time_signature, float acousticness, float
            danceability, float energy, float instrumentalness, float liveness, float loudness, float speechiness,
            float valence, float tempo, String id, String uri, String track_href, String analysis_url, String type) {
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
    }

    public static AudioFeatures requestAudioFeature(String ID, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AudioFeatures.class);
    }

    public static AudioFeatures[] requestAudioFeatures(String[] IDS, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        StringBuilder sb = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        Request request = new Request.Builder().url(endpoint + "?ids=" + sb.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + "" + a.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AudioFeatures[].class);
    }


    public int getDuration_ms() {
        return duration_ms;
    }

    public int getKey() {
        return key;
    }

    public int getMode() {
        return mode;
    }

    public int getTime_signature() {
        return time_signature;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public float getDanceability() {
        return danceability;
    }

    public float getEnergy() {
        return energy;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public float getLiveness() {
        return liveness;
    }

    public float getLoudness() {
        return loudness;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public float getValence() {
        return valence;
    }

    public float getTempo() {
        return tempo;
    }

    public String getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getTrack_href() {
        return track_href;
    }

    public String getAnalysis_url() {
        return analysis_url;
    }

    public String getType() {
        return type;
    }
}

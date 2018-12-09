package net.wcc.spotify_swipe.feature.models.api;

import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Recommendations {

    private        RecommendationsSeed[] seeds;
    private        TrackSimple[]         tracks;
    private static String                endpoint = "https://api.spotify.com/v1/recommendations";

    /**
     * @param seeds
     * @param tracks
     */
    public Recommendations(RecommendationsSeed[] seeds, TrackSimple[] tracks) {
        this.seeds = seeds;
        this.tracks = tracks;
    }

    /**
     * @return
     */
    public RecommendationsSeed[] getSeeds() {
        return seeds;
    }

    /**
     * @return
     */
    public static String getEndpoint() {
        return endpoint;
    }

    /**
     * @return
     */
    public TrackSimple[] getTracks() {
        return tracks;
    }

    /**
     *
     * @param limit
     * @param market
     * @param seed_artists
     * @param seed_genres
     * @param seed_tracks
     * @param at
     * @return
     * @throws IOException
     */
    public static Recommendations requestRecommendations(int limit, String market, String[] seed_artists,
            String[] seed_genres, String[] seed_tracks,
            AccessToken at) throws IOException {

        StringBuilder sb     = new StringBuilder(getEndpoint());
        StringBuilder sa     = new StringBuilder();
        StringBuilder sg     = new StringBuilder();
        StringBuilder st     = new StringBuilder();
        OkHttpClient  client = new OkHttpClient();
        Gson          gson   = new Gson();
        
        if (limit > 0) {
            sb.append("?limit=").append(limit);
        }
        if (market != null) {
            sb.append("&market=").append(market);
        }
        if (seed_artists != null) {
            for (String s : seed_artists) {
                sa.append(s).append(',');
            }
            if (sa.toString().endsWith(",")) {
                sa.setLength(sa.length() - 1);
            }
            sb.append("&seed_artists=").append(sa.toString());
        }

        if (seed_genres != null) {
            for (String s : seed_genres) {
                sg.append(s).append(',');
            }
            if (sg.toString().endsWith(",")) {
                sg.setLength(sg.length() - 1);
            }
            sb.append("&seed_genres=").append(sg.toString());
        }

        if (seed_tracks != null) {
            for (String s : seed_tracks) {
                st.append(s).append(',');
            }
            if (st.toString().endsWith(",")) {
                st.setLength(st.length() - 1);
            }
            sb.append("&seed_tracks=").append(st.toString());
        }

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                                               .addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at
                                                       .getAccess_token()).addHeader("cache-control", "no-cache")
                                               .build();

        Response response = client.newCall(request).execute();
        return gson.fromJson(response.body().string(), Recommendations.class);
    }


}

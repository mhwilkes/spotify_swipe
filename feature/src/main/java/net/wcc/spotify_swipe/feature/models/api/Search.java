package net.wcc.spotify_swipe.feature.models.api;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Search {

    private final static String endpoint = "https://api.spotify.com/v1/search";
    private              String q; //Required
    private              String type; //Required
    private              String market; //Optional
    private              int    limit; //Optional
    private              int    offset; //Optional

    /**
     * @param q      Search query keywords and optional field filters and operators.
     * @param type   A comma-separated list of item types to search across.
     *               Valid types are: album , artist, playlist, and track.
     *               Search results include hits from all the specified item types.
     * @param market An ISO 3166-1 alpha-2 country code or the string from_token.
     *               If a country code is specified, only artists, albums, and tracks with content that is playable in
     *               that market is returned. If market is set to from_token, and a valid access token is specified in
     *               the request header, only content playable in the country associated with the user account, is
     *               returned.
     * @param limit  Maximum number of results to return.
     *               Default: 20
     *               Minimum: 1
     *               Maximum: 50
     * @param offset The index of the first result to return.
     *               Default: 0 (the first result).
     *               Maximum offset (including limit): 10,000.
     *               Use with limit to get the next page of search results.
     */
    public Search(@NonNull String q, @NonNull String type, @NonNull String market, int limit, int offset) {
        this.q = q;
        this.type = type;
        this.market = market;
        if (limit > 0 && limit <= 50) { this.limit = limit; } else { limit = 20; }
        if (offset >= 0 && offset + limit <= 10000) { this.offset = offset; } else { this.offset = 0; }
    }

    public static Paging requestSearch(Search s, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();

        StringBuilder query = new StringBuilder();

        if (s.getQ() != null && !s.getQ().isEmpty()) {
            query.append("?q=").append(s.getQ().replace(" ", "+"));
        }
        if (s.getType() != null && !s.getType().isEmpty()) {
            query.append("&type=").append(s.getType().replace(",", "+"));
        }
        if (s.getMarket() != null && !s.getMarket().isEmpty()) {
            query.append("&market=").append(s.getMarket());
        }
        query.append("&limit=").append(s.getLimit());
        query.append("&offset=").append(s.getOffset());

        Log.w("SEARCH QUERY", getEndpoint() + query.toString());

        Request request = new Request.Builder().url(getEndpoint() + query.toString()).get().addHeader
                ("Accept", "application/json").addHeader("Content-Type", "application/json").addHeader
                ("Authorization", "Bearer " + at.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Paging.class);
    }

    public static final String getEndpoint() {
        return endpoint;
    }

    public String getQ() {
        return q;
    }

    public String getType() {
        return type;
    }

    public String getMarket() {
        return market;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }


}

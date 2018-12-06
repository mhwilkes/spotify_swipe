package net.wcc.spotify_swipe.feature.models.api;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Search {

    private final String endpoint = "https://api.spotify.com/v1/search";
    private String q; //Required
    private String type; //Required
    private String market; //Optional
    private int limit; //Optional
    private int offset; //Optional

    public Search(String q, String type, String market, int limit, int offset) {
        this.q = q;
        this.type = type;
        this.market = market;
        if (limit > 0 && limit <= 50)
            this.limit = limit;
        else
            limit = 20;
        if (offset >= 0 && offset + limit <= 10000)
            this.offset = offset;
        else
            this.offset = 0;
    }

    public Paging requestSearch(Search s, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        StringBuilder query = new StringBuilder();

        if (s.getQ() != null || !s.getQ().isEmpty()) {
            query.append("?q=").append(s.getQ().replace(" ", "+"));
        }

        Request request = new Request.Builder().url(getEndpoint() + query.toString()).get().addHeader
                ("Accept", "application/json").addHeader("Content-Type", "application/json").addHeader
                ("Authorization", "Bearer " + at.getAccess_token())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Paging.class);
    }

    public String getEndpoint() {
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

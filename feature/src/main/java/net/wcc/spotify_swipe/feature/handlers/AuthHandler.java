package net.wcc.spotify_swipe.feature.handlers;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.*;

import java.io.IOException;
import java.util.Base64;

public class AuthHandler {
    // Spotify Client ID
    private       String client_id;
    // Spotify Client Secret
    private       String client_secret;

    // Constructor
    public AuthHandler(String client_id, String client_secret) {
        // Define the Client ID.
        this.client_id = client_id;

        // Define the Client Secret.
        this.client_secret = client_secret;

        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    // Consume client credentials and give an Access Token object.
    public AccessToken getAccessToken() throws IOException {

        // Format client credentials to conform with api requirements.
        final String clientCredentials = Base64.getEncoder().encodeToString((client_id + ":" + client_secret)
                .getBytes());

        OkHttpClient client = new OkHttpClient();

        MediaType   mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body      = RequestBody.create(mediaType, "grant_type=client_credentials");
        // The Spotify api Authorization Endpoint.
        String authEndpoint = "https://accounts.spotify.com/api/token/";
        Request request = new Request.Builder().url(authEndpoint).post(body).addHeader("Authorization", "Basic " + ""
                + clientCredentials).addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader
                ("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AccessToken.class);
    }

}

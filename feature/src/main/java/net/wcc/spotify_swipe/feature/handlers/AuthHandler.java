package net.wcc.spotify_swipe.feature.handlers;

import android.os.StrictMode;
import android.util.Log;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.*;

import java.io.IOException;

public class AuthHandler {
    private static String authEndpoint = "https://accounts.spotify.com/api/token/";
    private static String clientCredentials;

    private ResponseBody responseBody;

    // Constructor
    public AuthHandler(String clientCredentials) throws IOException {
        this.clientCredentials = clientCredentials;
        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    // Consume client credentials and give an Access Token object.
    public AccessToken getAccessToken() throws IOException {

        // Format client credentials to conform with api requirements.

        MediaType   mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body      = RequestBody.create(mediaType, "grant_type=client_credentials");
        // The Spotify api Authorization Endpoint.

        Request request = new Request.Builder().url(getAuthEndpoint()).post(body).addHeader("Authorization", "Basic "
                + clientCredentials).addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader
                ("cache-control", "no-cache").build();

        Client.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);
                Log.w("Auth Response", "Auth Returned Successfully");
                responseBody = response.body();

            }

        });
        return Client.getGson().fromJson(responseBody.string(), AccessToken.class);
    }

    public static String getAuthEndpoint() {
        return authEndpoint;
    }

}
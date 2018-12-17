package net.wcc.spotify_swipe.feature.handlers;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;

import java.io.IOException;
import java.util.Base64;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthHandler {

    private static String authEndpoint = "https://accounts.spotify.com/api/token/";
    private        String client_id, client_secret;

    private Response response;

    /**
     * @param client_id     Received from user account to access api. Publicly available
     * @param client_secret Received from user account to verify public key
     */
    public AuthHandler(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /**
     * @return the Access Token used for api Requests
     */
    public AccessToken getAccessToken() throws IOException {
        // Format client credentials to conform with api requirements.
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();

        // Set Media Type for request
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        // Set Request body for client credentials
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials");

        // Add Client Credentials
        final String clientCredentials = Base64.getEncoder().encodeToString((client_id + ":" + client_secret)
                .getBytes());

        // Building request to be used to ask for Access Token
        Request request = new Request.Builder().url(getAuthEndpoint()).post(body).addHeader("Authorization", "Basic "
                + clientCredentials).addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader
                ("cache-control", "no-cache").build();

        // Executing request to a response object
        response = client.newCall(request).execute();

        // Returning Access Token Object through GSON conversion of JSON
        return gson.fromJson(response.body().string(), AccessToken.class);
    }

    // Returns endpoint URL for getAccessToken();
    private String getAuthEndpoint() {
        return authEndpoint;
    }

}
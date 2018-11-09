package net.wcc.spotify_swipe.feature.handlers;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import net.wcc.spotify_swipe.feature.requests.Request;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.HashMap;

public class AuthHandler {
    // The Spotify api Authorization Endpoint.
    private final String                  authEndpoint     = "https://accounts.spotify.com/api/token";
    // Spotify Client ID
    private       String                  client_id;
    // Spotify Client Secret
    private       String                  client_secret;
    // The request object that will retrieve the Access Token.
    private       Request                 request;
    // The Map that holds the header parameters for the auth request.
    private       HashMap<String, String> headerParameters = new HashMap<>();
    // The Map that holds the url parameters for the auth request.
    private       HashMap<String, String> urlParameters    = new HashMap<>();


    // Constructor
    public AuthHandler(String client_id, String client_secret) {
        // Define the Client ID.
        this.client_id = client_id;

        // Define the Client Secret.
        this.client_secret = client_secret;
    }

    // Consume client credentials and give an Access Token object.
    public AccessToken getAccessToken() {
        Gson gson = new Gson();

        // Format client credentials to conform with api requirements.
        final String clientCredentials = Base64.getEncoder().encodeToString((this.client_id + ":" + this.client_secret).getBytes());

        // Define the authorization header parameter.
        headerParameters.put("Authorization", "Basic " + clientCredentials);

        // Define the grant_type url parameter.
        urlParameters.put("grant_type", "client_credentials");

        try {
            // Create the request.
            request = new Request(this.authEndpoint, this.headerParameters, this.urlParameters, true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // TODO: HANDLE THIS PROPERLY
        }

        // Return the result of the executed request parsed by Gson as an AccessToken.
        return gson.fromJson(request.execute(), AccessToken.class);
    }

}

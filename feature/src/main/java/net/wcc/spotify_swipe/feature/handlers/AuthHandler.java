package net.wcc.spotify_swipe.feature.handlers;

import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import net.wcc.spotify_swipe.feature.models.AccessToken;
import net.wcc.spotify_swipe.feature.requests.Request;

public class AuthHandler {

    private String  client_id;      // Spotify Client ID
    private String  client_secret;  // Spotify Client Secret
    private Request request;        // The request that will retrieve the Access Token.

    private Map<String, String> headerParameters    = new HashMap<>(); // The Map that holds the header parameters for the auth request.
    private Map<String, String> urlParameters       = new HashMap<>(); // The Map that holds the url parameters for the auth request.

    private final String authEndpoint = "https://accounts.spotify.com/api/token"; // The Spotify api Authorization Endpoint.

    public AccessToken getAccessToken(String client_id, String client_secret) { // Consume client credentials and give an Access Token object.
        Gson gson = new Gson();

        final String clientCredentials = Base64.getEncoder().encodeToString( (client_id + ":" + client_secret).getBytes() ); // Format client credentials to conform with api requirements.

        headerParameters.put("Authorization", "Basic " + clientCredentials); // Define the authorization header parameter.
        urlParameters.put("grant_type", "client_credentials");               // Define the grant_type url parameter.

        try {
            request = new Request(this.authEndpoint, this.headerParameters, this.urlParameters, true); // Create the request.
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // TODO: HANDLE THIS PROPERLY
        }

        return gson.fromJson(request.execute(), AccessToken.class); // Return the result of the executed request parsed by Gson as an AccessToken.
    }

    public AuthHandler(String client_id, String client_secret) {
        this.client_id      = client_id;        // Define the Client ID.
        this.client_secret  = client_secret;    // Define the Client Secret.
    }

}

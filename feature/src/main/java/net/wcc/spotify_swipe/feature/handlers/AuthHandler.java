package net.wcc.spotify_swipe.feature.handlers;

import android.os.AsyncTask;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import net.wcc.spotify_swipe.feature.requests.Request;

import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.Future;

public class AuthHandler {
    // The Spotify api Authorization Endpoint.
    private final String                  authEndpoint     = "https://accounts.spotify.com/api/token/";
    private       String                  rtn;
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
    public String getAccessToken() throws UnirestException {

        // Format client credentials to conform with api requirements.
        final String clientCredentials = Base64.getEncoder().encodeToString((client_id + ":" + client_secret).getBytes());
        // Define the authorization header parameter.
        headerParameters.put("Authorization:", "Basic " + clientCredentials);

        // Define the grant_type url parameter.
        urlParameters.put("grant_type", "client_credentials");


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Future<HttpResponse<String>> future = Unirest.post("https://accounts.spotify.com/api/token/")
                            .header("Authorization", "Basic M2EzNmU1OGJlOTZiNGM0YWI4ODI5ZmI1NzAyZDA1YTU6OWI3NzgwNTc0Y2IxNDE0NTk2YmYzYTI0MWQxNWFjZTA=")
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .header("Postman-Token", "930daefb-c537-4062-9dab-2cec908a7a2e")
                            .header("cache-control", "no-cache")
                            .body("grant_type=client_credentials")
                            .asStringAsync(new Callback<String>() {
                                @Override
                                public void completed(HttpResponse<String> response) {
                                    rtn = response.getBody();
                                    System.out.println(rtn);

                                }

                                @Override
                                public void failed(UnirestException e) {
                                    System.out.println(e);
                                }

                                @Override
                                public void cancelled() {
                                    System.out.println("The request has been cancelled");
                                }
                            });
                        future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return rtn;
    }

}

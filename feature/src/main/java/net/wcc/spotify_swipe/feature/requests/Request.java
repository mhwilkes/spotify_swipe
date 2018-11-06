package net.wcc.spotify_swipe.feature.requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Map;

public class Request {

    private HttpURLConnection conn;
    private URL url;
    private String method;


    public Request(String baseURL, String client_id, String client_secret) {
        // Auth Request
        // Constructor

        method = "POST";

        String encodedCreds = Base64.getEncoder().encodeToString((client_id + ":" + client_secret).getBytes());

        try {
            url = new URL(baseURL);
        } catch (MalformedURLException e) {
            //TODO: Handle this properly
            e.printStackTrace();
        }

        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            //TODO: Handle this properly
            e.printStackTrace();
        }


    }

    /**
     * @param baseURL  Base Spotify API Endpoint URL
     * @param endpoint Expected endpoint to send API call too
     * @param params   Takes Map<String key, String value> provided from requested call to input all parameters to API Request
     */
    public Request(String baseURL, String endpoint, Map<String, String> params) {
        // Query
        // Request Constructor
        method = "GET";

    }

}

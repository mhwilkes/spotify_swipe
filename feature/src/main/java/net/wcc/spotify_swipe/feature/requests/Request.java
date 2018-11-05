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

    private HttpURLConnection   conn;
    private URL                 url;
    private String              method;

    

    public Request(String baseURL, String client_id, String client_secret) { // Auth Request Constructor

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

    public Request(String baseURL, String endpoint, Map<String, String> params) { // Query Request Constructor
        method = "GET";

    }

}

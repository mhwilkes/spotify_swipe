package net.wcc.spotify_swipe.feature.requests;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Request {
    private static final String baseURL = "https://api.spotify.com/v1";

    private HttpURLConnection   connection       = null; // The HTTP connection to the server.
    private URL                 url; // The URL the HTTP request will be sent to.
    private Map<String, String> headerParameters = null; // The header parameters sent with the request.
    private String              urlParameters; // The url parameters sent with the request.
    private Boolean             isPost; // If true, execute as a POST request, otherwise execute as a GET request.
    private String              rtn              = null;

    public Request(String url, Map<String, String> headerParameters, Map<String, String> urlParameters, Boolean isPost) throws MalformedURLException {
        this.headerParameters = headerParameters;
        this.urlParameters = formatURLParameters(urlParameters);
        this.isPost = isPost;
        this.url = new URL(this.isPost ? url : url + '?' + this.urlParameters);
    }

    private String formatURLParameters(Map<String, String> urlParameters) {
        if (urlParameters == null)
            return "";
        StringBuilder formattedURLParameters = new StringBuilder();

        for (Map.Entry<String, String> uP : urlParameters.entrySet()) {
            if (formattedURLParameters.length() > 0)
                formattedURLParameters.append('&');
            formattedURLParameters.append(uP.getKey()).append("=").append(uP.getValue());
        }

        return formattedURLParameters.toString();
    }

    // Simplest Request
    public Request(String url, boolean isPost, Map<String, String> urlParameters) throws MalformedURLException {
        this.url = new URL(this.isPost ? url : url + '?' + this.urlParameters);
        this.isPost = isPost;
        this.urlParameters = formatURLParameters(urlParameters);
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public String execute() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                rtn = (makeRequest() ? getResponse() : null);
            }
        });
        return rtn;
    }

    @NonNull
    private Boolean makeRequest() {


        try {

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(isPost ? "POST" : "GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            if(headerParameters != null){
                for (Map.Entry<String, String> hP : headerParameters.entrySet()) {
                    connection.setRequestProperty(hP.getKey(), hP.getValue());
                }
            }

            if (isPost) {
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.close();
                return true;
            } else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null)
                connection.disconnect();
            return false;
        }
    }

    private String getResponse() {
        try {

            InputStream    inputStream    = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String         line;
            StringBuilder  response       = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null)
                response.append(line).append('\n');

            bufferedReader.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return null;
    }

}
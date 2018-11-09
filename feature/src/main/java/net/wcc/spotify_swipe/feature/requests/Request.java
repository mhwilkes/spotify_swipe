package net.wcc.spotify_swipe.feature.requests;

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
    private URL                 url              = null; // The URL the HTTP request will be sent to.
    private Map<String, String> headerParameters = null; // The header parameters sent with the request.
    private String              urlParameters    = null; // The url parameters sent with the request.
    private Boolean             isPost           = null; // If true, execute as a POST request, otherwise execute as a GET request.

    public Request(String url, Map<String, String> headerParameters, Map<String, String> urlParameters, Boolean isPost) throws MalformedURLException {
        this.headerParameters = headerParameters;
        this.urlParameters = formatURLParameters(urlParameters);
        this.isPost = isPost;
        this.url = new URL(this.isPost ? url : url + '?' + this.urlParameters);
    }

    private String formatURLParameters(Map<String, String> urlParameters) {
        StringBuilder formattedURLParameters = new StringBuilder();

        for (Map.Entry<String, String> uP : urlParameters.entrySet()) {
            if (formattedURLParameters.length() > 0)
                formattedURLParameters.append('&');
            formattedURLParameters.append(uP.getKey()).append("=").append(uP.getValue());
        }

        return formattedURLParameters.toString();
    }

    // Simplest Request
    public Request(String url, boolean isPost) throws MalformedURLException {
        this.url = new URL(url);
        this.isPost = isPost;
    }

    public String execute() {
        return (makeRequest() ? getResponse() : null);
    }

    private Boolean makeRequest() {

        try {
            this.connection = (HttpURLConnection) url.openConnection();

            this.connection.setUseCaches(false);
            this.connection.setDoOutput(true);

            this.connection.setRequestMethod(this.isPost ? "POST" : "GET");

            this.connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            for (Map.Entry<String, String> hP : headerParameters.entrySet()) {
                this.connection.setRequestProperty(hP.getKey(), hP.getValue());
            }

            if (this.isPost) {
                this.connection.setRequestProperty("Content-Length", "" + Integer.toString(this.urlParameters.getBytes().length));

                DataOutputStream wr = new DataOutputStream(this.connection.getOutputStream());
                wr.writeBytes(this.urlParameters);
                wr.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (this.connection != null)
                this.connection.disconnect();
            return false;
        }

        return true;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    private String getResponse() {
        try {

            InputStream    inputStream    = this.connection.getInputStream();
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
            if (this.connection != null)
                this.connection.disconnect();
        }

        return null;
    }

}
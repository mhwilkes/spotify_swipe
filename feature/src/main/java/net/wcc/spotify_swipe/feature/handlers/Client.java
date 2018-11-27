package net.wcc.spotify_swipe.feature.handlers;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.Base64;

public class Client {
    private final static OkHttpClient client = new OkHttpClient();
    private static       Client       cacheClient;
    private final        Gson         gson   = new Gson();
    private              AccessToken  authorizationToken;
    private              AuthHandler  authHandler;
    private              String       clientCredentials;

    /**
     * @param client_id
     * @param client_secret
     *
     * @throws IOException
     */
    public Client(String client_id, String client_secret) throws IOException {

        clientCredentials = Base64.getEncoder().encodeToString((client_id + ":" + client_secret).getBytes());
        authHandler = new AuthHandler(clientCredentials);
        authorizationToken = authHandler.getAccessToken();
        cacheClient = this;
    }

    public static Client requestClient() {
        return cacheClient;
    }

    /**
     * @return
     */
    public static OkHttpClient getClient() {
        return client;
    }

    /**
     * @return
     */
    public AccessToken getAuthorizationToken() {
        return authorizationToken;
    }

    /**
     * @return
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * @return
     */
    public AuthHandler getAuthHandler() {
        return authHandler;
    }

    /**
     * @return
     */
    public String getClientCredentials() {
        return clientCredentials;
    }
}

package net.wcc.spotify_swipe.feature.handlers;

import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.models.AccessToken;

public class AuthHandler {

    private String      client_id;
    private String      client_secret;
    private AccessToken accessToken;

    private AccessToken getAccessToken(String client_id, String client_secret){
        Gson gson = new Gson();
        return gson.fromJson(/*TODO: string returned from request*/ new String(), AccessToken.class);
    }

    public AuthHandler(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.accessToken = getAccessToken(this.client_id, this.client_secret);
    }

}

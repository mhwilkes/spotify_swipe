package net.wcc.spotify_swipe.feature.models;

public class AccessToken {

    private String access_token;
    private String token_type;
    private int expires_in;

    public AccessToken(){

    }

    public String getAccessToken() {
        return access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public String getAuthHeader() {
        return "Authorization: " + token_type + " " + access_token;
    }
}

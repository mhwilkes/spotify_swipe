package net.wcc.spotify_swipe.feature.requests;

public class AccessToken {

    private AccessToken token;
    private String      access_token;
    private String      token_type;
    private int         expires_in;

    public AccessToken(AccessToken accessToken) {
        this.access_token = accessToken.toString();
        this.token_type = accessToken.getTokenType();
        this.expires_in = accessToken.getExpiresIn();
        this.token = accessToken;
    }

    public String getTokenType() {
        return token_type;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public AccessToken getAccessToken() {
        return token;
    }

    public String getAuthHeader() {
        return token_type + " " + access_token;
    }
}

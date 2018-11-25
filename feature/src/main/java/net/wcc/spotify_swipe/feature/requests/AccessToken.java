package net.wcc.spotify_swipe.feature.requests;

import java.util.Date;

public class AccessToken {

    private Date   creation_time;
    private String access_token;
    private String token_type;
    private int    expires_in;
    private String scope;

    public AccessToken(String access_token, String token_type, int expires_in, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;
        creation_time = new Date();
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }

}

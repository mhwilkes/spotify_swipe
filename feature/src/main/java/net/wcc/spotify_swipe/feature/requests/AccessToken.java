package net.wcc.spotify_swipe.feature.requests;

import net.wcc.spotify_swipe.feature.handlers.AuthHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessToken {

    private static String cachedToken;
    private static Date   creation_time;
    private        String access_token;
    private        String token_type;
    private        int    expires_in;
    private        String scope;

    public AccessToken(String access_token, String token_type, int expires_in, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        creation_time = new Date();
        this.cachedToken = access_token;
    }

    public static Date getCreation_time() {
        return creation_time;
    }

    public static synchronized String getCachedToken() {
        return cachedToken;
    }

    public static synchronized String refreshToken(String client_id, String client_secret) throws IOException {
        return new AuthHandler(client_id, client_secret).getAccessToken().getAccess_token();
    }

    public String getToken_type() {
        return token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }

}

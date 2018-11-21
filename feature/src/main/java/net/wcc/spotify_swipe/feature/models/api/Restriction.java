package net.wcc.spotify_swipe.feature.models.api;

public class Restriction {
    private String reason;

    public Restriction(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

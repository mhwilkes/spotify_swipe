package net.wcc.spotify_swipe.feature.models.api;

public class Restriction {
    private String reason;

    /**
     * @param reason
     */
    public Restriction(String reason) {
        this.reason = reason;
    }
    /**
     * @return
     */
    public String getReason() {
        return reason;
    }
}

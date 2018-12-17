package net.wcc.spotify_swipe.feature.models.api;

public class Restriction {
    private String reason;

    /**
     * @param reason Restriction Reason
     */
    public Restriction(String reason) {
        this.reason = reason;
    }
    /**
     * @return Restriction Message Reason
     */
    public String getReason() {
        return reason;
    }
}

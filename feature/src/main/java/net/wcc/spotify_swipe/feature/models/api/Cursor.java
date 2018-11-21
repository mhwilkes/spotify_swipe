package net.wcc.spotify_swipe.feature.models.api;

public class Cursor {
    private String after;

    public Cursor(String after) {
        this.after = after;
    }

    public String getAfter() {
        return after;
    }
}

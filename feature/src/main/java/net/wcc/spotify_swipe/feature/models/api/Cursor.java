package net.wcc.spotify_swipe.feature.models.api;

public class Cursor {

    private String after;

    /**
     * @param after
     */
    public Cursor(String after) {
        this.after = after;
    }

    /**
     * @return
     */
    public String getAfter() {
        return after;
    }
}

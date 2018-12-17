package net.wcc.spotify_swipe.feature.models.api;

public class Cursor {

    private String after;

    /**
     * @param after Next Item
     */
    public Cursor(String after) {
        this.after = after;
    }

    /**
     * @return Next
     */
    public String getAfter() {
        return after;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class Followers {
    private String href;
    private int    total;

    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

    public String getHref() {
        return href;
    }

    public int getTotal() {
        return total;
    }
}

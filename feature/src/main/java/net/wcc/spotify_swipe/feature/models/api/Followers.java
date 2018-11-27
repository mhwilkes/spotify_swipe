package net.wcc.spotify_swipe.feature.models.api;

public class Followers {
    private String href;
    private int    total;

    /**
     * @param href
     * @param total
     */
    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

    /**
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * @return
     */
    public int getTotal() {
        return total;
    }
}

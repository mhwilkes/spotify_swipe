package net.wcc.spotify_swipe.feature.models.api;

public class Followers {

    private String href;
    private int    total;

    /**
     * @param href Page of Followers
     * @param total Total #
     */
    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

    /**
     * @return get Followers Page
     */
    public String getHref() {
        return href;
    }

    /**
     * @return Total # of Followers
     */
    public int getTotal() {
        return total;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class CoverImage {
    private int    height;
    private String url;
    private int    width;

    /**
     * @param height
     * @param url
     * @param width
     */
    public CoverImage(int height, String url, int width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    /**
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return
     */
    public String getUrl() {
        return url;
    }
}

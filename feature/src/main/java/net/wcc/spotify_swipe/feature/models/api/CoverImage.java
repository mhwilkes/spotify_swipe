package net.wcc.spotify_swipe.feature.models.api;

public class CoverImage {

    private int    height;
    private String url;
    private int    width;

    /**
     * @param height Height of Image
     * @param url URL for image
     * @param width Width of Image
     */
    public CoverImage(int height, String url, int width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    /**
     * @return Height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return Width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return URL to Load
     */
    public String getUrl() {
        return url;
    }
}

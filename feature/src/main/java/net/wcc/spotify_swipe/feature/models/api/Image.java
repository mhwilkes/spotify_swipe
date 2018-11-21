package net.wcc.spotify_swipe.feature.models.api;

public class Image {
    private int    height;
    private String url;
    private int    width;

    public Image(int height, String url, int width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getUrl() {
        return url;
    }
}

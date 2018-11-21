package net.wcc.spotify_swipe.feature.models.api;

public class Copyright {
    private String text, type;

    public Copyright(String text, String type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class Copyright {
    private String text, type;

    /**
     * @param text
     * @param type
     */
    public Copyright(String text, String type) {
        this.text = text;
        this.type = type;
    }

    /**
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }
}

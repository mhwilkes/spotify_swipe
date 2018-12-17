package net.wcc.spotify_swipe.feature.models.api;

public class Copyright {

    private String text, type;

    /**
     * @param text Copyright Text
     * @param type Copyright Type
     */
    public Copyright(String text, String type) {
        this.text = text;
        this.type = type;
    }

    /**
     * @return Info for Copyright
     */
    public String getText() {
        return text;
    }

    /**
     * @return Type of Copyright
     */
    public String getType() {
        return type;
    }
}

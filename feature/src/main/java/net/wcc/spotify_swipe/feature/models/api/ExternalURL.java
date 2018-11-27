package net.wcc.spotify_swipe.feature.models.api;

public class ExternalURL {
    private String key, value;

    /**
     * @param key
     * @param value
     */
    public ExternalURL(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * @return
     */
    public String getValue() {
        return value;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class ExternalID {
    private String key, value;

    /**
     * @param key
     * @param value
     */
    public ExternalID(String key, String value) {
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

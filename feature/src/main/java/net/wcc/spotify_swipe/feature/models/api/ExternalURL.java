package net.wcc.spotify_swipe.feature.models.api;

public class ExternalURL {

    private String key, value;

    /**
     * @param key   Key for External URL
     * @param value Value of External URL
     */
    public ExternalURL(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return Key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return Value
     */
    public String getValue() {
        return value;
    }
}

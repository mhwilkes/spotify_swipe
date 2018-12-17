package net.wcc.spotify_swipe.feature.models.api;

public class ExternalID {

    private String key, value;

    /**
     * @param key   Key for External ID
     * @param value Value of External ID
     */
    public ExternalID(String key, String value) {
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

package net.wcc.spotify_swipe.feature.models.api;

public class ExternalURL {
    private String key, value;

    public ExternalURL(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

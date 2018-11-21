package net.wcc.spotify_swipe.feature.models.api;

public class Context {
    private String type, href, uri;
    private ExternalURL external_urls;

    public Context(String type, String href, ExternalURL external_urls, String uri) {
        this.type = type;
        this.href = href;
        this.external_urls = external_urls;
        this.uri = uri;

    }

    public String getType() {
        return type;
    }

    public String getHref() {
        return href;
    }

    public String getUri() {
        return uri;
    }

    public ExternalURL getExternal_urls() {
        return external_urls;
    }
}

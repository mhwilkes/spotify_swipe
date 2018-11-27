package net.wcc.spotify_swipe.feature.models.api;

public class Context {
    private String type, href, uri;
    private ExternalURL external_urls;

    /**
     * @param type
     * @param href
     * @param external_urls
     * @param uri
     */
    public Context(String type, String href, ExternalURL external_urls, String uri) {
        this.type = type;
        this.href = href;
        this.external_urls = external_urls;
        this.uri = uri;

    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * @return
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }
}

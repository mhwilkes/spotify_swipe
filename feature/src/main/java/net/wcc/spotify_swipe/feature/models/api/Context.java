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
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @return URL to Context
     */
    public String getHref() {
        return href;
    }

    /**
     * @return URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return External URLS
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }
}

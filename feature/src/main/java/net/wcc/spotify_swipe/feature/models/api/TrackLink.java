package net.wcc.spotify_swipe.feature.models.api;

public class TrackLink {
    private ExternalURL external_urls;
    private String      href, id, type, uri;

    /**
     * @param external_urls
     * @param href
     * @param id
     * @param type
     * @param uri
     */
    public TrackLink(ExternalURL external_urls, String href, String id, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
    }

    /**
     * @return
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
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
    public String getId() {
        return id;
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
    public String getUri() {
        return uri;
    }
}

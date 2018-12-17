package net.wcc.spotify_swipe.feature.models.api;

public class TrackLink {
    private ExternalURL external_urls;
    private String      href, id, type, uri;

    /**
     * @param external_urls External URL Object
     * @param href URL to API Access
     * @param id Track ID
     * @param type Track Type
     * @param uri Track URI
     */
    public TrackLink(ExternalURL external_urls, String href, String id, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
    }

    /**
     * @return External URL
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    /**
     * @return URL to API Access
     */
    public String getHref() {
        return href;
    }

    /**
     * @return Track ID
     */
    public String getId() {
        return id;
    }

    /**
     * @return Track Type
     */
    public String getType() {
        return type;
    }

    /**
     * @return Track URI
     */
    public String getUri() {
        return uri;
    }
}

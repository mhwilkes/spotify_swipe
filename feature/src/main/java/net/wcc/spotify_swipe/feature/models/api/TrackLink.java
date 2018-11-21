package net.wcc.spotify_swipe.feature.models.api;

import net.wcc.spotify_swipe.feature.models.api.ExternalURL;

public class TrackLink {
    private ExternalURL external_urls;
    private String      href, id, type, uri;

    public TrackLink(ExternalURL external_urls, String href, String id, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.type = type;
        this.uri = uri;
    }

    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}

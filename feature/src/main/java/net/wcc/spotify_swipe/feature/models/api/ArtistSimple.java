package net.wcc.spotify_swipe.feature.models.api;

public class ArtistSimple {

    /**
     * Known external URLs for this artist.
     */
    private ExternalURL external_urls;

    /**
     * A link to the Web API endpoint providing full details of the artist.
     */
    private String href;

    /**
     * The Spotify ID for the artist.
     */
    private String id;

    /**
     * The name of the artist
     */
    private String name;

    /**
     * The object type: "artist"
     */
    private String type;

    private String uri;

    public ArtistSimple(ExternalURL external_urls, String href, String id, String name, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}

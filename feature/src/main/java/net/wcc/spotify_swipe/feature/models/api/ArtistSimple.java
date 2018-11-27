package net.wcc.spotify_swipe.feature.models.api;

public class ArtistSimple {
    private ExternalURL external_urls;
    private String      href;
    private String      id;
    private String      name;
    private String      type;
    private String      uri;

    /**
     * @param external_urls
     *         Known external URLs for this artist.
     * @param href
     *         A link to the Web API endpoint providing full details of the artist.
     * @param id
     *         The Spotify ID for the artist.
     * @param name
     *         The name of the artist
     * @param type
     *         The object type: "artist"
     * @param uri
     *         The Spotify URI for the album.
     */
    public ArtistSimple(ExternalURL external_urls, String href, String id, String name, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.name = name;
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
    public String getName() {
        return name;
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

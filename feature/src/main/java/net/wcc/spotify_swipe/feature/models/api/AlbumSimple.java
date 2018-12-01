package net.wcc.spotify_swipe.feature.models.api;

public class AlbumSimple {

    private String       album_group;
    private String       album_type;
    private Artist[]     artists;
    private String[]     available_markets;
    private ExternalURL  external_urls;
    private String       href;
    private String       id;
    private CoverImage[] images;
    private String       name;
    private String       release_date;
    private String       release_date_precision;
    private Restriction  restrictions;
    private String       type;
    private String       uri;

    /**
     * @param album_type
     *         The type of the album: one of "album" , "single" , or "compilation".
     * @param artists
     *         The artists of the album. Each artist object includes a link in href to more detailed information about
     *         the artist.
     * @param available_markets
     *         The markets in which the album is available: ISO 3166-1 alpha-2 country codes. Note that an album is
     *         considered available in a market when at least 1 of its tracks is available in that market.
     * @param external_urls
     *         Known external URLs for this album.
     * @param href
     *         A link to the Web API endpoint providing full details of the album.
     * @param id
     *         The Spotify ID for the album.
     * @param images
     *         The cover art for the album in various sizes, widest first.
     * @param name
     *         The name of the album. In case of an album take down, the value may be an empty string.
     * @param release_date
     * @param release_date_precision
     *         The date the album was first released, for example "1981-12-15". Depending on the precision, it might be
     *         shown as "1981" or "1981-12".
     * @param restrictions
     *         The precision with which release_date value is known: "year" , "month" , or "day".
     * @param type
     *         The object type: “album”
     * @param uri
     *         The Spotify URI for the album.
     */
    public AlbumSimple(String album_group, String album_type, Artist[] artists, String[] available_markets,
                       ExternalURL external_urls, String href, String id, CoverImage[] images, String name, String
                               release_date, String release_date_precision, Restriction restrictions, String type,
                       String uri) {
        this.album_group = album_group;
        this.album_type = album_type;
        this.artists = artists;
        this.available_markets = available_markets;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.release_date = release_date;
        this.release_date_precision = release_date_precision;
        this.restrictions = restrictions;
        this.type = type;
        this.uri = uri;
    }

    /**
     * @return
     */
    public String getAlbum_group() {
        return album_group;
    }

    /**
     * @return
     */
    public String getAlbum_type() {
        return album_type;
    }

    /**
     * @return
     */
    public Artist[] getArtists() {
        return artists;
    }

    /**
     * @return
     */
    public String[] getAvailable_markets() {
        return available_markets;
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
    public CoverImage[] getImages() {
        return images;
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
    public String getRelease_date() {
        return release_date;
    }

    /**
     * @return
     */
    public String getRelease_date_precision() {
        return release_date_precision;
    }

    /**
     * @return
     */
    public Restriction getRestrictions() {
        return restrictions;
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

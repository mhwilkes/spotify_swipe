package net.wcc.spotify_swipe.feature.models.api;


public class AlbumSimple {

    private String album_group;
    /**
     * The type of the album: one of "album" , "single" , or "compilation".
     */
    private String album_type;

    /**
     * The artists of the album. Each artist object includes a link in href to more detailed information about the
     * artist.
     */
    private Artist[] artists;

    /**
     * The markets in which the album is available: ISO 3166-1 alpha-2 country codes. Note that an album is
     * considered available in a market when at least 1 of its tracks is available in that market.
     */
    private String[] available_markets;


    /**
     * Known external URLs for this album.
     */
    private ExternalURL external_urls;


    /**
     * A link to the Web API endpoint providing full details of the album.
     */
    private String href;

    /**
     * The Spotify ID for the album.
     */
    private String id;

    /**
     * The cover art for the album in various sizes, widest first.
     */
    private Image[] images;

    /**
     * The name of the album. In case of an album takedown, the value may be an empty string.
     */
    private String name;

    /**
     * The date the album was first released, for example "1981-12-15". Depending on the precision, it might be shown
     * as "1981" or "1981-12".
     */
    private String release_date;

    /**
     * The precision with which release_date value is known: "year" , "month" , or "day".
     */
    private String release_date_precision;

    private Restriction restrictions;

    /**
     * The object type: “album”
     */
    private String type;

    /**
     * The Spotify URI for the album.
     */
    private String uri;

    public AlbumSimple(String album_group, String album_type, Artist[] artists, String[] available_markets,
            ExternalURL external_urls, String href, String id, Image[] images, String name, String release_date,
            String release_date_precision, Restriction restrictions, String type, String uri) {
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

    public String getAlbum_group() {
        return album_group;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public String[] getAvailable_markets() {
        return available_markets;
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

    public Image[] getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRelease_date_precision() {
        return release_date_precision;
    }

    public Restriction getRestrictions() {
        return restrictions;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}

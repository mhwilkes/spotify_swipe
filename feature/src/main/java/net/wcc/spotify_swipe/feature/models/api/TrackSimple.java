package net.wcc.spotify_swipe.feature.models.api;

public class TrackSimple {

    private ArtistSimple[] artists;
    private String[]       available_markets;
    private int            disc_number;
    private int            duration_ms;
    private Boolean        explicit;
    private ExternalURL    external_urls;
    private String         href;
    private String         id;
    private Boolean        is_playable;
    private TrackLink      linked_from;
    private Restriction    restrictions;
    private String         name;
    private String         preview_url;
    private int            track_number;
    private String         type;
    private String         uri;
    private Boolean        is_local;

    /**
     * @param artists
     *         The artists who performed the track. Each artist object includes a link in href to more detailed
     *         information about the artist.
     * @param available_markets
     *         A list of the countries in which the track can be played, identified by their
     *         <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 code.</a>
     * @param disc_number
     *         The disc number (usually 1 unless the album consists of more than one disc).
     * @param duration_ms
     *         The track length in milliseconds.
     * @param explicit
     *         Whether or not the track has explicit lyrics ( true = yes it does; false = no it does not OR unknown).
     * @param external_urls
     *         Known external URLs for this track.
     * @param href
     *         A link to the Web API endpoint providing full details of the track.
     * @param id
     *         The Spotify ID for the track.
     * @param is_playable
     *         Part of the response when Track Relinking is applied. If true , the track is playable in the given
     *         market. Otherwise false.
     * @param linked_from
     *         Part of the response when Track Relinking is applied, and the requested track has been replaced with
     *         different track. The track in the linked_from object contains information about the originally requested
     *         track.
     * @param restrictions
     *         Part of the response when Track Relinking is applied, the original track is not available in the given
     *         market, and Spotify did not have any tracks to relink it with. The track response will still contain
     *         metadata for the original track, and a restrictions object containing the reason why the track is not
     *         available: "restrictions" : {"reason" : "market"}
     * @param name
     *         The name of the track.
     * @param preview_url
     *         A link to a 30 second preview (MP3 format) of the track. Can be null
     * @param track_number
     *         The number of the track. If an album has several discs, the track number is the number on the specified
     *         disc.
     * @param type
     *         The object type: “track”.
     * @param uri
     *         The Spotify URI for the track.
     * @param is_local
     *         Whether the track is local or not
     */
    public TrackSimple(ArtistSimple[] artists, String[] available_markets, int disc_number, int duration_ms, Boolean
            explicit, ExternalURL external_urls, String href, String id, Boolean is_playable, TrackLink linked_from,
                       Restriction restrictions, String name, String preview_url, int track_number, String type,
                       String uri, Boolean is_local) {
        this.artists = artists;
        this.available_markets = available_markets;
        this.disc_number = disc_number;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.is_playable = is_playable;
        this.linked_from = linked_from;
        this.restrictions = restrictions;
        this.name = name;
        this.preview_url = preview_url;
        this.track_number = track_number;
        this.type = type;
        this.uri = uri;
        this.is_local = is_local;
    }

    /**
     * @return array of all Artists
     */
    public ArtistSimple[] getArtists() {
        return artists;
    }

    /**
     * @return an array of available markets
     */
    public String[] getAvailable_markets() {
        return available_markets;
    }

    /**
     * @return the disc number
     */
    public int getDisc_number() {
        return disc_number;
    }

    /**
     * @return the duration in ms
     */
    public int getDuration_ms() {
        return duration_ms;
    }

    /**
     * @return if explicit
     */
    public Boolean getExplicit() {
        return explicit;
    }

    /**
     * @return external URL to song
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
     * @return track ID
     */
    public String getId() {
        return id;
    }

    /**
     * @return if playable
     */
    public Boolean getIs_playable() {
        return is_playable;
    }

    /**
     * @return
     */
    public TrackLink getLinked_from() {
        return linked_from;
    }

    /**
     * @return track restrictions
     */
    public Restriction getRestrictions() {
        return restrictions;
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
    public String getPreview_url() {
        return preview_url;
    }

    /**
     * @return
     */
    public int getTrack_number() {
        return track_number;
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

    /**
     * @return
     */
    public Boolean getIs_local() {
        return is_local;
    }
}

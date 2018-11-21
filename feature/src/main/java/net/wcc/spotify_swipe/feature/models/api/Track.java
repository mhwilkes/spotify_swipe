package net.wcc.spotify_swipe.feature.models.api;


import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Track {

    private static String endpoint = "https://api.spotify.com/v1/tracks/";

    /**
     * The album on which the track appears. The album object includes a link in href to full information about the
     * album
     */
    private AlbumSimple album;

    /**
     * The artists who performed the track. Each artist object includes a link in href to more detailed information
     * about the artist.
     */
    private ArtistSimple[] artists;

    /**
     * A list of the countries in which the track can be played, identified by their
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 code.</a>
     */
    private String[] available_markets;

    /**
     * The disc number (usually 1 unless the album consists of more than one disc).
     */
    private int disc_number;

    /**
     * The track length in milliseconds.
     */
    private int duration_ms;

    /**
     * Whether or not the track has explicit lyrics ( true = yes it does; false = no it does not OR unknown).
     */
    private Boolean explicit;

    /**
     * Known external IDs for the track.
     */
    private ExternalID external_ids;

    /**
     * Known external URLs for this track.
     */
    private ExternalURL external_urls;

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    private String href;

    /**
     * The Spotify ID for the track.
     */
    private String id;

    /**
     * Part of the response when Track Relinking is applied. If true , the track is playable in the given market.
     * Otherwise false.
     */
    private Boolean is_playable;

    /**
     * Part of the response when Track Relinking is applied, and the requested track has been replaced with different
     * track. The track in the linked_from object contains information about the originally requested track.
     */
    private TrackLink linked_from;

    /**
     * Part of the response when Track Relinking is applied, the original track is not available in the given market,
     * and Spotify did not have any tracks to relink it with. The track response will still contain metadata for the
     * original track, and a restrictions object containing the reason why the track is not available: "restrictions"
     * : {"reason" : "market"}
     */
    private Restriction restrictions;

    /**
     * The name of the track.
     */
    private String name;

    /**
     * The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.
     * The popularity of a track is a value between 0 and 100, with 100 being the most popular. The popularity is
     * calculated by algorithm and is based, in the most part, on the total number of plays the track has had and how
     * recent those plays are.
     * Generally speaking, songs that are being played a lot now will have a higher popularity than songs that were
     * played a lot in the past. Duplicate tracks (e.g. the same track from a single and an album) are rated
     * independently. Artist and album popularity is derived mathematically from track popularity. Note that the
     * popularity value may lag actual popularity by a few days: the value is not updated in real time.
     */
    private int popularity;

    /**
     * A link to a 30 second preview (MP3 format) of the track. Can be null
     */
    private String preview_url;

    /**
     * The number of the track. If an album has several discs, the track number is the number on the specified disc.
     */
    private int track_number;

    /**
     * The object type: “track”.
     */
    private String type;

    /**
     * The Spotify URI for the track.
     */
    private String uri;

    private Boolean is_local;

    public Track(AlbumSimple album, ArtistSimple[] artists, String[] available_markets, int disc_number, int
            duration_ms, Boolean explicit, ExternalID external_ids, ExternalURL external_urls, String href, String
            id, Boolean is_playable, TrackLink linked_from, Restriction restrictions, String name, int popularity,
            String preview_url, int track_number, String type, String uri, Boolean is_local) {

        this.album = album;
        this.artists = artists;
        this.available_markets = available_markets;
        this.disc_number = disc_number;
        this.duration_ms = duration_ms;
        this.explicit = explicit;
        this.external_ids = external_ids;
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.is_playable = is_playable;
        this.linked_from = linked_from;
        this.restrictions = restrictions;
        this.name = name;
        this.popularity = popularity;
        this.preview_url = preview_url;
        this.track_number = track_number;
        this.type = type;
        this.uri = uri;
        this.is_local = is_local;
    }

    public static Track requestTrack(String ID, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track.class);
    }

    public static Track requestTrack(String ID, String market, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint + ID + "?market=" + market).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + "" + a.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track.class);
    }

    final public Track[] requestTracks(String[] IDS, AccessToken a) throws IOException {
        StringBuilder sb = new StringBuilder(endpoint + "?ids=");
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track[].class);
    }


    public Boolean getIs_local() {
        return is_local;
    }

    public AlbumSimple getAlbum() {
        return album;
    }

    public ArtistSimple[] getArtists() {
        return artists;
    }

    public String[] getAvailable_markets() {
        return available_markets;
    }

    public int getDisc_number() {
        return disc_number;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public ExternalID getExternal_ids() {
        return external_ids;
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

    public Boolean getIs_playable() {
        return is_playable;
    }

    public Object getLinked_from() {
        return linked_from;
    }

    public Object getRestrictions() {
        return restrictions;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public int getTrack_number() {
        return track_number;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
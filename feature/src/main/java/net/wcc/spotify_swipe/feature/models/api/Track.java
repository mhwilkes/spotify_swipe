package net.wcc.spotify_swipe.feature.models.api;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Track {

    private static final String         endpoint = "https://api.spotify.com/v1/tracks/"; //Local Endpoint
    private              AlbumSimple    album;
    private              ArtistSimple[] artists;
    private              String[]       available_markets;
    private              int            disc_number;
    private              int            duration_ms;
    private              Boolean        explicit;
    private              ExternalID     external_ids;
    private              ExternalURL    external_urls;
    private              String         href;
    private              String         id;
    private              Boolean        is_playable;
    private              TrackLink      linked_from;
    private              Restriction    restrictions;
    private              String         name;
    private              int            popularity;
    private              String         preview_url;
    private              int            track_number;
    private              String         type;
    private              String         uri;
    private              Boolean        is_local;

    /**
     * @param album             The album on which the track appears. The album object includes a link in href to full
     *                          information about
     *                          the album.
     * @param artists           The artists who performed the track. Each artist object includes a link in href to
     *                          more detailed
     *                          information about the artist.
     * @param available_markets A list of the countries in which the track can be played, identified by their
     *                          <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 code.</a>
     * @param disc_number       The disc number (usually 1 unless the album consists of more than one disc).
     * @param duration_ms       The track length in milliseconds.
     * @param explicit          Whether or not the track has explicit lyrics ( true = yes it does; false = no it does
     *                          not OR unknown).
     * @param external_urls     Known external URLs for this track.
     * @param href              A link to the Web API endpoint providing full details of the track.
     * @param id                The Spotify ID for the track.
     * @param is_playable       Part of the response when Track Relinking is applied. If true , the track is playable
     *                          in the given
     *                          market. Otherwise false.
     * @param linked_from       Part of the response when Track Relinking is applied, and the requested track has been
     *                          replaced with
     *                          different track. The track in the linked_from object contains information about the
     *                          originally requested
     *                          track.
     * @param restrictions      Part of the response when Track Relinking is applied, the original track is not
     *                          available in the given
     *                          market, and Spotify did not have any tracks to relink it with. The track response will
     *                          still contain
     *                          metadata for the original track, and a restrictions object containing the reason why
     *                          the track is not
     *                          available: "restrictions" : {"reason" : "market"}
     * @param name              The name of the track.
     * @param popularity        The popularity of the track. The value will be between 0 and 100, with 100 being the
     *                          most popular. The
     *                          popularity of a track is a value between 0 and 100, with 100 being the most popular.
     *                          The popularity is
     *                          calculated by algorithm and is based, in the most part, on the total number of plays
     *                          the track has had
     *                          and how recent those plays are. Generally speaking, songs that are being played a lot
     *                          now will have a
     *                          higher popularity than songs that were played a lot in the past. Duplicate tracks
     *                          (e.g. the same track
     *                          from a single and an album) are rated independently. Artist and album popularity is
     *                          derived
     *                          mathematically from track popularity. Note that the popularity value may lag actual
     *                          popularity by a few
     *                          days: the value is not updated in real time.
     * @param preview_url       A link to a 30 second preview (MP3 format) of the track. Can be null
     * @param track_number      The number of the track. If an album has several discs, the track number is the number
     *                          on the specified
     *                          disc.
     * @param type              The object type: “track”.
     * @param uri               The Spotify URI for the track.
     * @param is_local          Whether the track is local or not
     */
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

        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /**
     *
     * @param ID ID of Track
     * @param at Access Token
     * @return Track
     * @throws IOException
     */
    public static Track requestTrack(String ID, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();
        Request request = new Request.Builder().url(getEndpoint() + ID).get().addHeader("Accept", "application/json")
                                               .addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at
                                                       .getAccess_token()).addHeader("cache-control", "no-cache")
                                               .build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Track.class);
    }

    /**
     * @return Endpoint for API URL
     */
    public static String getEndpoint() {
        return endpoint;
    }

    /**
     *
     * @param ID ID of Track
     * @param market Market for Track
     * @param at Access Token
     * @return Track
     * @throws IOException
     */
    public static Track requestTrack(String ID, String market, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();
        Request request = new Request.Builder().url(getEndpoint() + ID + "?market=" + market).get().addHeader
                ("Accept", "application/json").addHeader("Content-Type", "application/json").addHeader
                ("Authorization", "Bearer " + at.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Track.class);
    }

    /**
     *
     * @param IDS array Of Track ID's
     * @param at Access Token
     * @return array of Tracks
     * @throws IOException
     */
    public Track[] requestTracks(String[] IDS, AccessToken at) throws IOException {
        OkHttpClient  client = new OkHttpClient();
        Gson          gson   = new Gson();
        StringBuilder sb     = new StringBuilder(getEndpoint() + "?ids=");
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length - 1 > i ? IDS[i] : IDS[i] + ',');
        }

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                                               .addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at
                                                       .getAccess_token()).addHeader("cache-control", "no-cache")
                                               .build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Track[].class);
    }

    /**
     * @return Is Track Local
     */
    public Boolean getIs_local() {
        return is_local;
    }

    /**
     * @return Album of Track
     */
    public AlbumSimple getAlbum() {
        return album;
    }

    /**
     * @return Simple Artist
     */
    public ArtistSimple[] getArtists() {
        return artists;
    }

    /**
     * @return Markets Track is available in
     */
    public String[] getAvailable_markets() {
        return available_markets;
    }

    /**
     * @return Disc Number
     */
    public int getDisc_number() {
        return disc_number;
    }

    /**
     * @return Duration
     */
    public int getDuration_ms() {
        return duration_ms;
    }

    /**
     * @return Is Explicit
     */
    public Boolean getExplicit() {
        return explicit;
    }

    /**
     * @return External ID's
     */
    public ExternalID getExternal_ids() {
        return external_ids;
    }

    /**
     * @return External URL's
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    /**
     * @return URL to Track API Access
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
     * @return Is Playable
     */
    public Boolean getIs_playable() {
        return is_playable;
    }

    /**
     * @return Linked From
     */
    public Object getLinked_from() {
        return linked_from;
    }

    /**
     * @return Restrictions
     */
    public Restriction getRestrictions() {
        return restrictions;
    }

    /**
     * @return Track Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Track Popularity
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * @return Preview URL of Track
     */
    public String getPreview_url() {
        return preview_url;
    }

    /**
     * @return Track Number
     */
    public int getTrack_number() {
        return track_number;
    }

    /**
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @return URI
     */
    public String getUri() {
        return uri;
    }
}

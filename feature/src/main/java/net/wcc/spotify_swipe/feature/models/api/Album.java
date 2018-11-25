package net.wcc.spotify_swipe.feature.models.api;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Album {

    private static String endpoint = "https://api.spotify.com/v1/albums/";

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
     * The copyright statements of the album.
     */
    private Copyright[] copyrights;

    /**
     * Known external IDs for the album.
     */
    private ExternalID external_ids;

    /**
     * Known external URLs for this album.
     */
    private ExternalURL external_urls;

    /**
     * A list of the genres used to classify the album. For example: "Prog Rock" , "Post-Grunge". (If not yet
     * classified, the array is empty.)
     */
    private String[] genres;

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
     * The label for the album.
     */
    private String label;

    /**
     * The name of the album. In case of an album takedown, the value may be an empty string.
     */
    private String name;

    /**
     * The popularity of the album. The value will be between 0 and 100, with 100 being the most popular. The
     * popularity is calculated from the popularity of the album’s individual tracks.
     */
    private int popularity;

    /**
     * The date the album was first released, for example "1981-12-15". Depending on the precision, it might be shown
     * as "1981" or "1981-12".
     */
    private String release_date;

    private Restriction restrictions;

    /**
     * The precision with which release_date value is known: "year" , "month" , or "day".
     */
    private String release_date_precision;

    /**
     * The tracks of the album.
     */
    private Paging tracks;

    /**
     * The object type: “album”
     */
    private String type;

    /**
     * The Spotify URI for the album.
     */
    private String uri;


    //Full object
    public Album(String album_type, Artist[] artists, String[] available_markets, Copyright[] copyrights, ExternalID
            external_ids, ExternalURL external_urls, String[] genres, String href, String id, Image[] images, String
            label, String name, int popularity, String release_date, String release_date_precision, Restriction
            restrictions, Paging tracks, String type, String uri) {

        this.album_type = album_type;
        this.artists = artists;
        this.available_markets = available_markets;
        this.copyrights = copyrights;
        this.external_ids = external_ids;
        this.external_urls = external_urls;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.label = label;
        this.name = name;
        this.popularity = popularity;
        this.release_date = release_date;
        this.restrictions = restrictions;
        this.release_date_precision = release_date_precision;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;

        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    //Album with market Code
    public Album requestAlbum(String ID, String market, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint + ID + "?market=" + market).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + a.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Album.class);
    }

    // Basic Request
    public static Album requestAlbum(String ID, AccessToken a) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Album.class);
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

    public Copyright[] getCopyrights() {
        return copyrights;
    }

    public ExternalID getExternal_ids() {
        return external_ids;
    }

    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getHref() {
        return href;
    }

    public Image[] getImages() {
        return images;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRelease_date_precision() {
        return release_date_precision;
    }

    public Paging getTracks() {
        return tracks;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    final public Track[] requestAlbumTracks(Album a, AccessToken at) throws IOException {
        final String endpoint = getEndpoint() + a.getId() + "/tracks";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at.getAccess_token())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track[].class);

    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getId() {
        return id;
    }

    final public Album[] requestAlbums(String[] IDS, AccessToken a) throws IOException {
        StringBuilder sb = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + a
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Album[].class);
    }
}

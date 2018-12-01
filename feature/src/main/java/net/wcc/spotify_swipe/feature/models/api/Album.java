package net.wcc.spotify_swipe.feature.models.api;

import android.os.StrictMode;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Album {

    private static final String       endpoint = "https://api.spotify.com/v1/albums/"; //Local Endpoint
    private              String       album_type;
    private              Artist[]     artists;
    private              String[]     available_markets;
    private              Copyright[]  copyrights;
    private              ExternalID   external_ids;
    private              ExternalURL  external_urls;
    private              String[]     genres;
    private              String       href;
    private              String       id;
    private              CoverImage[] images;
    private              String       label;
    private              String       name;
    private              int          popularity;
    private              String       release_date;
    private              Restriction  restrictions;
    private              String       release_date_precision;
    private              Paging       tracks;
    private              String       type;
    private              String       uri;

    /**
     * @param album_type
     *         The type of the album: one of "album" , "single" , or "compilation".
     * @param artists
     *         The artists of the album. Each artist object includes a link in href to more detailed information about
     *         the artist.
     * @param available_markets
     *         The markets in which the album is available: ISO 3166-1 alpha-2 country codes. Note that an album is
     *         considered available in a market when at least 1 of its tracks is available in that market.
     * @param copyrights
     *         The copyright statements of the album.
     * @param external_ids
     *         Known external IDs for the album.
     * @param external_urls
     *         Known external URLs for this album.
     * @param genres
     *         A list of the genres used to classify the album. For example: "Prog Rock" , "Post-Grunge". (If not yet
     *         classified, the array is empty.)
     * @param href
     *         A link to the Web API endpoint providing full details of the album.
     * @param id
     *         The Spotify ID for the album.
     * @param images
     *         The cover art for the album in various sizes, widest first.
     * @param label
     *         The label for the album.
     * @param name
     *         The name of the album. In case of an album takedown, the value may be an empty string.
     * @param popularity
     *         The popularity of the album. The value will be between 0 and 100, with 100 being the most popular. The
     *         popularity is calculated from the popularity of the album’s individual tracks.
     * @param release_date
     * @param release_date_precision
     *         The date the album was first released, for example "1981-12-15". Depending on the precision, it might be
     *         shown as "1981" or "1981-12".
     * @param restrictions
     *         The precision with which release_date value is known: "year" , "month" , or "day".
     * @param tracks
     *         The tracks of the album.
     * @param type
     *         The object type: “album”
     * @param uri
     *         The Spotify URI for the album.
     */
    @SuppressWarnings("SpellCheckingInspection")
    public Album(String album_type, Artist[] artists, String[] available_markets, Copyright[] copyrights, ExternalID
            external_ids, ExternalURL external_urls, String[] genres, String href, String id, CoverImage[] images,
                 String label, String name, int popularity, String release_date, String release_date_precision,
                 Restriction restrictions, Paging tracks, String type, String uri) {

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

    /**
     * @param ID
     *
     * @return
     *
     * @throws IOException
     */
    public static Album requestAlbum(String ID, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();
        Request request = new Request.Builder().url(endpoint + ID).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Album.class);
    }

    /**
     * @param ID
     * @param market
     *
     * @return
     *
     * @throws IOException
     */
    //TODO this may be unnecessary, also find out why autoformat adds empty string literals
    @SuppressWarnings("SpellCheckingInspection")
    public Album requestAlbum(String ID, String market, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson         gson   = new Gson();
        Request request = new Request.Builder().url(endpoint + ID + "?market=" + market).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", at.getAuthHeader())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Album.class);
    }

    /**
     * @param a
     *
     * @return
     *
     * @throws IOException
     */
    final public Track[] requestAlbumTracks(Album a, AccessToken at) throws IOException {
        final String endpoint = getEndpoint() + a.getId() + "/tracks";
        OkHttpClient client   = new OkHttpClient();
        Gson         gson     = new Gson();
        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at.getAccess_token())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Track[].class);

    }

    /**
     * @return
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param IDS
     *
     * @return
     *
     * @throws IOException
     */
    public Album[] requestAlbums(String[] IDS, AccessToken at) throws IOException {
        StringBuilder sb     = new StringBuilder(endpoint);
        OkHttpClient  client = new OkHttpClient();
        Gson          gson   = new Gson();
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();

        return gson.fromJson(response.body().string(), Album[].class);
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
    public Copyright[] getCopyrights() {
        return copyrights;
    }

    /**
     * @return
     */
    public ExternalID getExternal_ids() {
        return external_ids;
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
    public String[] getGenres() {
        return genres;
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
    public CoverImage[] getCoverImages() {
        return images;
    }

    /**
     * @return
     */
    public String getLabel() {
        return label;
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
    public int getPopularity() {
        return popularity;
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
    public Paging getTracks() {
        return tracks;
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

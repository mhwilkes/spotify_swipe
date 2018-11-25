package net.wcc.spotify_swipe.feature.models.api;

import android.media.Image;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Artist {

    /**
     * Known external URLs for this artist.
     */
    private ExternalURL external_urls;

    private Followers followers;

    /**
     * Information about the followers of the artist.
     */
    private String[] genres;

    /**
     * A list of the genres the artist is associated with. For example: "Prog Rock" , "Post-Grunge". (If not yet
     * classified, the array is empty.)
     */
    private String href;

    /**
     * A link to the Web API endpoint providing full details of the artist.
     */
    private String id;

    /**
     * The Spotify ID for the artist.
     */
    private Image[] images;

    /**
     * Images of the artist in various sizes, widest first.
     */
    private String name;

    /**
     * The name of the artist
     */
    private int popularity;

    /**
     * The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The
     * artist’s popularity is calculated from the popularity of all the artist’s tracks.
     */
    private String type;

    /**
     * The object type: "artist"
     */
    private String uri;

    public Artist(ExternalURL external_urls, Followers followers, String[] genres, String href, String id, Image[]
            images, String name, int popularity, String type, String uri) {
        this.external_urls = external_urls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    public Followers getFollowers() {
        return followers;
    }

    public String getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    /*
    TODO: Get Artist, Get Artists Albums, Get Artists Top Tracks, Get Artists Related Artists, Get Several Artists
     */

    public static Artist requestArtist(String ID, AccessToken a) throws IOException {
        String endpoint = getEndpoint() + ID + "/albums/";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + a.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist.class);
    }

    public static Artist requestArtist(String ID, String include_groups, String market, int limit, int offset,
                                       AccessToken a) throws IOException {
        StringBuilder endpoint = new StringBuilder(getEndpoint() + ID + "/albums/");
        if (include_groups != null) {
            endpoint.append("?include_groups=").append(include_groups);
        }
        if (market != null) {
            endpoint.append("?market=" + market);
        }
        if (limit > 0 && limit <= 50) {
            endpoint.append("?endpoint=" + limit);
        }
        if (offset > 0) {
            endpoint.append("?offset=" + offset);
        }
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + a.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist.class);
    }

    public static String getEndpoint() {
        return "https://api.spotify.com/v1/artists/";
    }

    public AlbumSimple[] requestArtistAlbums(Artist a, String include_groups, String market, int limit, int offset,
                                             AccessToken at) throws IOException {
        StringBuilder endpoint = new StringBuilder(getEndpoint() + a.getID() + "/albums");
        if (include_groups != null) {
            endpoint.append("?include_groups=" + include_groups);
        }
        if (market != null) {
            endpoint.append("?market=" + market);
        }
        if (limit > 0 && limit <= 50) {
            endpoint.append("?endpoint=" + limit);
        }
        if (offset > 0) {
            endpoint.append("?offset=" + offset);
        }
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + at.getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AlbumSimple[].class);
    }

    public String getID() {
        return id;
    }

    public Track[] requestArtistTopTracks(Artist a, String market, AccessToken at) throws IOException {
        final String endpoint = getEndpoint() + a.getID() + "/top-tracks";
        OkHttpClient client   = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at.getAccess_token())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track[].class);
    }

    public Artist[] requestRelatedArtists(Artist a, AccessToken at) throws IOException {
        final String endpoint = getEndpoint() + a.getID() + "/related-artists";
        OkHttpClient client   = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at.getAccess_token())
                .addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist[].class);
    }

    public Artist[] requestArtists(String IDS[], AccessToken at) throws IOException {

        final String  endpoint = getEndpoint() + "?ids=";
        StringBuilder sb       = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at
                        .getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist[].class);

    }

}

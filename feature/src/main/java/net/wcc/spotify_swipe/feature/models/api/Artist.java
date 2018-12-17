package net.wcc.spotify_swipe.feature.models.api;

import android.os.StrictMode;
import com.google.gson.Gson;
import java.io.IOException;
import net.wcc.spotify_swipe.feature.requests.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Artist {

    private static final String       endpoint = "https://api.spotify.com/v1/artists/"; //Local Endpoint
    private              ExternalURL  external_urls;
    private              Followers    followers;
    private              String[]     genres;
    private              String       href;
    private              String       id;
    private              CoverImage[] images;
    private              String       name;
    private              int          popularity;
    private              String       type;
    private              String       uri;

    /**
     * @param external_urls Known external URLs for this artist.
     * @param followers     Information about the followers of the artist.
     * @param genres        A list of the genres the artist is associated with. For example: "Prog Rock" ,
     *                      "Post-Grunge". (If not yet
     *                      classified, the array is empty.)
     * @param href          A link to the Web API endpoint providing full details of the artist.
     * @param id            The Spotify ID for the artist.
     * @param images        Images of the artist in various sizes, widest first.
     * @param name          The name of the artist
     * @param popularity    The popularity of the artist. The value will be between 0 and 100, with 100 being the most
     *                      popular. The
     *                      artist’s popularity is calculated from the popularity of all the artist’s tracks.
     * @param type          The object type: "artist"
     * @param uri           The Spotify URI for the album.
     */
    public Artist(ExternalURL external_urls, Followers followers, String[] genres, String href, String id,
            CoverImage[]
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
        //TODO Not use the main thread for API Requests, develop ASYNC Policy
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /**
     * @param ID Artist ID
     * @param at Access Token
     */
    public static Artist requestArtist(String ID, AccessToken at) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(getEndpoint() + ID).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();
        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist.class);
    }

    /**
     * @param ID             Artist ID
     * @param include_groups Groups to include
     * @param market         Markets to take from
     * @param limit          Limit of artists received
     * @param offset         Offset used for paging results
     * @param a              Access Token
     * @return Artist Object
     */
    public static Artist requestArtist(String ID, String include_groups, String market, int limit, int offset,
            AccessToken a) throws IOException {
        StringBuilder endpoint = new StringBuilder(getEndpoint() + ID + "/albums/");
        if (include_groups != null) {
            endpoint.append("?include_groups=").append(include_groups);
        }
        if (market != null) {
            endpoint.append("?market=").append(market);
        }
        if (limit > 0 && limit <= 50) {
            endpoint.append("?endpoint=").append(limit);
        }
        if (offset > 0) {
            endpoint.append("?offset=" + offset);
        }
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + a.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();
        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist.class);
    }

    /**
     * @return Endpoint used for API requests
     */
    public static String getEndpoint() {
        return "https://api.spotify.com/v1/artists/";
    }

    /**
     * @param a              Artist
     * @param include_groups Groups to include
     * @param market         Markets to Use
     * @param limit          Limit of Results
     * @param offset         Offset used for Paging results
     * @param at             Access Token
     * @return array of AlbumSimple Objects
     */
    public AlbumSimple[] requestArtistAlbums(Artist a, String include_groups, String market, int limit, int offset,
            AccessToken at) throws IOException {
        StringBuilder endpoint = new StringBuilder(getEndpoint() + a.getID() + "/albums");
        if (include_groups != null) {
            endpoint.append("?include_groups=").append(include_groups);
        }
        if (market != null) {
            endpoint.append("&market=").append(market);
        }
        if (limit > 0 && limit <= 50) {
            endpoint.append("&endpoint=").append(limit);
        }
        if (offset > 0) {
            endpoint.append("&offset=").append(offset);
        }
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();
        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), AlbumSimple[].class);
    }

    /**
     * @return ID of Artist
     */
    public String getID() {
        return id;
    }

    /**
     * @param a      Artist Object
     * @param market Markets to Use
     * @param at     Access Token
     * @return Artist's Top Tracks
     */
    public Track[] requestArtistTopTracks(Artist a, String market, AccessToken at) throws IOException {
        final String endpoint = getEndpoint() + a.getID() + "/top-tracks/?market=" + market;
        OkHttpClient client   = new OkHttpClient();
        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + at.getAccess_token())
                                               .addHeader("cache-control", "no-cache").build();
        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Track[].class);
    }

    /**
     * @param a  Artist Object
     * @param at Access Token
     * @return array of Related Artists
     */
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

    /**
     * @param IDS array of Artist IDS
     * @param at  Access Token
     * @return array of Artists from requested ID's
     */
    public Artist[] requestArtists(String IDS[], AccessToken at) throws IOException {
        //TODO this may be messed up
        final String  endpoint = getEndpoint() + "?ids=";
        StringBuilder sb       = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length - 1 > i ? IDS[i] : IDS[i] + ',');
        }
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                                               .addHeader("Content-Type", "application/json")
                                               .addHeader("Authorization", "Bearer " + at
                                                       .getAccess_token()).addHeader("cache-control", "no-cache")
                                               .build();
        Response response = client.newCall(request).execute();
        Gson     gson     = new Gson();
        return gson.fromJson(response.body().string(), Artist[].class);
    }

    /**
     * @return Followers
     */
    public Followers getFollowers() {
        return followers;
    }

    /**
     * @return ID of Artist
     */
    public String getId() {
        return id;
    }

    /**
     * @return External URLS
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    /**
     * @return Genres
     */
    public String[] getGenres() {
        return genres;
    }

    /**
     * @return URL to API access for Artist
     */
    public String getHref() {
        return href;
    }

    /**
     * @return Images of Artist Cover
     */
    public CoverImage[] getImages() {
        return images;
    }

    /**
     * @return Name of Artist
     */
    public String getName() {
        return name;
    }

    /**
     * @return Popularity of Artist
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * @return Artist Type
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

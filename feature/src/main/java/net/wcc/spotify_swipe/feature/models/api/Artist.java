package net.wcc.spotify_swipe.feature.models.api;

import net.wcc.spotify_swipe.feature.handlers.Client;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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
     * @param external_urls
     *         Known external URLs for this artist.
     * @param followers
     *         Information about the followers of the artist.
     * @param genres
     *         A list of the genres the artist is associated with. For example: "Prog Rock" , "Post-Grunge". (If not yet
     *         classified, the array is empty.)
     * @param href
     *         A link to the Web API endpoint providing full details of the artist.
     * @param id
     *         The Spotify ID for the artist.
     * @param images
     *         Images of the artist in various sizes, widest first.
     * @param name
     *         The name of the artist
     * @param popularity
     *         The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The
     *         artist’s popularity is calculated from the popularity of all the artist’s tracks.
     * @param type
     *         The object type: "artist"
     * @param uri
     *         The Spotify URI for the album.
     */
    public Artist(ExternalURL external_urls, Followers followers, String[] genres, String href, String id,
                  CoverImage[] images, String name, int popularity, String type, String uri) {
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

    /**
     * @param ID
     *
     * @return
     *
     * @throws IOException
     */
    public static Artist requestArtist(String ID) throws IOException {
        String endpoint = getEndpoint() + ID;

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + Client
                .getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), Artist.class);
    }

    /**
     * @return
     */
    public static String getEndpoint() {
        return endpoint;
    }

    /**
     * @param ID
     * @param include_groups
     * @param market
     * @param limit
     * @param offset
     *
     * @return
     *
     * @throws IOException
     */
    public static Artist requestArtist(String ID, String include_groups, String market, int limit, int offset) throws
                                                                                                               IOException {
        StringBuilder endpoint = new StringBuilder(getEndpoint() + ID);
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

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" + "" +
                "" + "" + Client.getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache")
                .build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), Artist.class);
    }

    /**
     * @return
     */
    public Followers getFollowers() {
        return followers;
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
    public int getPopularity() {
        return popularity;
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
     * @param a
     * @param include_groups
     * @param market
     * @param limit
     * @param offset
     *
     * @return
     *
     * @throws IOException
     */
    public AlbumSimple[] requestArtistAlbums(Artist a, String include_groups, String market, int limit, int offset)
    throws IOException {
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

        Request request = new Request.Builder().url(endpoint.toString()).get().addHeader("Accept",
                "application/json").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " +
                "" + Client.getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), AlbumSimple[].class);
    }

    /**
     * @return
     */
    public String getID() {
        return id;
    }

    /**
     * @param a
     * @param market
     *
     * @return
     *
     * @throws IOException
     */
    public Track[] requestArtistTopTracks(Artist a, String market) throws IOException {
        final String endpoint = getEndpoint() + a.getID() + "/top-tracks";

        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + Client
                .getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), Track[].class);
    }

    /**
     * @param a
     *
     * @return
     *
     * @throws IOException
     */
    public Artist[] requestRelatedArtists(Artist a) throws IOException {
        final String endpoint = getEndpoint() + a.getID() + "/related-artists";

        Request request = new Request.Builder().url(endpoint).get().addHeader("Accept", "application/json").addHeader
                ("Content-Type", "application/json").addHeader("Authorization", "Bearer " + Client
                .getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), Artist[].class);
    }

    /**
     * @param IDS
     *
     * @return
     *
     * @throws IOException
     */
    public Artist[] requestArtists(String[] IDS) throws IOException {

        final String  endpoint = getEndpoint() + "?ids=";
        StringBuilder sb       = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        Request request = new Request.Builder().url(sb.toString()).get().addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + Client
                        .getAuthorizationToken().getAccess_token()).addHeader("cache-control", "no-cache").build();

        Response response = Client.getClient().newCall(request).execute();

        return Client.getGson().fromJson(response.body().string(), Artist[].class);

    }

}

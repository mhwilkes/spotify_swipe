package net.wcc.spotify_swipe.feature.models;

import android.media.Image;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.wcc.spotify_swipe.feature.requests.Request;
import org.json.JSONException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Album {

    private final String baseURL = "https://api.spotify.com/v1";


    /**
     * The type of the album: one of "album" , "single" , or "compilation".
     */
    private String album_type;

    /**
     * The artists of the album. Each artist object includes a link in href to more detailed information about the artist.
     */
    private Artist[] artists;

    /**
     * The markets in which the album is available: ISO 3166-1 alpha-2 country codes. Note that an album is considered available in a market when at least 1 of its tracks is available in that market.
     */
    private String[] available_markets;

    /**
     * The copyright statements of the album.
     */
    private String[] copyrights;

    /**
     * Known external IDs for the album.
     */
    private String[] external_ids;

    /**
     * Known external URLs for this album.
     */
    private URL[] external_urls;

    /**
     * A list of the genres used to classify the album. For example: "Prog Rock" , "Post-Grunge". (If not yet classified, the array is empty.)
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
     * The popularity of the album. The value will be between 0 and 100, with 100 being the most popular. The popularity is calculated from the popularity of the album’s individual tracks.
     */
    private int popularity;

    /**
     * The date the album was first released, for example "1981-12-15". Depending on the precision, it might be shown as "1981" or "1981-12".
     */
    private String release_date;

    /**
     * The precision with which release_date value is known: "year" , "month" , or "day".
     */
    private String release_date_precision;

    /**
     * The tracks of the album.
     */
    private Track[] tracks;

    /**
     * The object type: “album”
     */
    private String type;

    /**
     * The Spotify URI for the album.
     */
    private String uri;


    //Full object
    public Album(String album_type, Artist[] artists, String[] available_markets, String[] copyrights, String[] external_ids, URL[] external_urls, String[] genres, String href, String id, Image[] images, String label, String name, int popularity, String release_date, String release_date_precision, Track[] tracks, String type, String uri) {

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
        this.release_date_precision = release_date_precision;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;

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

    public String[] getCopyrights() {
        return copyrights;
    }

    public String[] getExternal_ids() {
        return external_ids;
    }

    public URL[] getExternal_urls() {
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

    public Track[] getTracks() {
        return tracks;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public Album requestAlbum(String ID) throws MalformedURLException, JSONException {
        final String endpoint = "/v1/albums/" + ID;
        Request      r        = new Request(ID, true);
        Gson         gson     = new Gson();

        Album a = gson.fromJson(r.execute(), Album.class);
        return a;
    }

    public ArrayList<Track> requestAlbumTracks(Album a) throws MalformedURLException {
        final String endpoint = "/v1/albums/" + a.getId() + "/tracks";

        Request requestTracks = new Request(endpoint, true);
        Gson    gson          = new Gson();

        //TODO parse all tracks on selected album and return

        return null; //TODO REMOVE THIS AFTER DONE
    }

    public String getId() {
        return id;
    }

    /*
    TODO: overloaded constructors + combinations for query to return
    TODO: Get Album , Get Album Tracks, Get Several Albums
     */

    public Album[] requestAlbums(String[] IDS) {
        final String  endpoint = "/v1/albums/";
        StringBuilder sb       = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        try {
            Request requestAlbums = new Request(sb.toString(), null, null, true);
            Gson    gson          = new Gson();
            gson.toJson(requestAlbums.execute());

            //TODO parse all albums from JSON, return Album Array

        } catch (MalformedURLException e) {
            e.printStackTrace(); //TODO Proper Handling
        }

        return null; //TODO REMOVE THIS AFTER DONE
    }
}

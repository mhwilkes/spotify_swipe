package net.wcc.spotify_swipe.feature.models;

import android.media.Image;
import com.google.gson.Gson;
import net.wcc.spotify_swipe.feature.requests.Request;

import java.net.MalformedURLException;
import java.net.URL;

public class Artist {

    // Get Artist Section

    /**
     * Known external URLs for this artist.
     */
    private URL[] external_urls;

    /**
     * Information about the followers of the artist.
     */
    private String[] genres;

    /**
     * A list of the genres the artist is associated with. For example: "Prog Rock" , "Post-Grunge". (If not yet classified, the array is empty.)
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
     * The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The artist’s popularity is calculated from the popularity of all the artist’s tracks.
     */
    private String type;

    /**
     * The object type: "artist"
     */
    private String uri;

    //Simple Artist
    public Artist(URL[] external_urls, String href, String id, String name, String type, String uri) {
        this.external_urls = external_urls;
        this.href = href;
        this.id = id;
        this.name = name;
        this.type = type;
        this.uri = uri;
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

    public Artist requestArtist(String ID) throws MalformedURLException {
        final String endpoint = "/v1/artists/" + ID;
        Gson         gson     = new Gson();
        Request      r        = new Request(endpoint, true);
        Artist       artist   = gson.fromJson(r.execute(), Artist.class);

        return artist;

    }

    public Album requestArtistAlbums(Artist a) throws MalformedURLException {
        final String endpoint = "/v1/artists/" + a.getID() + "/tracks";
        Request      r        = new Request(endpoint, true);
        Gson         gson     = new Gson();

        Album album = gson.fromJson(r.execute(), Album.class);
        return album;
    }

    public String getID() {
        return id;
    }

    public Track[] requestArtistTopTracks(Artist a, String market) {
        //Return top tracks

        return null; //TODO REMOVE THIS AFTER DONE
    }

    public Artist[] requestRelatedArtists(Artist a) {

        return null; //TODO REMOVE THIS AFTER DONE
    }

    public Artist[] requestArtists(String IDS[]) {

        final String  endpoint = "/v1/artists/";
        StringBuilder sb       = new StringBuilder(endpoint);
        for (int i = 0; i < IDS.length; i++) {
            sb.append(IDS.length == i ? IDS[i] : IDS[i] + ',');
        }

        //TODO Need to figure out parsing multiple artists from API Reply

        return null; //TODO REMOVE THIS AFTER DONE
    }

}

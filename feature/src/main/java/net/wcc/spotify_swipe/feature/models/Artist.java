package net.wcc.spotify_swipe.feature.models;

import android.media.Image;

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
    
    /*
    TODO: Get Artist, Get Artists Albums, Get Artists Top Tracks, Get Artists Related Artists, Get Several Artists
     */

}

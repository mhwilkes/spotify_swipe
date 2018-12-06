package net.wcc.spotify_swipe.feature.models.card;

import net.wcc.spotify_swipe.feature.models.api.Album;
import net.wcc.spotify_swipe.feature.models.api.Artist;
import net.wcc.spotify_swipe.feature.models.api.Track;

public class Card {

    public Track    song;
    public Track[]  songs;
    public Artist   artist;
    public Artist[] artists;
    public String   name, url, uri, coverArtURL;
    public int    duration;
    public int    id;
    public String text;
    public String img_url;
    public String description;

    public Card(String text, String description, String img_url) {
        this.id++;
        this.text = text;
        this.img_url = img_url;
        this.description = description;
    }

    public Card(Album album) {
        //TODO This looks funky, need to know if it works.
        this.songs = (Track[]) album.getTracks().getItems();
        this.artists = album.getArtists();
        this.id++;
    }

    public Card(Artist artist) {

    }

    public Card(Track track) {

    }

}

package net.wcc.spotify_swipe.feature.models.card;

import net.wcc.spotify_swipe.feature.models.api.Album;
import net.wcc.spotify_swipe.feature.models.api.Artist;
import net.wcc.spotify_swipe.feature.models.api.Track;

public class Card {

    public Track song;
    public Track[] songs;
    public Artist artist;
    public Artist[] artists;
    public String name, url, uri, coverArtURL;
    public int duration;

    public Card(Album album) {
        //TODO This looks funky, need to know if it works.
        this.songs = (Track[]) album.getTracks().getItems() ;
        this.artists = album.getArtists();
    }

    public Card(Artist artist) {

    }

    public Card(Track track) {

    }

}

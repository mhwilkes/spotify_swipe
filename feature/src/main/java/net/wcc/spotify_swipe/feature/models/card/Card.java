package net.wcc.spotify_swipe.feature.models.card;

import net.wcc.spotify_swipe.feature.models.api.ArtistSimple;
import net.wcc.spotify_swipe.feature.models.api.CoverImage;
import net.wcc.spotify_swipe.feature.models.api.Track;

public class Card {

    private Track          card_track;
    private String         song_name;
    private ArtistSimple[] song_artists;
    private CoverImage[]   song_cover;
    private String         image_url;
    private String         song_preview_url;
    private String         song_ID;

    //TODO add
    public Card(Track track) {
        this.song_name = track.getName();
        this.song_artists = track.getArtists();
        if (track.getAlbum().getImages() != null) {
            this.song_cover = track.getAlbum().getImages();
            this.image_url = this.song_cover[0].getUrl();
        }
        this.card_track = track;
        this.song_preview_url = track.getPreview_url();
        this.song_ID = track.getId();
    }

    public Track getCard_track() {
        return card_track;
    }

    public String getSong_name() {
        return song_name;
    }

    public ArtistSimple[] getSong_artists() {
        return song_artists;
    }

    public ArtistSimple getSong_artist(int position) {
        return song_artists[position];
    }

    public CoverImage[] getSong_cover() {
        return song_cover;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSong_preview_url() {
        return song_preview_url;
    }

    public String getSong_ID() {
        return song_ID;
    }
}

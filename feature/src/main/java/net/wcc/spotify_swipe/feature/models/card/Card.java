package net.wcc.spotify_swipe.feature.models.card;

import net.wcc.spotify_swipe.feature.models.api.AlbumSimple;
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
    private String         song_url;
    private AlbumSimple    mAlbumSimple;

    /**
     * Takes Track Object and sets essential Data for Card Object
     *
     * @param track Track for Card
     */
    public Card(Track track) {
        this.song_name = track.getName();
        this.song_artists = track.getArtists();
        if (track.getAlbum().getImages() != null) {
            this.song_cover = track.getAlbum().getImages();
            this.image_url = this.song_cover[0].getUrl();
        }
        this.song_url = track.getHref();
        this.card_track = track;
        this.song_preview_url = track.getPreview_url();
        this.song_ID = track.getId();
        this.mAlbumSimple = track.getAlbum();
    }

    /**
     *
     * @return Song's Spotify Track URL
     */
    public String getSong_url() {
        return song_url;
    }

    /**
     *
     * @return Album object with related album info
     */
    public AlbumSimple getAlbumSimple() {
        return mAlbumSimple;
    }

    /**
     *
     * @return Track object containing track info
     */
    public Track getCard_track() {
        return card_track;
    }

    /**
     *
     * @return the title of the track
     */
    public String getSong_name() {
        return song_name;
    }

    /**
     *
     * @return array of all artists
     */
    public ArtistSimple[] getSong_artists() {
        return song_artists;
    }

    /**
     *
     * @param position
     * @return Artist from array @ position position
     */
    public ArtistSimple getSong_artist(int position) {
        return song_artists[position];
    }

    /**
     *
     * @return CoverImage array containing related images
     */
    public CoverImage[] getSong_cover() {
        return song_cover;
    }

    /**
     *
     * @return cover image URL
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     *
     * @return song preview URL
     */
    public String getSong_preview_url() {
        return song_preview_url;
    }

    /**
     *
     * @return song ID
     */
    public String getSong_ID() {
        return song_ID;
    }
}

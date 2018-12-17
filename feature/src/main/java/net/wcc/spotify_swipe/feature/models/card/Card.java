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
     * @return
     */
    public String getSong_url() {
        return song_url;
    }

    /**
     *
     * @return
     */
    public AlbumSimple getAlbumSimple() {
        return mAlbumSimple;
    }

    /**
     *
     * @return
     */
    public Track getCard_track() {
        return card_track;
    }

    /**
     *
     * @return
     */
    public String getSong_name() {
        return song_name;
    }

    /**
     *
     * @return
     */
    public ArtistSimple[] getSong_artists() {
        return song_artists;
    }

    /**
     *
     * @param position
     * @return
     */
    public ArtistSimple getSong_artist(int position) {
        return song_artists[position];
    }

    /**
     *
     * @return
     */
    public CoverImage[] getSong_cover() {
        return song_cover;
    }

    /**
     *
     * @return
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     *
     * @return
     */
    public String getSong_preview_url() {
        return song_preview_url;
    }

    /**
     *
     * @return
     */
    public String getSong_ID() {
        return song_ID;
    }
}

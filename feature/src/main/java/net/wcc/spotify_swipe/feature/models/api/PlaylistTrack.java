package net.wcc.spotify_swipe.feature.models.api;

import java.security.Timestamp;

public class PlaylistTrack {

    private Timestamp added_at;
    private User      added_by;
    private Boolean   is_local;
    private Track     track;

    /**
     * @param added_at Timestamp when Added
     * @param added_by Who Added
     * @param is_local If track is Local
     * @param track Track
     */
    public PlaylistTrack(Timestamp added_at, User added_by, Boolean is_local, Track track) {
        this.added_at = added_at;
        this.added_by = added_by;
        this.is_local = is_local;
        this.track = track;
    }

    /**
     * @return Time Added
     */
    public Timestamp getAdded_at() {
        return added_at;
    }

    /**
     * @return User who Added
     */
    public User getAdded_by() {
        return added_by;
    }

    /**
     * @return If Track is Local
     */
    public Boolean getIs_local() {
        return is_local;
    }

    /**
     * @return Track
     */
    public Track getTrack() {
        return track;
    }
}

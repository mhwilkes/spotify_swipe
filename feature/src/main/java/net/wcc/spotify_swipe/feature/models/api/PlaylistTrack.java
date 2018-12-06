package net.wcc.spotify_swipe.feature.models.api;

import java.security.Timestamp;

public class PlaylistTrack {

    private Timestamp added_at;
    private User      added_by;
    private Boolean   is_local;
    private Track     track;

    /**
     * @param added_at
     * @param added_by
     * @param is_local
     * @param track
     */
    public PlaylistTrack(Timestamp added_at, User added_by, Boolean is_local, Track track) {
        this.added_at = added_at;
        this.added_by = added_by;
        this.is_local = is_local;
        this.track = track;
    }

    /**
     * @return
     */
    public Timestamp getAdded_at() {
        return added_at;
    }

    /**
     * @return
     */
    public User getAdded_by() {
        return added_by;
    }

    /**
     * @return
     */
    public Boolean getIs_local() {
        return is_local;
    }

    /**
     * @return
     */
    public Track getTrack() {
        return track;
    }
}

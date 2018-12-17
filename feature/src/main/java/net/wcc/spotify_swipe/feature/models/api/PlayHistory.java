package net.wcc.spotify_swipe.feature.models.api;

import java.security.Timestamp;

public class PlayHistory {

    private TrackSimple trackSimple;
    private Timestamp   played_at;
    private Context     context;

    /**
     * @param trackSimple Simple Track Object
     * @param played_at
     * @param context
     */
    public PlayHistory(TrackSimple trackSimple, Timestamp played_at, Context context) {
        this.trackSimple = trackSimple;
        this.played_at = played_at;
        this.context = context;
    }

    /**
     * @return
     */
    public TrackSimple getTrackSimple() {
        return trackSimple;
    }

    /**
     * @return
     */
    public Timestamp getPlayed_at() {
        return played_at;
    }

    /**
     * @return
     */
    public Context getContext() {
        return context;
    }
}

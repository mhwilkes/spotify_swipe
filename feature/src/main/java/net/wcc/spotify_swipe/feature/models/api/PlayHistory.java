package net.wcc.spotify_swipe.feature.models.api;

import java.security.Timestamp;

public class PlayHistory {

    private TrackSimple trackSimple;
    private Timestamp   played_at;
    private Context     context;

    /**
     * @param trackSimple Simple Track Object
     * @param played_at Played At Timestamp
     * @param context Context
     */
    public PlayHistory(TrackSimple trackSimple, Timestamp played_at, Context context) {
        this.trackSimple = trackSimple;
        this.played_at = played_at;
        this.context = context;
    }

    /**
     * @return Simple Track
     */
    public TrackSimple getTrackSimple() {
        return trackSimple;
    }

    /**
     * @return Played At
     */
    public Timestamp getPlayed_at() {
        return played_at;
    }

    /**
     * @return Context
     */
    public Context getContext() {
        return context;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

import java.security.Timestamp;

public class PlayHistory {
    private TrackSimple trackSimple;
    private Timestamp   played_at;
    private Context     context;

    public PlayHistory(TrackSimple trackSimple, Timestamp played_at, Context context) {
        this.trackSimple = trackSimple;
        this.played_at = played_at;
        this.context = context;
    }

    public TrackSimple getTrackSimple() {
        return trackSimple;
    }

    public Timestamp getPlayed_at() {
        return played_at;
    }

    public Context getContext() {
        return context;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class Recommendations {
    private RecommendationsSeed[] seeds;
    private TrackSimple[]         tracks;

    public Recommendations(RecommendationsSeed[] seeds, TrackSimple[] tracks) {
        this.seeds = seeds;
        this.tracks = tracks;
    }

    public RecommendationsSeed[] getSeeds() {
        return seeds;
    }

    public TrackSimple[] getTracks() {
        return tracks;
    }
}

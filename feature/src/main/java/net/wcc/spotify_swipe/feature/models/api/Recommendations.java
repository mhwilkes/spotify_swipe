package net.wcc.spotify_swipe.feature.models.api;

public class Recommendations {
    private RecommendationsSeed[] seeds;
    private TrackSimple[]         tracks;
    private String                endpoint = "https://api.spotify.com/v1/recommendations";

    /**
     * @param seeds
     * @param tracks
     */
    public Recommendations(RecommendationsSeed[] seeds, TrackSimple[] tracks) {
        this.seeds = seeds;
        this.tracks = tracks;
    }
    /**
     * @return
     */
    public RecommendationsSeed[] getSeeds() {
        return seeds;
    }
    /**
     * @return
     */
    public String getEndpoint() {
        return endpoint;
    }
    /**
     * @return
     */
    public TrackSimple[] getTracks() {
        return tracks;
    }

    //TODO get Recommendations

    public Recommendations requestRecommendations(Object... params) {

        return null;
    }
}

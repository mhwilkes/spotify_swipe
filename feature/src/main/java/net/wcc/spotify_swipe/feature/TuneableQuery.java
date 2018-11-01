package net.wcc.spotify_swipe.feature;

public class TuneableQuery {

    /**
     * Optional.
     * The target size of the list of recommended tracks. For seeds with unusually small pools or when
     * highly restrictive filtering is applied, it may be impossible to generate the requested number of recommended tracks.
     * Debugging information for such cases is available in the response. Default: 20. Minimum: 1. Maximum: 100.
     */
    private String limit;

    /**
     * Optional.
     * An <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a> or the string from_token.
     * Provide this parameter if you want to apply <a href="https://developer.spotify.com/documentation/general/guides/track-relinking-guide">Track Relinking</a>.
     * Because min_*, max_* and target_* are applied to pools before relinking, the generated results may not precisely match the filters applied. Original, non-relinked tracks
     * are available via the linked_from attribute of the <a href="https://developer.spotify.com/documentation/general/guides/track-relinking-guide">relinked track response</a>.
     */
    private String market;

    /**
     * Optional. Multiple values. For each tunable track attribute, a hard ceiling on the selected track attribute’s value can be provided. See tunable track attributes below
     * for the list of available options. For example, max_instrumentalness=0.35 would filter out most tracks that are likely to be instrumental.
     */
    private String max_;

    /**
     * Optional. Multiple values. For each tunable track attribute, a hard floor on the selected track attribute’s value can be provided. See tunable track attributes
     * below for the list of available options. For example, min_tempo=140 would restrict results to only those tracks with a tempo of greater than 140 beats per minute.
     */
    private String min_;

    /**
     * A comma separated list of <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID's</a> for seed artists.
     * Up to 5 seed values may be provided in any combination of seed_artists, seed_tracks and seed_genres.
     */
    private String seed_artists;

    /**
     * A comma separated list of any genres in the set of <a href="https://developer.spotify.com/documentation/web-api/reference/browse/get-recommendations/#available-genre-seeds">available genre seeds</a>.
     * Up to 5 seed values may be provided in any combination of seed_artists, seed_tracks and seed_genres.
     */
    private String seed_genres;

    /**
     * A comma separated list of <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID's</a> for a seed track. Up to 5 seed values may be provided in any combination of seed_artists, seed_tracks and seed_genres.
     */
    private String seed_tracks;

    /**
     * Optional.
     * Multiple values. For each of the tunable track attributes (below) a target value may be provided.
     * Tracks with the attribute values nearest to the target values will be preferred. For example, you might request target_energy=0.6 and target_danceability=0.8.
     * All target values will be weighed equally in ranking results.
     */
    private String target_;


    //TODO Will need multiple constructors for each request type

    /**
     * @param limit        Size of recommended list
     * @param market       Track Relinking country code
     * @param max_         Hard Ceiling on track attributes, Comma Separated
     * @param min_         Hard Floor on track attributes, Comma Separated
     * @param seed_artists Comma separated list of Spotify IDS for seed artists
     * @param seed_genres  Comma separated list of genres for genre seed
     * @param seed_tracks  Comma separated list of Spotify IDS for tracks
     * @param target_      Preferred attribute values, Will chose target values near this value
     */
    public TuneableQuery(String limit, String market, String max_, String min_, String seed_artists,
                         String seed_genres, String seed_tracks, String target_) {

        this.limit = limit;
        this.market = market;
        this.max_ = max_;
        this.min_ = min_;
        this.seed_artists = seed_artists;
        this.seed_genres = seed_genres;
        this.seed_tracks = seed_tracks;
        this.target_ = target_;

    }

}

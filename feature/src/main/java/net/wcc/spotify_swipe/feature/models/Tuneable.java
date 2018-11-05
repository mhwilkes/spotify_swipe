package net.wcc.spotify_swipe.feature.models;

class Tuneable {
    /**
     * A confidence measure from 0.0 to 1.0 of whether the track is acoustic. 1.0 represents high confidence the track is acoustic.
     */
    private float acousticness;

    /**
     * Danceability describes how suitable a track is for dancing based on a combination of musical elements including tempo,
     * rhythm stability, beat strength, and overall regularity. A value of 0.0 is least danceable and 1.0 is most danceable.
     */
    private float danceability;

    /**
     * The duration of the track in milliseconds.
     */
    private int duration_ms;

    /**
     * Energy is a measure from 0.0 to 1.0 and represents a perceptual measure of intensity and activity.
     * Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy,
     * while a Bach prelude scores low on the scale. Perceptual features contributing to this attribute
     * include dynamic range, perceived loudness, timbre, onset rate, and general entropy.
     */
    private float energy;

    /**
     * Predicts whether a track contains no vocals. “Ooh” and “aah” sounds are treated as instrumental
     * in this context. Rap or spoken word tracks are clearly “vocal”. The closer the instrumentalness
     * value is to 1.0, the greater likelihood the track contains no vocal content.
     * Values above 0.5 are intended to represent instrumental tracks, but confidence is higher as the value approaches 1.0.
     */
    private float instrumentalness;

    /**
     * The key the track is in. Integers map to pitches using standard Pitch Class notation.
     * <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class</a>
     * E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on.
     */
    private int key;

    /**
     * Detects the presence of an audience in the recording. Higher liveness values represent an increased
     * probability that the track was performed live. A value above 0.8 provides strong likelihood that the track is live.
     */
    private float liveness;

    /**
     * The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track
     * and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the
     * primary psychological correlate of physical strength (amplitude). Values typical range between -60 and 0 db.
     */
    private float loudness;

    /**
     * Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic
     * content is derived. Major is represented by 1 and minor is 0.
     */
    private int mode;

    /**
     * The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.
     * The popularity is calculated by algorithm and is based, in the most part, on the total number of plays
     * the track has had and how recent those plays are. Note: When applying track relinking via the market parameter,
     * it is expected to find relinked tracks with popularities that do not match min_*, max_*and target_* popularities.
     * These relinked tracks are accurate replacements for unplayable tracks with the expected popularity scores.
     * Original, non-relinked tracks are available via the linked_from attribute of the <a href="https://developer.spotify.com/documentation/general/guides/track-relinking-guide">relinked track response.</a>
     */
    private int popularity;

    /**
     * Speechiness detects the presence of spoken words in a track. The more exclusively speech-like
     * the recording (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value.
     * Values above 0.66 describe tracks that are probably made entirely of spoken words. Values between
     * 0.33 and 0.66 describe tracks that may contain both music and speech, either in sections or layered,
     * including such cases as rap music. Values below 0.33 most likely represent music and other non-speech-like tracks.
     */
    private float speechiness;

    /**
     * The overall estimated tempo of a track in beats per minute (BPM). In musical terminology,
     * tempo is the speed or pace of a given piece and derives directly from the average beat duration.
     */
    private float tempo;

    /**
     * An estimated overall time signature of a track. The time signature (meter) is a notational
     * convention to specify how many beats are in each bar (or measure).
     */
    private int time_signature;

    /**
     * A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track.
     * Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric),
     * while tracks with low valence sound more negative (e.g. sad, depressed, angry).
     */
    private float valence;

    //TODO will need multiple constructors for each request type

    /**
     * @param acousticness     Level of acoustic content
     * @param danceability     Level of danceability
     * @param duration_ms      Duration in MS
     * @param energy           Level of Energy
     * @param instrumentalness Level of Instrumental content
     * @param key              Type of key performed in
     * @param liveness         Level of certainty of live performance
     * @param loudness         Level of loudness
     * @param mode             Level of modality for scale used
     * @param popularity       Level of popularity
     * @param speechiness      Level of spoken words
     * @param tempo            Level of estimated BPM
     * @param time_signature   Estimated meter or measure of song
     * @param valence          Level of positivity
     */
    public Tuneable(float acousticness, float danceability, int duration_ms, float energy,
                    float instrumentalness, int key, float liveness, float loudness, int mode,
                    int popularity, float speechiness, float tempo, int time_signature, float valence) {

        this.acousticness = acousticness;
        this.danceability = danceability;
        this.duration_ms = duration_ms;
        this.energy = energy;
        this.instrumentalness = instrumentalness;
        this.key = key;
        this.liveness = liveness;
        this.loudness = loudness;
        this.mode = mode;
        this.popularity = popularity;
        this.speechiness = speechiness;
        this.tempo = tempo;
        this.time_signature = time_signature;
        this.valence = valence;

    }

    public float getAcousticness() {
        return acousticness;
    }

    public float getDanceability() {
        return danceability;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public float getEnergy() {
        return energy;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public int getKey() {
        return key;
    }

    public float getLiveness() {
        return liveness;
    }

    public float getLoudness() {
        return loudness;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public float getTempo() {
        return tempo;
    }

    public float getValence() {
        return valence;
    }

    public int getMode() {
        return mode;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getTime_signature() {
        return time_signature;
    }


}

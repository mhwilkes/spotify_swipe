package net.wcc.spotify_swipe.feature.models.api;

public class TuneableTrack {
    private float acousticness;
    private float danceability;
    private int   duration_ms;
    private float energy;
    private float instrumentalness;
    private int   key;
    private float liveness;
    private float loudness;
    private int   mode;
    private int   popularity;
    private float speechiness;
    private float tempo;
    private int   time_signature;
    private float valence;

    /**
     * @param acousticness
     *         A confidence measure from 0.0 to 1.0 of whether the track is acoustic. 1.0 represents high confidence the
     *         track is acoustic.
     * @param danceability
     *         Danceability describes how suitable a track is for dancing based on a combination of musical elements
     *         including tempo, rhythm stability, beat strength, and overall regularity. A value of 0.0 is least
     *         danceable and 1.0 is most danceable.
     * @param duration_ms
     *         The duration of the track in milliseconds.
     * @param energy
     *         Energy is a measure from 0.0 to 1.0 and represents a perceptual measure of intensity and activity.
     *         Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy, while a
     *         Bach prelude  scores low on the scale. Perceptual features contributing to this attribute include dynamic
     *         range, perceived  loudness, timbre, onset rate, and general entropy.
     * @param instrumentalness
     *         Predicts whether a track contains no vocals. “Ooh” and “aah” sounds are treated as instrumental in this
     *         context. Rap or spoken word tracks are clearly “vocal”. The closer the instrumentalness value is to 1.0,
     *         the greater likelihood the track contains no vocal content. Values above 0.5 are intended to represent
     *         instrumental tracks, * but confidence is higher as the value approaches 1.0.
     * @param key
     *         The key the track is in. Integers map to pitches using standard Pitch Class notation.
     *         <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class</a>
     *         E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on.
     * @param liveness
     *         Detects the presence of an audience in the recording. Higher liveness values represent an increased
     *         probability that the track was performed live. A value above 0.8 provides strong likelihood that the
     *         track is live.
     * @param loudness
     *         The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track
     *         and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the
     *         primary psychological correlate of physical strength (amplitude). Values typical range between -60 and 0
     *         db.
     * @param mode
     *         Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content
     *         is derived. Major is represented by 1 and minor is 0.
     * @param popularity
     *         The popularity of the track. The value will be between 0 and 100, with 100 being the most popular. The
     *         popularity is calculated by algorithm and is based, in the most part, on the total number of plays the
     *         track has had and how recent those plays are. Note: When applying track relinking via the market
     *         parameter, it is expected to find relinked tracks with popularities that do not match min_*, max_*and
     *         target_* popularities. These relinked tracks are accurate replacements for unplayable tracks with the
     *         expected popularity scores. Original, non-relinked tracks are available via the linked_from attribute of
     *         the
     *         <a href="https://developer.spotify.com/documentation/general/guides/track-relinking-guide">relinked
     *         track response.</a>
     * @param speechiness
     *         Speechiness detects the presence of spoken words in a track. The more exclusively speech-like the
     *         recording (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value. Values above 0.66
     *         describe tracks that are probably made entirely of spoken words. Values between 0.33 and 0.66 describe
     *         tracks that may contain both music and speech, either in sections or layered, including such cases as rap
     *         music. Values below 0.33 most likely represent music and other non-speech-like tracks.
     * @param tempo
     *         The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the
     *         speed or pace of a given piece and derives directly from the average beat duration.
     * @param time_signature
     *         An estimated overall time signature of a track. The time signature (meter) is a notational convention to
     *         specify how many beats are in each bar (or measure).
     * @param valence
     *         A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track. Tracks with high
     *         valence sound more positive (e.g. happy, cheerful, euphoric), while tracks with low valence sound more
     *         negative (e.g. sad, depressed, angry).
     */
    public TuneableTrack(float acousticness, float danceability, int duration_ms, float energy, float
            instrumentalness, int key, float liveness, float loudness, int mode, int popularity, float speechiness,
                         float tempo, int time_signature, float valence) {
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

    /**
     * @return
     */
    public float getAcousticness() {
        return acousticness;
    }

    /**
     * @return
     */
    public float getDanceability() {
        return danceability;
    }

    /**
     * @return
     */
    public int getDuration_ms() {
        return duration_ms;
    }

    /**
     * @return
     */
    public float getEnergy() {
        return energy;
    }

    /**
     * @return
     */
    public float getInstrumentalness() {
        return instrumentalness;
    }

    /**
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * @return
     */
    public float getLiveness() {
        return liveness;
    }

    /**
     * @return
     */
    public float getLoudness() {
        return loudness;
    }

    /**
     * @return
     */
    public float getSpeechiness() {
        return speechiness;
    }

    /**
     * @return
     */
    public float getTempo() {
        return tempo;
    }

    /**
     * @return
     */
    public float getValence() {
        return valence;
    }

    /**
     * @return
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * @return
     */
    public int getTime_signature() {
        return time_signature;
    }

}

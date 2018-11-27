package net.wcc.spotify_swipe.feature.models.audio_analysis;

public class Section {
    private float start;
    private float duration;
    private float confidence;
    private float loudness;
    private float tempo_confidence;
    private int   key;
    private float key_confidence;
    private int   mode;
    private float mode_confidence;
    private int   time_signature;
    private float time_signature_confidence;

    /**
     * @param start
     * @param duration
     * @param confidence
     * @param loudness
     * @param tempo_confidence
     * @param key
     * @param key_confidence
     * @param mode
     * @param mode_confidence
     * @param time_signature
     * @param time_signature_confidence
     */
    public Section(float start, float duration, float confidence, float loudness, float tempo_confidence, int key,
                   float key_confidence, int mode, float mode_confidence, int time_signature, float
                           time_signature_confidence) {
        this.start = start;
        this.duration = duration;
        this.confidence = confidence;
        this.loudness = loudness;
        this.tempo_confidence = tempo_confidence;
        this.key = key;
        this.key_confidence = key_confidence;
        this.mode = mode;
        this.mode_confidence = mode_confidence;
        this.time_signature = time_signature;
        this.time_signature_confidence = time_signature_confidence;
    }

    /**
     * @return
     */
    public float getStart() {
        return start;
    }

    /**
     * @return
     */
    public float getDuration() {
        return duration;
    }

    /**
     * @return
     */
    public float getConfidence() {
        return confidence;
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
    public float getTempo_confidence() {
        return tempo_confidence;
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
    public float getKey_confidence() {
        return key_confidence;
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
    public float getMode_confidence() {
        return mode_confidence;
    }

    /**
     * @return
     */
    public int getTime_signature() {
        return time_signature;
    }

    /**
     * @return
     */
    public float getTime_signature_confidence() {
        return time_signature_confidence;
    }
}

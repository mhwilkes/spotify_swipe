package net.wcc.spotify_swipe.feature.models.audio_analysis;

public class Segment {
    private float   start;
    private float   duration;
    private float   confidence;
    private float   loudness_start;
    private float   loudness_max;
    private float   loudness_max_time;
    private float   loudness_end;
    private float[] pitches;
    private float[] timbre;

    /**
     * @param start
     * @param duration
     * @param confidence
     * @param loudness_start
     * @param loudness_max
     * @param loudness_max_time
     * @param loudness_end
     * @param pitches
     * @param timbre
     */
    public Segment(float start, float duration, float confidence, float loudness_start, float loudness_max, float
            loudness_max_time, float loudness_end, float[] pitches, float[] timbre) {

        this.start = start;
        this.duration = duration;
        this.confidence = confidence;
        this.loudness_start = loudness_start;
        this.loudness_max = loudness_max;
        this.loudness_max_time = loudness_max_time;
        this.loudness_end = loudness_end;
        this.pitches = pitches;
        this.timbre = timbre;
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
    public float getLoudness_start() {
        return loudness_start;
    }

    /**
     * @return
     */
    public float getLoudness_max() {
        return loudness_max;
    }

    /**
     * @return
     */
    public float getLoudness_max_time() {
        return loudness_max_time;
    }

    /**
     * @return
     */
    public float getLoudness_end() {
        return loudness_end;
    }

    /**
     * @return
     */
    public float[] getPitches() {
        return pitches;
    }

    /**
     * @return
     */
    public float[] getTimbre() {
        return timbre;
    }
}

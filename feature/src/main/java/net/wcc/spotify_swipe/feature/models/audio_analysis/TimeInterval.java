package net.wcc.spotify_swipe.feature.models.audio_analysis;

public class TimeInterval {
    private float start, duration, confidence;

    /**
     * @param start
     * @param duration
     * @param confidence
     */
    public TimeInterval(float start, float duration, float confidence) {

        this.start = start;
        this.duration = duration;
        this.confidence = confidence;
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

    public float getConfidence() {
        return confidence;
    }
}

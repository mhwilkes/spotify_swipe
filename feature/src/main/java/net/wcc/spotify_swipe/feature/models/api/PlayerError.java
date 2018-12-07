package net.wcc.spotify_swipe.feature.models.api;

import java.util.HashMap;

public class PlayerError {

    //TODO recheck interpretation of this object, make sure the correct flow is happening
    private final HashMap<String, String> errors = new HashMap<String, String>() {{
        put("NO_PREV_TRACK", "403 FORBIDDEN");
        put("NO_NEXT_TRACK", "403 FORBIDDEN");
        put("NO_SPECIFIC_TRACK", "403 FORBIDDEN");
        put("ALREADY_PAUSED", "403 FORBIDDEN");
        put("NOT_PAUSED", "403 FORBIDDEN");
        put("NOT_PLAYING_LOCALLY", "403 FORBIDDEN");
        put("NOT_PLAYING_TRACK", "403 FORBIDDEN");
        put("NOT_PLAYING_CONTEXT", "403 FORBIDDEN");
        put("ENDLESS_CONTEXT", "403 FORBIDDEN");
        put("CONTEXT_DISALLOW", "403 FORBIDDEN");
        put("ALREADY_PLAYING", "403 FORBIDDEN");
        put("RATE_LIMITED", "403 FORBIDDEN");
        put("REMOTE_CONTROL_DISALLOW", "403 FORBIDDEN");
        put("DEVICE_NOT_CONTROLLABLE", "403 FORBIDDEN");
        put("VOLUME_CONTROL_DISALLOW", "403 FORBIDDEN");
        put("NO_ACTIVE_DEVICE", "404 FORBIDDEN");
        put("PREMIUM_REQUIRED", "403 FORBIDDEN");
        put("UNKNOWN", "403 FORBIDDEN");

    }};
    private       int                     status;
    private       String                  message, reason;

    /**
     * @param status
     * @param message
     * @param reason
     */
    public PlayerError(int status, String message, String reason) {
        this.status = status;
        this.message = message;
        this.reason = reason;
    }

    /**
     * @return
     */
    public HashMap<String, String> getErrors() {
        return errors;
    }

    /**
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return
     */
    public String getReason() {
        return reason;
    }
}

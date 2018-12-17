package net.wcc.spotify_swipe.feature.models.api;

import java.util.HashMap;

public class PlayerError {

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
     * @param status  Status Code
     * @param message Status Message
     * @param reason  Reason Message
     */
    public PlayerError(int status, String message, String reason) {
        this.status = status;
        this.message = message;
        this.reason = reason;
    }

    /**
     * @return HashMap of Possible Errors
     */
    public HashMap<String, String> getErrors() {
        return errors;
    }

    /**
     * @return Status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return Message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Reason
     */
    public String getReason() {
        return reason;
    }
}

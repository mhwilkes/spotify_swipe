package net.wcc.spotify_swipe.feature.models.api;

public class Error {
    private int    status;
    private String message;

    /**
     * @param status
     * @param message
     */
    public Error(int status, String message) {
        this.status = status;
        this.message = message;
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
}

package net.wcc.spotify_swipe.feature.models.api;

public class Error {

    private int    status;
    private String message;

    /**
     * @param status Error #
     * @param message Error Message
     */
    public Error(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * @return Error #
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return Message of Error
     */
    public String getMessage() {
        return message;
    }
}

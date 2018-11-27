package net.wcc.spotify_swipe.feature.models.api;

public class RecommendationsSeed {
    private int    afterFilteringSize;
    private int    afterRelinkingSize;
    private String href;
    private String id;
    private int    initialPoolSize;
    private String type;

    /**
     * @param afterFilteringSize
     * @param afterRelinkingSize
     * @param href
     * @param id
     * @param initialPoolSize
     * @param type
     */
    public RecommendationsSeed(int afterFilteringSize, int afterRelinkingSize, String href, String id, int
            initialPoolSize, String type) {
        this.afterFilteringSize = afterFilteringSize;
        this.afterRelinkingSize = afterRelinkingSize;
        this.href = href;
        this.id = id;
        this.initialPoolSize = initialPoolSize;
        this.type = type;
    }

    /**
     * @return
     */
    public int getAfterFilteringSize() {
        return afterFilteringSize;
    }

    /**
     * @return
     */
    public int getAfterRelinkingSize() {
        return afterRelinkingSize;
    }

    /**
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @return
     */
    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }
}

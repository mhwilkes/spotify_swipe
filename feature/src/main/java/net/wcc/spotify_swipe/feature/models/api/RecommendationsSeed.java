package net.wcc.spotify_swipe.feature.models.api;

public class RecommendationsSeed {

    private int    afterFilteringSize;
    private int    afterRelinkingSize;
    private String href;
    private String id;
    private int    initialPoolSize;
    private String type;

    /**
     * @param afterFilteringSize Filter Size
     * @param afterRelinkingSize Relinking Size
     * @param href               URL of Recommendations
     * @param id                 ID of Object
     * @param initialPoolSize    Initial Size
     * @param type               Type
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
     * @return Filtered Size
     */
    public int getAfterFilteringSize() {
        return afterFilteringSize;
    }

    /**
     * @return Relinked Size
     */
    public int getAfterRelinkingSize() {
        return afterRelinkingSize;
    }

    /**
     * @return URL of Recommendation
     */
    public String getHref() {
        return href;
    }

    /**
     * @return ID of Object
     */
    public String getId() {
        return id;
    }

    /**
     * @return Initial Size
     */
    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    /**
     * @return Type
     */
    public String getType() {
        return type;
    }
}

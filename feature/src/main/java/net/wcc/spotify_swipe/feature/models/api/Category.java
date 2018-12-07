package net.wcc.spotify_swipe.feature.models.api;

public class Category {

    private String href, id, name;
    private CoverImage[] icons;

    /**
     * @param href
     * @param icons
     * @param id
     * @param name
     */
    public Category(String href, CoverImage[] icons, String id, String name) {
        this.href = href;
        this.icons = icons;
        this.id = id;
        this.name = name;
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
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public CoverImage[] getIcons() {
        return icons;
    }
}

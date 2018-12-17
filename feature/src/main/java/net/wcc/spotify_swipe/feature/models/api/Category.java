package net.wcc.spotify_swipe.feature.models.api;

public class Category {

    private String href, id, name;
    private CoverImage[] icons;

    /**
     * @param href URL for Category
     * @param icons Icon For Category
     * @param id Category ID
     * @param name Category Name
     */
    public Category(String href, CoverImage[] icons, String id, String name) {
        this.href = href;
        this.icons = icons;
        this.id = id;
        this.name = name;
    }

    /**
     * @return URL to access Category from API
     */
    public String getHref() {
        return href;
    }

    /**
     * @return ID of Category
     */
    public String getId() {
        return id;
    }

    /**
     * @return Name of Category
     */
    public String getName() {
        return name;
    }

    /**
     * @return Icons for Category
     */
    public CoverImage[] getIcons() {
        return icons;
    }
}

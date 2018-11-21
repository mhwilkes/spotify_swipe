package net.wcc.spotify_swipe.feature.models.api;

public class Category {

    private String href, id, name;
    private Image[] icons;

    public Category(String href, Image[] icons, String id, String name) {
        this.href = href;
        this.icons = icons;
        this.id = id;
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image[] getIcons() {
        return icons;
    }
}

package net.wcc.spotify_swipe.feature.models.card;

public class FrontCard {

    public int    id;
    public String text;
    public String img_url;
    public String description;

    public FrontCard(String text, String description, String img_url) {
        this.id++;
        this.text = text;
        this.img_url = img_url;
        this.description = description;
    }

}

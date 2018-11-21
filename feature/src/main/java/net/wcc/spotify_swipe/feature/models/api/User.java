package net.wcc.spotify_swipe.feature.models.api;

import net.wcc.spotify_swipe.feature.models.api.ExternalURL;
import net.wcc.spotify_swipe.feature.models.api.Followers;
import net.wcc.spotify_swipe.feature.models.api.Image;

public class User {
    private String      birthdate;
    private String      country;
    private String      display_name;
    private String      email;
    private ExternalURL external_urls;
    private Followers   followers;
    private String      href;
    private String      id;
    private Image[]     images;
    private String      product;
    private String      type;
    private String      uri;

    private User(String birthdate, String country, String display_name, String email, ExternalURL external_urls,
            Followers followers, String href, String id, Image[] images, String product, String type, String uri) {
        this.birthdate = birthdate;
        this.country = country;
        this.display_name = display_name;
        this.email = email;
        this.external_urls = external_urls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.product = product;
        this.type = type;
        this.uri = uri;
    }

    public User(String display_name, ExternalURL external_urls, Followers followers, String href, String id, Image[]
            images, String type, String uri) {
        this.display_name = display_name;
        this.external_urls = external_urls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.type = type;
        this.uri = uri;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCountry() {
        return country;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getEmail() {
        return email;
    }

    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public Image[] getImages() {
        return images;
    }

    public String getProduct() {
        return product;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}

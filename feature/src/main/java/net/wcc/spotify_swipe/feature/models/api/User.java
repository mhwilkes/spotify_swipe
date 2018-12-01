package net.wcc.spotify_swipe.feature.models.api;

@SuppressWarnings("SpellCheckingInspection")
public class User {

    private String       birthdate;
    private String       country;
    private String       display_name;
    private String       email;
    private ExternalURL  external_urls;
    private Followers    followers;
    private String       href;
    private String       id;
    private CoverImage[] images;
    private String       product;
    private String       type;
    private String       uri;

    /**
     * @param birthdate
     * @param country
     * @param display_name
     * @param email
     * @param external_urls
     * @param followers
     * @param href
     * @param id
     * @param images
     * @param product
     * @param type
     * @param uri
     */
    private User(String birthdate, String country, String display_name, String email, ExternalURL external_urls,
                 Followers followers, String href, String id, CoverImage[] images, String product, String type,
                 String uri) {
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

    /**
     * @param display_name
     * @param external_urls
     * @param followers
     * @param href
     * @param id
     * @param images
     * @param type
     * @param uri
     */
    public User(String display_name, ExternalURL external_urls, Followers followers, String href, String id,
                CoverImage[] images, String type, String uri) {
        this.display_name = display_name;
        this.external_urls = external_urls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.type = type;
        this.uri = uri;
    }

    /**
     * @return
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return
     */
    public String getDisplay_name() {
        return display_name;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    /**
     * @return
     */
    public Followers getFollowers() {
        return followers;
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
    public CoverImage[] getImages() {
        return images;
    }

    /**
     * @return
     */
    public String getProduct() {
        return product;
    }

    /**
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * @return
     */
    public String getUri() {
        return uri;
    }
}

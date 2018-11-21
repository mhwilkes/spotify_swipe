package net.wcc.spotify_swipe.feature.models.api;

public class Playlist {
    private Boolean     collaborative;
    private String      description;
    private ExternalURL externalURL;
    private Followers   followers;
    private String      href;
    private String      id;
    private Image[]     images;
    private String      name;
    private User        owner;
    private Boolean     publicStatus;
    private String      snapshot_id;
    private Paging[]    tracks;
    private String      type;
    private String      uri;

    public Playlist(Boolean collaborative, String description, ExternalURL externalURL, Followers followers, String
            href, String id, Image[] images, String name, User owner, Boolean publicStatus, String snapshot_id,
            Paging[] tracks, String type, String uri) {
        this.collaborative = collaborative;
        this.description = description;
        this.externalURL = externalURL;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.owner = owner;
        this.publicStatus = publicStatus;
        this.snapshot_id = snapshot_id;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    public Boolean getCollaborative() {
        return collaborative;
    }

    public String getDescription() {
        return description;
    }

    public ExternalURL getExternalURL() {
        return externalURL;
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

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public Boolean getPublicStatus() {
        return publicStatus;
    }

    public String getSnapshot_id() {
        return snapshot_id;
    }

    public Paging[] getTracks() {
        return tracks;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}

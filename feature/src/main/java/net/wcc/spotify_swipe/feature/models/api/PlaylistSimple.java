package net.wcc.spotify_swipe.feature.models.api;

public class PlaylistSimple {
    private Boolean     collaborative;
    private ExternalURL externalURL;
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

    public PlaylistSimple(Boolean collaborative, ExternalURL externalURL, String href, String id, Image[] images,
            String name, User owner, Boolean publicStatus, String snapshot_id, Paging[] tracks, String type, String
            uri) {
        this.collaborative = collaborative;
        this.externalURL = externalURL;
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

    public ExternalURL getExternalURL() {
        return externalURL;
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

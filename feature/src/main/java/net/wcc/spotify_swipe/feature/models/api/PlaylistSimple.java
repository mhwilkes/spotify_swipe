package net.wcc.spotify_swipe.feature.models.api;

public class PlaylistSimple {
    private Boolean      collaborative;
    private ExternalURL  externalURL;
    private String       href;
    private String       id;
    private CoverImage[] images;
    private String       name;
    private User         owner;
    private Boolean      publicStatus;
    private String       snapshot_id;
    private Paging[]     tracks;
    private String       type;
    private String       uri;

    /**
     * @param collaborative
     * @param externalURL
     * @param href
     * @param id
     * @param images
     * @param name
     * @param owner
     * @param publicStatus
     * @param snapshot_id
     * @param tracks
     * @param type
     * @param uri
     */
    public PlaylistSimple(Boolean collaborative, ExternalURL externalURL, String href, String id, CoverImage[]
            images, String name, User owner, Boolean publicStatus, String snapshot_id, Paging[] tracks, String type,
                          String uri) {
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

    /**
     * @return
     */
    public Boolean getCollaborative() {
        return collaborative;
    }

    /**
     * @return
     */
    public ExternalURL getExternalURL() {
        return externalURL;
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
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @return
     */
    public Boolean getPublicStatus() {
        return publicStatus;
    }

    /**
     * @return
     */
    public String getSnapshot_id() {
        return snapshot_id;
    }

    /**
     * @return
     */
    public Paging[] getTracks() {
        return tracks;
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

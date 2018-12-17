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
     * @param collaborative Is Collaborative
     * @param externalURL   External URL
     * @param href          URL to Playlist
     * @param id            Playlist ID
     * @param images        Images of Covers
     * @param name          Playlist Name
     * @param owner         User who owns
     * @param publicStatus  Is Public
     * @param snapshot_id   Snapshot ID
     * @param tracks        Tracks in playlist in Paging object
     * @param type          Type
     * @param uri           URI
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
     * @return If it is Collaborative
     */
    public Boolean getCollaborative() {
        return collaborative;
    }

    /**
     * @return External URLs
     */
    public ExternalURL getExternalURL() {
        return externalURL;
    }

    /**
     * @return URL to Playlist
     */
    public String getHref() {
        return href;
    }

    /**
     * @return ID of Playlist
     */
    public String getId() {
        return id;
    }

    /**
     * @return Images
     */
    public CoverImage[] getImages() {
        return images;
    }

    /**
     * @return Name of Playlist
     */
    public String getName() {
        return name;
    }

    /**
     * @return Owner of Playlist
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @return Publication Status
     */
    public Boolean getPublicStatus() {
        return publicStatus;
    }

    /**
     * @return Snapshot ID
     */
    public String getSnapshot_id() {
        return snapshot_id;
    }

    /**
     * @return array of Tracks in Paging Object
     */
    public Paging[] getTracks() {
        return tracks;
    }

    /**
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @return URI
     */
    public String getUri() {
        return uri;
    }
}

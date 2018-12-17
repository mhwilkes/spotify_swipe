package net.wcc.spotify_swipe.feature.models.api;

public class Playlist {

    private Boolean      collaborative;
    private String       description;
    private ExternalURL  externalURL;
    private Followers    followers;
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
     * @param description Playlist Description
     * @param externalURL External URL
     * @param followers Who Follows
     * @param href URL to Playlist
     * @param id Playlist ID
     * @param images Images of Covers
     * @param name Playlist Name
     * @param owner User who owns
     * @param publicStatus Is Public
     * @param snapshot_id Snapshot ID
     * @param tracks Tracks in playlist in Paging object
     * @param type Type
     * @param uri URI
     */
    public Playlist(Boolean collaborative, String description, ExternalURL externalURL, Followers followers, String
            href, String id, CoverImage[] images, String name, User owner, Boolean publicStatus, String snapshot_id,
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

    /**
     * @return If it is Collaborative
     */
    public Boolean getCollaborative() {
        return collaborative;
    }

    /**
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return External URLs
     */
    public ExternalURL getExternalURL() {
        return externalURL;
    }

    /**
     * @return Followers
     */
    public Followers getFollowers() {
        return followers;
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
     * @return array of Tracks
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

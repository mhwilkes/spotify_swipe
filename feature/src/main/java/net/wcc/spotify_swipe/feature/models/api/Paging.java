package net.wcc.spotify_swipe.feature.models.api;

public class Paging {

    private String   href;
    private Object[] items;
    private int      limit;
    private String   next;
    private int      offset;
    private String   previous;
    private int      total;

    /**
     * @param href URL to Item
     * @param items Array of Items being paged
     * @param limit Limit of Items
     * @param next Next Item
     * @param offset Offset used for Paging
     * @param previous Last Item
     * @param total Total # of Items
     */
    public Paging(String href, Object[] items, int limit, String next, int offset, String previous, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
    }

    /**
     * @return URL of Item
     */
    public String getHref() {
        return href;
    }

    /**
     * @return array of Items
     */
    public Object[] getItems() {
        return items;
    }

    /**
     * @return # of items for Limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return Next Item
     */
    public String getNext() {
        return next;
    }

    /**
     * @return Offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return Previous Item
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * @return Total # of Items
     */
    public int getTotal() {
        return total;
    }
}

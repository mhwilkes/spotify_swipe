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
     * @param href
     * @param items
     * @param limit
     * @param next
     * @param offset
     * @param previous
     * @param total
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
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * @return
     */
    public Object[] getItems() {
        return items;
    }

    /**
     * @return
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return
     */
    public String getNext() {
        return next;
    }

    /**
     * @return
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * @return
     */
    public int getTotal() {
        return total;
    }
}

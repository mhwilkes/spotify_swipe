package net.wcc.spotify_swipe.feature.models.api;

public class CursorPaging {

    private String   next;
    private String   href;
    private Object[] items;
    private int      limit, total;
    private Cursor cursors;

    /**
     * @param href
     * @param items
     * @param limit
     * @param next
     * @param cursors
     * @param total
     */
    public CursorPaging(String href, Object[] items, int limit, String next, Cursor cursors, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.cursors = cursors;
        this.total = total;
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
    public int getTotal() {
        return total;
    }

    /**
     * @return
     */
    public Cursor getCursors() {
        return cursors;
    }
}

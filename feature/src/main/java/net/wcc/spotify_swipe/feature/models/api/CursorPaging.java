package net.wcc.spotify_swipe.feature.models.api;

public class CursorPaging {

    private String   next;
    private String   href;
    private Object[] items;
    private int      limit, total;
    private Cursor cursors;

    /**
     * @param href URL of Item
     * @param items List of Items
     * @param limit Limit of Items
     * @param next Next Item
     * @param cursors Cursor
     * @param total Total Items
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
     * @return Next Item
     */
    public String getNext() {
        return next;
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
     * @return Limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return Total # of Songs
     */
    public int getTotal() {
        return total;
    }

    /**
     * @return Cursor
     */
    public Cursor getCursors() {
        return cursors;
    }
}

package net.wcc.spotify_swipe.feature.models.api;

public class CursorPaging {
    private String   next;
    private String   href;
    private Object[] items;
    private int      limit, total;
    private Cursor cursors;

    public CursorPaging(String href, Object[] items, int limit, String next, Cursor cursors, int total) {
        this.href = href;
        this.items = items;
        this.limit = limit;
        this.next = next;
        this.cursors = cursors;
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public String getHref() {
        return href;
    }

    public Object[] getItems() {
        return items;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public Cursor getCursors() {
        return cursors;
    }
}

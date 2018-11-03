package net.wcc.spotify_swipe.feature.handlers;

import java.util.Arrays;
import java.util.List;

class SwipeHandler {

    public enum SwipeDirection {
        LEFT, RIGHT, TOP, BOTTOM;

        public static final List<SwipeDirection> FREEDOM = Arrays
                .asList(SwipeDirection.values());
        public static final List<SwipeDirection> FREEDOM_NO_BOTTOM = Arrays
                .asList(SwipeDirection.TOP,SwipeDirection.LEFT, SwipeDirection.RIGHT);
        public static final List<SwipeDirection> HORIZONTAL = Arrays
                .asList(SwipeDirection.LEFT, SwipeDirection.RIGHT);
        public static final List<SwipeDirection> VERTICAL = Arrays
                .asList(SwipeDirection.TOP, SwipeDirection.BOTTOM);

        public static List<SwipeDirection> from(int value) {
            switch (value) {
                case 0:
                    return FREEDOM;
                case 1:
                    return FREEDOM_NO_BOTTOM;
                case 2:
                    return HORIZONTAL;
                case 3:
                    return VERTICAL;
                default:
                    return FREEDOM;
            }
        }
    }

}

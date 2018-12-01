package net.wcc.spotify_swipe.feature.models.card;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class CardDiffCalback extends DiffUtil.Callback {

    private final List<Card> oldList;
    private final List<Card> newList;

    public CardDiffCalback(List<Card> oldList, List<Card> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition) {
        return oldList.get(oldPosition).id == newList.get(newPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
        Card oldSpot = oldList.get(oldPosition);
        Card newSpot = newList.get(newPosition);
        return oldSpot.name.equals(newSpot.name)
                && oldSpot.city.equals(newSpot.city)
                && oldSpot.url.equals(newSpot.url);
    }

}
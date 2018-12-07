package net.wcc.spotify_swipe.feature.models.card;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class FrontCardDiffCallback extends DiffUtil.Callback {

    private final List<FrontCard> oldList;
    private final List<FrontCard> newList;

    public FrontCardDiffCallback(List<FrontCard> oldList, List<FrontCard> newList) {
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
        FrontCard oldFrontCard = oldList.get(oldPosition);
        FrontCard newFrontCard = newList.get(newPosition);
        return oldFrontCard.text.equals(newFrontCard.text)
                && oldFrontCard.description.equals(newFrontCard.description)
                && oldFrontCard.img_url.equals(newFrontCard.img_url);
    }

}
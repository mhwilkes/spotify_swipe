package net.wcc.spotify_swipe.feature.models.card;

import android.support.v7.util.DiffUtil;
import java.util.List;

public class CardDiffCallback extends DiffUtil.Callback {

    private final List<Card> oldList;
    private final List<Card> newList;

    public CardDiffCallback(List<Card> oldList, List<Card> newList) {
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
        return oldList.get(oldPosition).getSong_ID() == newList.get(newPosition).getSong_ID();
    }

    //TODO add card stuff
    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
        Card oldCard = oldList.get(oldPosition);
        Card newCard = newList.get(newPosition);
        return oldCard.getSong_name().equals(newCard.getSong_name())
                && oldCard.getSong_artists().equals(newCard.getSong_artists())
                && oldCard.getSong_preview_url().equals(newCard.getSong_preview_url());
    }

}

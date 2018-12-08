package net.wcc.spotify_swipe.feature.models.card;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import net.wcc.spotify_swipe.feature.R;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Card>     cards;

    public CardStackAdapter(Context context, List<Card> cards) {
        this.inflater = LayoutInflater.from(context);
        this.cards = cards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_spot, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.text.setText(card.text);
        holder.description.setText(card.description);
        Glide.with(holder.image)
             .load(card.url)
             .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView  text;
        TextView  description;
        ImageView image;

        ViewHolder(View view) {
            super(view);
            this.text = view.findViewById(R.id.item_name);
            this.description = view.findViewById(R.id.item_city);
            this.image = view.findViewById(R.id.item_image);
        }
    }

}

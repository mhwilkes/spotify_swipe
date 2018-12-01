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

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Card> cards;

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
        Card spot = cards.get(position);
        holder.name.setText(cards.name);
        holder.city.setText(cards.city);
        Glide.with(holder.image)
                .load(cards.url)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> spots) {
        this.cards = cards;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView city;
        ImageView image;
        ViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.item_name);
            this.city = view.findViewById(R.id.item_city);
            this.image = view.findViewById(R.id.item_image);
        }
    }

}
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
import net.wcc.spotify_swipe.feature.R;

import java.util.List;

public class FrontCardStackAdapter extends RecyclerView.Adapter<FrontCardStackAdapter.ViewHolder> {

    private LayoutInflater  inflater;
    private List<FrontCard> mFrontCards;

    public FrontCardStackAdapter(Context context, List<FrontCard> frontCards) {
        this.inflater = LayoutInflater.from(context);
        this.mFrontCards = frontCards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FrontCard frontCard = mFrontCards.get(position);
        holder.text.setText(frontCard.text);
        holder.description.setText(frontCard.description);
        Glide.with(holder.image).load(frontCard.img_url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mFrontCards.size();
    }

    public List<FrontCard> getFrontCards() {
        return mFrontCards;
    }

    public void setFrontCards(List<FrontCard> frontCards) {
        this.mFrontCards = frontCards;
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
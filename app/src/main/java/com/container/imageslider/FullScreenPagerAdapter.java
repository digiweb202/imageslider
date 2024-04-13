package com.container.imageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FullScreenPagerAdapter extends RecyclerView.Adapter<FullScreenPagerAdapter.FullScreenPagerViewHolder> {

    private int[] images;

    public FullScreenPagerAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public FullScreenPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_full_screen_image, parent, false);
        return new FullScreenPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FullScreenPagerViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    static class FullScreenPagerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public FullScreenPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.touchImageView);
        }
    }
}

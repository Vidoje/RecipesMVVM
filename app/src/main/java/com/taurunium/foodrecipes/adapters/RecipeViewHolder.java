package com.taurunium.foodrecipes.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.taurunium.foodrecipes.R;

import org.jetbrains.annotations.NotNull;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

     TextView title, publisher, socialScore;
     AppCompatImageView image;
     OnRecipeListener onRecipeListener;

    public RecipeViewHolder(View itemView, OnRecipeListener onRecipeListener) {
        super(itemView);
        title = itemView.findViewById(R.id.recipe_title);
        publisher = itemView.findViewById(R.id.recipe_publisher);
        socialScore = itemView.findViewById(R.id.recipe_social_score);

        image = itemView.findViewById(R.id.recipe_image);

        this.onRecipeListener = onRecipeListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onRecipeListener.onRecipeClick(getAdapterPosition());
    }
}

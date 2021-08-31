package com.taurunium.foodrecipes.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.taurunium.foodrecipes.R;
import com.taurunium.foodrecipes.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int RECIPE_TYPE = 1;
    public static final int LOADING_TYPE = 2;

    private List<Recipe> mRecipes;
    private OnRecipeListener mOnRecipeListener;

    public RecipeRecyclerAdapter(OnRecipeListener mOnRecipeListener) {
        this.mOnRecipeListener = mOnRecipeListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType){
            case RECIPE_TYPE: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent, false);
                return new RecipeViewHolder(view, mOnRecipeListener);
            }
            case LOADING_TYPE: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_list_item, parent, false);
                return new LoadingViewHolder(view);
            }
            default:{
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent, false);
                return new RecipeViewHolder(view, mOnRecipeListener);
            }
        }



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType== RECIPE_TYPE) {
            ((RecipeViewHolder) holder).title.setText(mRecipes.get(position).getTitle());
            ((RecipeViewHolder) holder).publisher.setText(mRecipes.get(position).getPublisher());
            ((RecipeViewHolder) holder).socialScore.setText(String.valueOf(Math.round(mRecipes.get(position).getSocialUrl())));


            Log.d("TAG", "Sabaton: " + mRecipes.get(position).toString());
            Glide.with(holder.itemView.getContext())
                    .load(mRecipes.get(position).getImageUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(((RecipeViewHolder) holder).image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mRecipes.get(position).getTitle().equals("LOADING...")){
            return LOADING_TYPE;
        }else{
            return RECIPE_TYPE;
        }
    }

    public void displayLoading(){
        if(!isLoading()){
            Recipe recipe = new Recipe();
            recipe.setTitle("LOADING...");
            List<Recipe> loadingList = new ArrayList<>();
            loadingList.add(recipe);
            mRecipes = loadingList;
            notifyDataSetChanged();
        }
    }

    private boolean isLoading(){
        if(mRecipes!=null) {
            if (mRecipes.size() > 0) {
                if (mRecipes.get(mRecipes.size() - 1).getTitle().equals("LOADING"))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int getItemCount() {
        if(mRecipes!=null)
            return mRecipes.size();
        else
            return 0;
    }

    public void setRecipes(List<Recipe> recipes){
        this.mRecipes = recipes;
        notifyDataSetChanged();
    }
}

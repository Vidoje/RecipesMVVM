package com.taurunium.foodrecipes.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.taurunium.foodrecipes.models.Recipe;

public class RecipeResponse {
    @SerializedName("recipe")  //ovde govorim sta da trazi u Response-u
    @Expose()  //Gson moze da serijalizuje ili deserijalizuje odgovor
    private Recipe recipe;

    public Recipe getRecipe(){
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}';
    }
}

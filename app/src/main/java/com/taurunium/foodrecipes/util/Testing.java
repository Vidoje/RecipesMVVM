package com.taurunium.foodrecipes.util;

import android.util.Log;

import com.taurunium.foodrecipes.models.Recipe;

import java.util.List;

public class Testing {
    public static void printRecipes(List<Recipe> list, String TAG){
        for (Recipe recipe : list) {
            Log.d(TAG, "Recepti: " + recipe.getTitle());
        }
    }
}

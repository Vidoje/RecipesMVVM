package com.taurunium.foodrecipes.requests;

import com.taurunium.foodrecipes.models.Recipe;
import com.taurunium.foodrecipes.requests.responses.RecipeResponse;
import com.taurunium.foodrecipes.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //@GET("api/search")
    @GET("api/v2/recipes")
    Call<RecipeSearchResponse> searchRecipe(
           // @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("rId") String recipe_id
    );
}

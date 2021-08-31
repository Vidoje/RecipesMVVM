package com.taurunium.foodrecipes.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Recipe implements Parcelable {
    private String title;
    private String publisher;
    private String[] ingredients;
    private String id;
    private String imageUrl;
    private float socialUrl;

    public Recipe() {
    }

    public Recipe(String title, String publisher, String[] ingredients, String id, String imageUrl, float socialUrl) {
        this.title = title;
        this.publisher = publisher;
        this.ingredients = ingredients;
        this.id = id;
        this.imageUrl = imageUrl;
        this.socialUrl = socialUrl;
    }

    protected Recipe(Parcel in) {
        title = in.readString();
        publisher = in.readString();
        ingredients = in.createStringArray();
        id = in.readString();
        imageUrl = in.readString();
        socialUrl = in.readFloat();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getSocialUrl() {
        return socialUrl;
    }

    public void setSocialUrl(float socialUrl) {
        this.socialUrl = socialUrl;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", recipe_id='" + id + '\'' +
                ", image_url='" + imageUrl + '\'' +
                ", social_rank=" + socialUrl +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(publisher);
        dest.writeStringArray(ingredients);
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeFloat(socialUrl);
    }
}

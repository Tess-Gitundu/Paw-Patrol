
package com.example.gitundu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Environment {

    @SerializedName("children")
    @Expose
    private Boolean children;
    @SerializedName("dogs")
    @Expose
    private Boolean dogs;
    @SerializedName("cats")
    @Expose
    private Boolean cats;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Environment() {
    }

    /**
     * 
     * @param cats
     * @param children
     * @param dogs
     */
    public Environment(Boolean children, Boolean dogs, Boolean cats) {
        super();
        this.children = children;
        this.dogs = dogs;
        this.cats = cats;
    }

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Boolean getDogs() {
        return dogs;
    }

    public void setDogs(Boolean dogs) {
        this.dogs = dogs;
    }

    public Boolean getCats() {
        return cats;
    }

    public void setCats(Boolean cats) {
        this.cats = cats;
    }

}

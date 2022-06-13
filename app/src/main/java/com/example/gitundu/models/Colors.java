
package com.example.gitundu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Colors {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("secondary")
    @Expose
    private Object secondary;
    @SerializedName("tertiary")
    @Expose
    private Object tertiary;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Colors() {
    }

    /**
     * 
     * @param secondary
     * @param tertiary
     * @param primary
     */
    public Colors(String primary, Object secondary, Object tertiary) {
        super();
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Object getSecondary() {
        return secondary;
    }

    public void setSecondary(Object secondary) {
        this.secondary = secondary;
    }

    public Object getTertiary() {
        return tertiary;
    }

    public void setTertiary(Object tertiary) {
        this.tertiary = tertiary;
    }

}

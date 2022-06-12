
package com.example.gitundu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("spayed_neutered")
    @Expose
    private Boolean spayedNeutered;
    @SerializedName("house_trained")
    @Expose
    private Boolean houseTrained;
    @SerializedName("declawed")
    @Expose
    private Boolean declawed;
    @SerializedName("special_needs")
    @Expose
    private Boolean specialNeeds;
    @SerializedName("shots_current")
    @Expose
    private Boolean shotsCurrent;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param houseTrained
     * @param declawed
     * @param shotsCurrent
     * @param spayedNeutered
     * @param specialNeeds
     */
    public Attributes(Boolean spayedNeutered, Boolean houseTrained, Boolean declawed, Boolean specialNeeds, Boolean shotsCurrent) {
        super();
        this.spayedNeutered = spayedNeutered;
        this.houseTrained = houseTrained;
        this.declawed = declawed;
        this.specialNeeds = specialNeeds;
        this.shotsCurrent = shotsCurrent;
    }

    public Boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public void setSpayedNeutered(Boolean spayedNeutered) {
        this.spayedNeutered = spayedNeutered;
    }

    public Boolean getHouseTrained() {
        return houseTrained;
    }

    public void setHouseTrained(Boolean houseTrained) {
        this.houseTrained = houseTrained;
    }

    public Boolean getDeclawed() {
        return declawed;
    }

    public void setDeclawed(Boolean declawed) {
        this.declawed = declawed;
    }

    public Boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(Boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public Boolean getShotsCurrent() {
        return shotsCurrent;
    }

    public void setShotsCurrent(Boolean shotsCurrent) {
        this.shotsCurrent = shotsCurrent;
    }

}

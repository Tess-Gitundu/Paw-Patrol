
package com.example.gitundu;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetFinderAnimalsResponse {

    @SerializedName("animals")
    @Expose
    private List<Animal> animals = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PetFinderAnimalsResponse() {
    }

    /**
     * 
     * @param pagination
     * @param animals
     */
    public PetFinderAnimalsResponse(List<Animal> animals, Pagination pagination) {
        super();
        this.animals = animals;
        this.pagination = pagination;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}

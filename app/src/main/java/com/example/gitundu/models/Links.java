
package com.example.gitundu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("organization")
    @Expose
    private Organization organization;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param organization
     * @param self
     * @param type
     */
    public Links(Self self, Type type, Organization organization) {
        super();
        this.self = self;
        this.type = type;
        this.organization = organization;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}

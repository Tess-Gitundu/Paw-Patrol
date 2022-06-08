
package com.example.gitundu;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("organization_id")
    @Expose
    private String organizationId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("breeds")
    @Expose
    private Breeds breeds;
    @SerializedName("colors")
    @Expose
    private Colors colors;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("coat")
    @Expose
    private String coat;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("environment")
    @Expose
    private Environment environment;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Animal() {
    }

    /**
     * 
     * @param gender
     * @param distance
     * @param publishedAt
     * @param description
     * @param type
     * @param photos
     * @param url
     * @param colors
     * @param breeds
     * @param tags
     * @param organizationId
     * @param coat
     * @param environment
     * @param size
     * @param species
     * @param contact
     * @param name
     * @param attributes
     * @param links
     * @param id
     * @param age
     * @param status
     */
    public Animal(Integer id, String organizationId, String url, String type, String species, Breeds breeds, Colors colors, String age, String gender, String size, String coat, String name, String description, List<Photo> photos, String status, Attributes attributes, Environment environment, List<String> tags, Contact contact, String publishedAt, Double distance, Links links) {
        super();
        this.id = id;
        this.organizationId = organizationId;
        this.url = url;
        this.type = type;
        this.species = species;
        this.breeds = breeds;
        this.colors = colors;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.coat = coat;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.status = status;
        this.attributes = attributes;
        this.environment = environment;
        this.tags = tags;
        this.contact = contact;
        this.publishedAt = publishedAt;
        this.distance = distance;
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Breeds getBreeds() {
        return breeds;
    }

    public void setBreeds(Breeds breeds) {
        this.breeds = breeds;
    }

    public Colors getColors() {
        return colors;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}

package com.example.bogdan.vacanciedoumvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public class Vacancy {
    @SerializedName("salary")
    @Expose
    private String mSalary;

    @SerializedName("city")
    @Expose
    private String mCity;

    @SerializedName("link")
    @Expose
    private String mLink;

    @SerializedName("description")
    @Expose
    private String mDescription;

    @SerializedName("title")
    @Expose
    private String mTitle;

    public String getSalary() {
        return mSalary;
    }

    public void setSalary(String salary) {
        mSalary = salary;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


}

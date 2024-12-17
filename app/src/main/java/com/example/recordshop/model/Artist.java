package com.example.recordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Artist extends BaseObservable {
    private long id;
    private String name;
    private String country;

    public Artist() {}
    public Artist(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Bindable
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}

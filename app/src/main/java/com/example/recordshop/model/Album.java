package com.example.recordshop.model;



import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class Album extends BaseObservable {
    private long id;
    private String name;
    private String releaseYear;
    private String genre;
    private Artist artist;

    private String coverUrl;

    public Album(long id, String name, String releaseYear, String genre, Artist artist, String coverUrl) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
        this.coverUrl = coverUrl;
    }

    public Album(){}

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Bindable
    public String getCoverUrl()
    {return coverUrl;}

    public void setCoverUrl(String coverUrl){
        this.coverUrl = coverUrl;
    }

}

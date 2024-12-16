package com.example.recordshop.model;

public class Album {
    private long id;
    private String name;
    private Integer releaseYear;
    private String genre;
    private String artist;
    public Album(long id, String name, Integer releaseYear, String genre, String artist) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
    }

    public Album(){}
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}

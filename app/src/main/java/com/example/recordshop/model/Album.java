package com.example.recordshop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Album extends BaseObservable implements Parcelable {
    private Long id;
    private String name;
    private String releaseYear;
    private String genre;
    private Artist artist;
    private String coverUrl;

    public Album(Long id, String name, String releaseYear, String genre,
                 Artist artist, String coverUrl) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
        this.coverUrl = coverUrl;
    }

    public Album(){}

    protected Album(Parcel in) {
        id = in.readLong();
        name = in.readString();
        releaseYear = in.readString();
        genre = in.readString();
        artist = in.readParcelable(Artist.class.getClassLoader());
        coverUrl = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {

        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(releaseYear);
        dest.writeString(genre);
        dest.writeParcelable(artist,flags);
        dest.writeString(coverUrl);
    }
}

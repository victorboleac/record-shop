package com.example.recordshop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class Artist extends BaseObservable implements Parcelable {
    private Long id;
    private String name;
    private String country;

    public Artist() {}
    public Artist(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(country);
    }
    protected Artist(Parcel in) {
        id = in.readLong();
        name = in.readString();
        country = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}

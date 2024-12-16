package com.example.recordshop.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("albums")
    Call<List<Album>> getAllAlbums();
}

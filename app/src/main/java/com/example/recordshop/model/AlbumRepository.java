package com.example.recordshop.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application){this.application = application;}

    public MutableLiveData<List<Album>> getMutableLiveData(){
        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.i("GET request", t.getMessage());

            }
        });
        return mutableLiveData;
    }
    public void addAlbum(Album album){
        AlbumApiService albumApiService=RetrofitInstance.getService();
        Call<Album> call = albumApiService.addAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album added to Database",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to add album to Database",
                        Toast.LENGTH_SHORT).show();

                Log.e("POST onFailure", t.getMessage());


            }
        });
    }
    public void updateAlbum(long id, Album album){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album updated",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to update the album",
                        Toast.LENGTH_SHORT).show();

                Log.e("PUT request", t.getMessage());

            }
        });
    }
    public void deleteAlbum(long id){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<String> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(application.getApplicationContext(), response.body(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("DELETE request", t.getMessage());

            }
        });
    }

}

package com.example.recordshop.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recordshop.model.Album;
import com.example.recordshop.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums(){
        return albumRepository.getMutableLiveData();
    }
}

package com.example.recordshop.ui.addAlbum;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.Artist;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);

        Album album = new Album();
        album.setArtist(new Artist());

        ActivityAddNewAlbumBinding binding = DataBindingUtil
               .setContentView(this, R.layout.activity_add_new_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        AddNewAlbumClickHandler handler = new AddNewAlbumClickHandler(album,
                this, viewModel, binding);

        binding.setAlbum(album);

        binding.setClickHandler(handler);
    }
}
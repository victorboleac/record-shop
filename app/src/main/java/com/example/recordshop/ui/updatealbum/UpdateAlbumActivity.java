package com.example.recordshop.ui.updatealbum;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityUpdateAlbumBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {
    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_update_album);

        Album album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);

        ActivityUpdateAlbumBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        UpdateAlbumClickHandler handler = new UpdateAlbumClickHandler(album,
                this, viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(handler);

    }
}
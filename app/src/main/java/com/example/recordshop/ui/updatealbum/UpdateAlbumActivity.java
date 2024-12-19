package com.example.recordshop.ui.updatealbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityUpdateAlbumBinding;

public class UpdateAlbumActivity extends AppCompatActivity {

    private static final String ALBUM_KEY = "album";
    private ActivityUpdateAlbumBinding binding;

    private UpdateAlbumClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_album);

    }
}
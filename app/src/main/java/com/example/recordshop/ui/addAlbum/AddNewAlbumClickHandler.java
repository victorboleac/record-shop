package com.example.recordshop.ui.addAlbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordshop.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.Artist;
import com.example.recordshop.ui.mainactivity.MainActivity;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumClickHandler {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;
    private ActivityAddNewAlbumBinding binding;

    public AddNewAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel,
                                   ActivityAddNewAlbumBinding binding) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
        this.binding = binding;
    }

    public void onSubmitBtnClicked(View view){
        String artistName = binding.editArtist.getText().toString().trim();
        String artistCountry = binding.editCountry.getText().toString().trim();

        if(album.getName()==null) Toast.makeText(context,
                "AlbumName cannot be empty", Toast.LENGTH_SHORT).show();

        else if(album.getReleaseYear()==null) Toast.makeText(context,
                "Release year cannot be empty", Toast.LENGTH_SHORT).show();

        else if (album.getGenre()==null) Toast.makeText(context,
                "Genre cannot be empty", Toast.LENGTH_SHORT).show();

        else if (album.getCoverUrl()==null) Toast.makeText(context,
                "Cover URL cannot be empty", Toast.LENGTH_SHORT).show();

        else {
            Artist artist = new Artist();
            Intent intent = new Intent(context, MainActivity.class);


            artist.setName(artistName);
            artist.setCountry(artistCountry);
            album.setArtist(artist);


            viewModel.addAlbum(album);
            context.startActivity(intent);
        }
    }

    public void onBackBtnClicked(View view){

        Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
    }
}

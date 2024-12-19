package com.example.recordshop.ui.addAlbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.MainActivity;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumClickHandler {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddNewAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitBtnClicked(View view){
        if(album.getName()==null) Toast.makeText(context,"AlbumName cannot be empty", Toast.LENGTH_SHORT).show();
        else if(album.getReleaseYear()==null) Toast.makeText(context,"Release year cannot be empty", Toast.LENGTH_SHORT).show();
        else if (album.getGenre()==null) Toast.makeText(context,"Genre cannot be empty", Toast.LENGTH_SHORT).show();
        else if (album.getCoverUrl()==null) Toast.makeText(context,"Cover URL cannot be empty", Toast.LENGTH_SHORT).show();

        else {
            Intent intent = new Intent(context, MainActivity.class);
            viewModel.addAlbum(album);
            context.startActivity(intent);
        }
    }

    public void onBackBtnClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}

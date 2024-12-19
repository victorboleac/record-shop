package com.example.recordshop.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.MainActivity;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;
    private long id;

    public UpdateAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }
    public void onBackBtnClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onSubmitBtnClicked(View view){
       Album updatedAlbum = new Album(
                album.getId(),
                album.getName(),
                album.getReleaseYear(),
                album.getGenre(),
                album.getArtist(),
                album.getCoverUrl()
       );
        if (Objects.equals(updatedAlbum.getArtist(),"")||
                Objects.equals(updatedAlbum.getName(),"")||
                Objects.equals(updatedAlbum.getGenre(),"")||
                Objects.equals(updatedAlbum.getReleaseYear(),"")||
                Objects.equals(updatedAlbum.getCoverUrl(),"")) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent(context, MainActivity.class);
            viewModel.updateAlbum(album.getId(), updatedAlbum);
            context.startActivity(intent);
        }


    }
    public void onDeleteBtnClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        viewModel.deleteAlbum(album.getId());
        context.startActivity(intent);

    }





}

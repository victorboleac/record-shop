package com.example.recordshop.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.recordshop.ui.addAlbum.AddNewAlbumActivity;

public class MainActivityClickhandler {

    private Context context;

    public MainActivityClickhandler(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view){
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}

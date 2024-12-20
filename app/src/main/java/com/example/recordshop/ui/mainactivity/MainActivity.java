package com.example.recordshop.ui.mainactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.ui.updatealbum.UpdateAlbumActivity;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private static final String ALBUM_KEY = "album";

    private List<Album> filteredAlbumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
    );

    viewModel = new ViewModelProvider(this)
            .get(MainActivityViewModel.class);
        MainActivityClickHandler handler = new MainActivityClickHandler(this);

    binding.setClickHandler(handler);

    getAllAlbums();


    SearchView searchByArtistView = findViewById(R.id.searchByArtistView);
    SearchView searchView = findViewById(R.id.searchView);

    searchByArtistView.clearFocus();
    searchView.clearFocus();

    searchByArtistView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            filterByArtist(newText);
            return true;
        }
    });


    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            filterList(newText);
            return true;
        }
    });


    }

    private void filterByArtist(String newText) {

        filteredAlbumList = new ArrayList<>();

        for (Album album:albumList)
            if (album.getArtist().getName().toLowerCase()
                .contains(newText.toLowerCase()))
                filteredAlbumList.add(album);

        if (filteredAlbumList.isEmpty())
            Toast.makeText(this,"No albums found!",
                Toast.LENGTH_SHORT).show();

        else albumAdapter.setFilteredList(filteredAlbumList);
    }

    private void filterList(String newText) {

        filteredAlbumList = new ArrayList<>();

        for (Album album: albumList)
            if (album.getName().toLowerCase()
                .contains(newText.toLowerCase()))
                filteredAlbumList.add(album);

        if(filteredAlbumList.isEmpty())
            Toast.makeText(this, "No albums found!",
                Toast.LENGTH_SHORT).show();

        else albumAdapter.setFilteredList(filteredAlbumList);


    }
    private void getAllAlbums() {

        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {

            @Override
            public void onChanged(List<Album> albums) {

                albumList = albums;

                displayAlbumsInRecyclerView();
            }
        });
    }
    @SuppressLint("NotifyDataSetChanged")
    private void displayAlbumsInRecyclerView(){

        RecyclerView recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this, UpdateAlbumActivity.class);

        if(filteredAlbumList==null || filteredAlbumList.isEmpty())
            intent.putExtra(ALBUM_KEY, albumList.get(position));

        else intent.putExtra(ALBUM_KEY, filteredAlbumList.get(position));

        startActivity(intent);

    }


}
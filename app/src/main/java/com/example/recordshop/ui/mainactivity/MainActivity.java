package com.example.recordshop.ui.mainactivity;

import android.app.Application;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.AlbumRepository;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

    binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
    );

    viewModel = new ViewModelProvider(this)
            .get(MainActivityViewModel.class);
    handler = new MainActivityClickHandler(this);

    binding.setClickHandler(handler);

    getAllAlbums();


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
    private void displayAlbumsInRecyclerView(){
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this)      ;
        recyclerView.setLayoutManager(linearLayoutManager);
        albumAdapter.notifyDataSetChanged();
    }
}
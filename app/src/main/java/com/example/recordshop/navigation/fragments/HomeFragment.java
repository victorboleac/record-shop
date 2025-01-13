package com.example.recordshop.navigation.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.FragmentHomeBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.AlbumAdapter;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;
import com.example.recordshop.ui.mainactivity.RecyclerViewInterface;
import com.example.recordshop.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements RecyclerViewInterface {
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private FragmentHomeBinding binding;
    private MainActivityViewModel viewModel;
    private static final String ALBUM_KEY = "album";

    private List<Album> filteredAlbumList;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
        setupRecyclerView();

        getAllAlbums();


        binding.searchByArtistView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

    private void setupRecyclerView(){
        albumAdapter = new AlbumAdapter(new ArrayList<>(), this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(albumAdapter);
    }

    private void getAllAlbums(){
        viewModel.getAllAlbums().observe(getViewLifecycleOwner(), albums -> {
            albumList = albums;
            albumAdapter.setFilteredList(albumList);
        });
    }

    private void filterByArtist(String newText){

        filteredAlbumList = new ArrayList<>();

        for (Album album:albumList)
            if(album.getArtist().getName().toLowerCase().contains(newText.toLowerCase()))
                filteredAlbumList.add(album);


        if (filteredAlbumList.isEmpty()) albumAdapter.setFilteredList(new ArrayList<>());
        else albumAdapter.setFilteredList(filteredAlbumList);

    }

    private void filterList(String newText){

        filteredAlbumList = new ArrayList<>();

        for(Album album:albumList)
            if(album.getName().toLowerCase().contains(newText.toLowerCase()))
                filteredAlbumList.add(album);

        if(filteredAlbumList.isEmpty()) albumAdapter.setFilteredList(new ArrayList<>());
        else albumAdapter.setFilteredList(filteredAlbumList);

    }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(requireContext(), UpdateAlbumActivity.class);

        if (filteredAlbumList == null || filteredAlbumList.isEmpty())
            intent.putExtra(ALBUM_KEY, albumList.get(position));

        else intent.putExtra(ALBUM_KEY, filteredAlbumList.get(position));

        startActivity(intent);
    }
}
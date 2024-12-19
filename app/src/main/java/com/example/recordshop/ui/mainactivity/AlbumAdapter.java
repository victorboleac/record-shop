package com.example.recordshop.ui.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recordshop.R;
import com.example.recordshop.databinding.AlbumItemBinding;
import com.example.recordshop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;


    private List<Album> albumList;
    public AlbumAdapter(List<Album> albumList, RecyclerViewInterface recyclerViewInterface){
        this.recyclerViewInterface = recyclerViewInterface;
        this.albumList = albumList;
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        private AlbumItemBinding binding;
        public AlbumViewHolder(AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumItemBinding.getRoot());
            this.binding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item,
                parent,
                false
        );
        return new AlbumViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.binding.setAlbum(album);
        Glide.with(holder.itemView.getContext())
                .load(album.getCoverUrl())
                .into(holder.binding.albumImage);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


}

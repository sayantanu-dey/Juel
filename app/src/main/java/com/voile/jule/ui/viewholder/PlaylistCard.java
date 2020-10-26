package com.voile.jule.ui.viewholder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.voile.jule.database.model.PlaylistEntity;
import com.voile.jule.databinding.PlaylistCardBinding;
import com.voile.jule.media.Playlist;
import com.voile.jule.ui.adapter.ItemOnClickListner;

import java.io.IOException;

public class PlaylistCard extends RecyclerView.ViewHolder{
    private final PlaylistCardBinding binding;
    public PlaylistCard(PlaylistCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(PlaylistEntity playlistEntity , Context context, ItemOnClickListner listner) throws IOException {
        Playlist playlist = playlistEntity.getPlaylist();
        if(playlist.songs.size()>0){ binding.i1.setImageBitmap(playlist.songs.get(0).getThumbnail(context,90,90)); }
        if(playlist.songs.size()>1){ binding.i2.setImageBitmap(playlist.songs.get(1).getThumbnail(context,90,90)); }
        if(playlist.songs.size()>2){ binding.i3.setImageBitmap(playlist.songs.get(2).getThumbnail(context,90,90)); }
        if(playlist.songs.size()>3){ binding.i4.setImageBitmap(playlist.songs.get(3).getThumbnail(context,90,90)); }
        binding.name.setText(playlist.getName());
        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlist.play(context);
            }
        });

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playlistEntity.getPlaylist()!=null && listner!=null){
                    try {
                        listner.onItemClick(playlistEntity.getPlaylist());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}

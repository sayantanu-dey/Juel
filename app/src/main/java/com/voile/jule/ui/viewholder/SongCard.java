package com.voile.jule.ui.viewholder;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.RecyclerView;

import com.voile.jule.R;
import com.voile.jule.databinding.SongCardBinding;
import com.voile.jule.media.Song;
import com.voile.jule.ui.adapter.ItemOnClickListner;

import java.io.IOException;

public class SongCard extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
    private final SongCardBinding binding;
    public SongCard(SongCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }



    public void bind(Song song, Context context, ItemOnClickListner listner) throws IOException {
        binding.thumbnail.setImageBitmap(song.getThumbnail(context,150,150));
        binding.title.setText(song.getTrack());
        binding.artist.setText(song.getArtist());
        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.song_card_menu, popupMenu.getMenu());
                popupMenu.show();
            }
        });

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(song!=null && listner!=null){
                    try {
                        listner.onItemClick(song);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addtoplaylist: //TODO
                return true;
            default:
                return false;
        }
    }
}

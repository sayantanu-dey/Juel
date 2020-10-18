package com.voile.jule.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.voile.jule.databinding.SongCardBinding;
import com.voile.jule.media.Media;
import com.voile.jule.media.Song;
import com.voile.jule.ui.viewholder.SongCard;

import java.io.IOException;



public class SongRecyclerViewAdapter extends ListAdapter<Song, RecyclerView.ViewHolder> {

    private Context context;
    private ItemOnClickListner listner;

    public SongRecyclerViewAdapter(Context context) {
        super(DIFFCALLBACK);
        this.context = context;
    }



    private  static DiffUtil.ItemCallback<Song> DIFFCALLBACK = new DiffUtil.ItemCallback<Song>() {
        @Override
        public boolean areItemsTheSame(@NonNull Song oldItem, @NonNull Song newItem) {
            return oldItem==newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Song oldItem, @NonNull Song newItem) {
            return oldItem.equals(newItem);
        }
    };


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SongCardBinding songbinding = SongCardBinding.inflate(inflater,parent,false);
        return new SongCard(songbinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((SongCard) holder).bind((Song) getItem(position),context,listner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setItemOnClickListner(ItemOnClickListner listner){
        this.listner = listner;
    }

}

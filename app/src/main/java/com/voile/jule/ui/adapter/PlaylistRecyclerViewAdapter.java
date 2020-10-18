package com.voile.jule.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.voile.jule.database.model.PlaylistEntity;
import com.voile.jule.databinding.PlaylistCardBinding;
import com.voile.jule.ui.viewholder.PlaylistCard;
import java.io.IOException;

public class PlaylistRecyclerViewAdapter extends ListAdapter<PlaylistEntity, RecyclerView.ViewHolder> {

    private ItemOnClickListner listner;
    private Context context;

    public PlaylistRecyclerViewAdapter(Context context) {
        super(DIFFCALLBACK);
        this.context = context;
    }


    private  static DiffUtil.ItemCallback<PlaylistEntity> DIFFCALLBACK = new DiffUtil.ItemCallback<PlaylistEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull PlaylistEntity oldItem, @NonNull PlaylistEntity newItem) {
            return oldItem==newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull PlaylistEntity oldItem, @NonNull PlaylistEntity newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PlaylistCardBinding binding = PlaylistCardBinding.inflate(inflater,parent,false);
        return new PlaylistCard(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((PlaylistCard) holder).bind((PlaylistEntity) getItem(position),context, listner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setItemOnClickListner(ItemOnClickListner listner){
        this.listner = listner;
    }

}

package com.voile.jule.ui.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.voile.jule.R;
import com.voile.jule.dao.DeviceMediaFetch;
import com.voile.jule.databinding.BaseActivityMainBinding;
import com.voile.jule.databinding.MusicFragmentBinding;
import com.voile.jule.media.JuleMediaPlayer;
import com.voile.jule.media.Media;
import com.voile.jule.media.Song;
import com.voile.jule.ui.adapter.ItemOnClickListner;
import com.voile.jule.ui.adapter.SongRecyclerViewAdapter;
import com.voile.jule.ui.repository.SongListRepository;
import com.voile.jule.ui.view.activities.BaseActivity;
import com.voile.jule.ui.view.activities.MusicPlayerActivity;
import com.voile.jule.ui.viewmodel.MusicFragmentViewModel;

import java.io.IOException;
import java.io.Serializable;

public class MusicFragment extends Fragment {

    private BaseActivity baseActivity;

    public MusicFragment(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    private MusicFragmentBinding binding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.music_fragment,null);
        binding = DataBindingUtil.inflate(inflater,R.layout.music_fragment,container,false);
        View view = ((ViewDataBinding) binding).getRoot();
        SongListRepository repository = new SongListRepository(getContext());
        MusicFragmentViewModel viewModel = getViewModel(repository);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SongRecyclerViewAdapter adapter = new SongRecyclerViewAdapter(getContext());
        binding.recyclerView.setAdapter(adapter);
        Log.i(">>","loaded");
       // DeviceMediaFetch.getDeviceSongs(getContext()).get(0).getTrack();
        viewModel.getAllDeviceSongs().observe(getViewLifecycleOwner(), adapter::submitList);
        adapter.setItemOnClickListner(new ItemOnClickListner() {
            @Override
            public void onItemClick(Media media) throws IOException {
                JuleMediaPlayer.getInstance(getContext()).LoadSong((Song)media);
                baseActivity.toggleMediaVisibility(View.VISIBLE);
//                Intent intent = new Intent(getContext(), MusicPlayerActivity.class);
//                intent.putExtra(MusicPlayerActivity.SONG,media);
//                startActivity(intent);

            }
        });
     //   adapter.submitList(DeviceMediaFetch.getDeviceSongs(getContext()));
        return view;
    }

    private MusicFragmentViewModel getViewModel(SongListRepository repository){

        MusicFragmentViewModel viewModel=  new ViewModelProvider.NewInstanceFactory().create(MusicFragmentViewModel.class);
        viewModel.setRepository(repository);
        return viewModel;
    }


}

package com.voile.jule.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.voile.jule.R;
import com.voile.jule.ui.repository.DatabaseRepository;
import com.voile.jule.databinding.PlaylistFragmentBinding;
import com.voile.jule.ui.adapter.PlaylistRecyclerViewAdapter;
import com.voile.jule.ui.viewmodel.PlaylistFragmentViewModel;

public class PlaylistFragment extends  Fragment {

    PlaylistFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.playlist_fragment,container,false);
        View view = binding.getRoot();
        DatabaseRepository repository = new DatabaseRepository(getContext());
        PlaylistFragmentViewModel viewModel = getViewModel(repository);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        PlaylistRecyclerViewAdapter adapter = new PlaylistRecyclerViewAdapter(getContext());
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(adapter);

        viewModel.fetchPlaylists().observe(getViewLifecycleOwner(), adapter::submitList);

        return view;
    }

    private PlaylistFragmentViewModel getViewModel(DatabaseRepository repository){

        PlaylistFragmentViewModel viewModel=  new ViewModelProvider.NewInstanceFactory().create(PlaylistFragmentViewModel.class);
        viewModel.setRepository(repository);
        return viewModel;
    }
}

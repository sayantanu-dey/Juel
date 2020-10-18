package com.voile.jule.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.voile.jule.R;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.home_fragment,null);
    }
}


//        Playlist p1 = new Playlist("eena");
//        Playlist p2 = new Playlist("meena");
//        Playlist p3 = new Playlist("deeka");
//        List<Playlist> playlists = new ArrayList<>();
//        playlists.add(p1);
//        playlists.add(p2);
//        playlists.add(p3);
//        DatabaseRepository repository = new DatabaseRepository(getContext());
//        repository.deleteAll();
//        repository.insert(new PlaylistEntity(p1));
//        repository.insert(new PlaylistEntity(p2));
//        repository.insert(new PlaylistEntity(p3));
//        repository.insert(new PlaylistEntity(p3));
//
//        repository.fetchAllPlaylists().observe(getViewLifecycleOwner(),playlists -> {
//            //Toast.makeText(getContext(), "asdasdas", Toast.LENGTH_SHORT).show();
//            Log.i(">>>>","success" + playlists.size());
//            if(playlists.size()>0){
//                Log.i(">>>>","success" + playlists.get(0).getPlaylist().getName());
//            }
//        });

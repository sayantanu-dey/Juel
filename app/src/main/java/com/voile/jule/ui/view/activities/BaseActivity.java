package com.voile.jule.ui.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.voile.jule.R;
import com.voile.jule.databinding.BaseActivityMainBinding;

import com.voile.jule.media.JuleMediaPlayer;
import com.voile.jule.media.Song;
import com.voile.jule.ui.view.fragments.MusicFragment;
import com.voile.jule.ui.view.fragments.PlaylistFragment;
import com.voile.jule.ui.view.fragments.YoutubeFragment;

import java.io.IOException;

public class BaseActivity extends AppCompatActivity{

    public static final int MY_PERMISSION_REQUEST = 1;


    BaseActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.base_activity_main);


        binding.bottomNavBar.setItemSelected(R.id.music_chip,true);
        loadFragment(new MusicFragment(this));

        binding.bottomNavBar.setOnItemSelectedListener(id -> {
            Fragment fragment = null;
            switch (id){
                case R.id.playlist_chip: fragment = new PlaylistFragment();break;
                case R.id.music_chip: fragment = new MusicFragment(this); break;
                case R.id.youtube_chip: fragment = new YoutubeFragment(); break;
            }
            loadFragment(fragment);
        });

    }

    private void loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
        }
    }

    public void toggleMediaVisibility(int visibilty) throws IOException {
        if(visibilty == View.VISIBLE){
            Song song = JuleMediaPlayer.getInstance(getApplicationContext()).getCurrentSong();
            binding.thubnailbottom.setImageBitmap(song.getThumbnail(getApplicationContext(),100,100));
            binding.navMediaPlayer.setVisibility(View.VISIBLE);
        }
        else{
            binding.navMediaPlayer.setVisibility(View.GONE);
        }
    }

}
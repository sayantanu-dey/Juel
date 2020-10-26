package com.voile.jule.ui.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.voile.jule.R;
import com.voile.jule.databinding.MusicPlayerActivityBinding;
import com.voile.jule.media.Media;
import com.voile.jule.media.Playable;
import com.voile.jule.media.Song;
import com.voile.jule.ui.view.fragments.MusicFragment;

import java.io.IOException;

public class MusicPlayerActivity extends AppCompatActivity{

    public static final String SONG = "com.voile.jule.ui.view.activities.SONG";
    MusicPlayerActivityBinding binding;
    private Song song;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.music_player_activity);
        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            Song song = intent.getParcelableExtra(SONG);
            assert song != null;
            binding.songtitle.setText(song.getTrack());
            binding.songartist.setText(song.getArtist());
            try {
                binding.songthumbnail.setImageBitmap(song.getThumbnail(getApplicationContext(),300,300));
            } catch (IOException e) {
                e.printStackTrace();
            }
            binding.duration.setText(song.getDuration()+"");

        }
        else{
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

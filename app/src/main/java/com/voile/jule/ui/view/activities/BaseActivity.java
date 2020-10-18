package com.voile.jule.ui.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.voile.jule.R;
import com.voile.jule.databinding.BaseActivityMainBinding;

import com.voile.jule.ui.view.fragments.MusicFragment;
import com.voile.jule.ui.view.fragments.HomeFragment;
import com.voile.jule.ui.view.fragments.PlaylistFragment;
import com.voile.jule.ui.view.fragments.YoutubeFragment;

public class BaseActivity extends AppCompatActivity{

    public static final int MY_PERMISSION_REQUEST = 1;

    BaseActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.base_activity_main);

//        RotateAnimation rotate = new RotateAnimation(
//                0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f
//        );
//        rotate.setDuration(1500);
//        rotate.setRepeatCount(Animation.INFINITE);
//        binding.fab.setAnimation(rotate);
//        binding.fab.setOnClickListener(v -> {
//            int visibility = View.VISIBLE;
//            if(binding.extendedNav.getVisibility()==visibility) visibility = View.GONE;
//            binding.extendedNav.setVisibility(visibility);
//        });

        binding.bottomNavBar.setItemSelected(R.id.music_chip,true);
        loadFragment(new MusicFragment());

        binding.bottomNavBar.setOnItemSelectedListener(id -> {
            Fragment fragment = null;
            switch (id){
                case R.id.playlist_chip: fragment = new PlaylistFragment();break;
                case R.id.music_chip: fragment = new MusicFragment(); break;
                case R.id.youtube_chip: fragment = new YoutubeFragment(); break;
            }
            loadFragment(fragment);
        });

    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
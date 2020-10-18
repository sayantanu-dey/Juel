package com.voile.jule.ui.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.voile.jule.media.Playlist;

import java.util.List;

public class PlaylistDialog {

//    public static String playlistname = "";
//
//    public static void showAddToPlaylistDialog(List<Playlist> playlists, Context context, FragmentActivity activity){
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,android.R.layout.select_dialog_singlechoice);
//        for(Playlist playlist: playlists){
//            arrayAdapter.add(playlist.getName());
//        }
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle("Add to Playlist");
//        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.setPositiveButton("new playlist", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                createPlaylist(context,activity);
//
//            }
//        });
//
//        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String name = arrayAdapter.getItem(which);
//                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.show();
//    }
//
//    public static void createPlaylist(Context context,FragmentActivity activity){
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle("Create Playlist");
//
//        final EditText editText = new EditText(context);
//        editText.setInputType(InputType.TYPE_CLASS_TEXT);
//        builder.setView(editText);
//
//        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.setPositiveButton("create", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                playlistname = editText.getText().toString();
//            }
//        });
//    }

}

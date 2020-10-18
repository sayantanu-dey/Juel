package com.voile.jule.media;

import android.content.Context;
import android.os.Parcelable;

public interface Media extends Parcelable {
    void play(Context context);
    void pause(Context context);
    void restart(Context context);
}

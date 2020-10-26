package com.voile.jule.media;

import java.io.IOException;

public interface Playable {
    void onTrackPrevious() throws IOException;
    void onTrackPlay() throws IOException;
    void onTrackPause() throws IOException;
    void onTrackNext() throws IOException;
}

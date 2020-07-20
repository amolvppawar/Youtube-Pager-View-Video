package com.amol.ytfinal.viewPagerExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import  com.amol.ytfinal.VideoIdsProvider;
import com.amol.ytfinal.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ViewPagerFragment extends Fragment {

    private String videoId = VideoIdsProvider.getNextVideoId();
    private YouTubePlayer initializedYouTubePlayer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_view_pager, container, false);

        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);

       getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo(videoId, 0);
                initializedYouTubePlayer = youTubePlayer;
                onPlaybackQualityChange(initializedYouTubePlayer, PlayerConstants.PlaybackQuality.MEDIUM);
            }
        });
        youTubePlayerView.enableBackgroundPlayback(false);


        return view;
    }






    // pause when fragment goes
    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (!visible && initializedYouTubePlayer != null)
            initializedYouTubePlayer.pause();
    }
}
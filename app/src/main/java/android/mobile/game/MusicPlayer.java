package android.mobile.game;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MusicPlayer
{
    private final MediaPlayer musicPlayer;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public MusicPlayer(MediaPlayer player) {
        musicPlayer = player;
    }

    public MusicPlayer(Context context, int resid) {
        musicPlayer = MediaPlayer.create(context, resid);
        musicPlayer.setLooping(true);
    }

    public void play()
    {
        double volume = GameSettings.getInstance().getMusicVolume();
        this.play(volume);
    }

    public void play(double volume) {
        this.setVolume(volume);
        executor.execute(() -> {
            MusicPlayer.this.musicPlayer.start();
        });
    }

    public void pause() {
        //executor.shutdown();
        this.musicPlayer.pause();
    }

    public MediaPlayer getMediaPlayer() {
        return this.getMediaPlayer();
    }

    public void setVolume(double volume) {
        float playerVolume = (float) (1 - (Math.log(GameSettings.defaultMaxVolume - volume) / Math.log(GameSettings.defaultMaxVolume)));
        playerVolume = Float.isInfinite(playerVolume) ? 1.0f : playerVolume;
        this.musicPlayer.setVolume(playerVolume, playerVolume);
    }
}

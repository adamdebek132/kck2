package android.mobile.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MazeActivity extends AppCompatActivity
{
    private MusicPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        backgroundMusic = new MusicPlayer(MazeActivity.this, R.raw.timer);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
    }

    @Override
    protected void onPause() {
        super.onPause();
        backgroundMusic.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundMusic.play();
    }
}
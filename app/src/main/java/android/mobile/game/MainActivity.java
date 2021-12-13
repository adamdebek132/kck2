package android.mobile.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView menu_img;
    private MusicPlayer backgroundMusic;
    private Button jokerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        menu_img = findViewById(R.id.imageView);
        //jokerButton = findViewById(R.id.joker_button);
        backgroundMusic = new MusicPlayer(MainActivity.this, R.raw.menumusic);
/*
        jokerButton.setOnClickListener((v) -> {
            Random r  = new Random();
            int n = r.nextInt(5)+1; //5 - liczba aktywnośco
            Class randomActivity = null;
            switch(n){
                case 1:
                    randomActivity = Quiz.class;
                    break;
                case 2:
                    randomActivity = Level_Fridge.class;
                    break;
                case 3:
                    randomActivity = MazeActivity.class;
                    break;
                case 4:
                    randomActivity = GameActivity.class;
                    break;
                case 5:
                    randomActivity = DragAndDropTest.class;
                    break;
            }
            Intent intent = new Intent(getBaseContext(), randomActivity);
            startActivity(intent);
        }); */
    }

    public void openNewGameActivity (View view){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void openGameActivity(View view)
    {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void openFridge(View view)
    {
        Intent intent = new Intent(this, Level_Fridge.class);
        startActivity(intent);
    }

    public void openOptionsActivity (View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }
    public void openCreditsActivity (View view){
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }

    public void openMazeActivity (View view){
        Intent intent = new Intent(this, MazeActivity.class);
        startActivity(intent);
    }

    public void openDragAndDropTest (View view){
        Intent intent = new Intent(this, DragAndDropTest.class);
        startActivity(intent);
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
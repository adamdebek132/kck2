package android.mobile.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class OptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        SeekBar volumeBar = findViewById(R.id.VolumeSeekBar);
        volumeBar.setProgress((int) GameSettings.getInstance().getMusicVolume());
        TextView progressText = findViewById(R.id.SoundValueText);
        progressText.setText(String.format(Locale.US,"%d%%", (int) GameSettings.getInstance().getMusicVolume()));

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView progressText = findViewById(R.id.SoundValueText);
                progressText.setText(String.format(Locale.US,"%d%%",progress));
                GameSettings.getInstance().setMusicVolume(progress*1.0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Notification that the user has started a touch gesture. Clients may want to use this to disable advancing the seekbar.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Notification that the user has stopped a touch gesture
            }
        });
    }
}
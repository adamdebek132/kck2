package android.mobile.game;

public class GameSettings
{
    private final static GameSettings settings = new GameSettings(); // eager initialization
    public static final double defaultMaxVolume = 100.0d;
    private double musicVolume = defaultMaxVolume;
    private double soundVolume = defaultMaxVolume;

    private GameSettings() {}

    static GameSettings getInstance() {
        return settings;
    }

    double getMusicVolume() {
        return this.musicVolume;
    }

    void setMusicVolume(double volume) {
        this.musicVolume = volume;
    }

    double getSoundVolume() {
        return this.soundVolume;
    }

    void setSoundVolume(double volume) {
        this.soundVolume = volume;
    }
}

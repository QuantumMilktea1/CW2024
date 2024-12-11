package com.example.demo.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The BackgroundMusic class is responsible for managing background music playback.
 * It initializes a MediaPlayer with a specified music file and provides methods to play, stop, and adjust the volume of the music.
 */
public class BackgroundMusic {
    private MediaPlayer mediaPlayer;

    public static final String MENU_MUSIC = "/music/backgroundmusic.mp3";
    public static final String LEVEL_ONE_MUSIC = "/music/backgroundmusic.mp3";
    public static final String LEVEL_TWO_MUSIC = "/music/backgroundmusic.mp3";

    /**
     * Constructs a BackgroundMusic object with the specified music file path.
     * 
     * @param musicFilePath the path to the music file to be played
     */
    public BackgroundMusic(String musicFilePath) {
        try {
            String path = getClass().getResource(musicFilePath).toExternalForm();
            Media sound = new Media(path);
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(-1); // 无限循环
            mediaPlayer.setVolume(0.5);
        } catch (Exception e) {
            System.out.println("Background music could not be loaded: " + musicFilePath);
            e.printStackTrace();
        }
    }

    /**
     * Plays the background music if the MediaPlayer is initialized.
     */
    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    /**
     * Stops the background music if the MediaPlayer is initialized.
     */
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    /**
     * Sets the volume of the background music.
     * 
     * @param volume the volume level to set (0.0 to 1.0)
     */
    public void setVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
} 
package com.example.demo.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusic {
    private MediaPlayer mediaPlayer;

    public static final String MENU_MUSIC = "/music/backgroundmusic.mp3";
    public static final String LEVEL_ONE_MUSIC = "/music/backgroundmusic.mp3";
    public static final String LEVEL_TWO_MUSIC = "/music/backgroundmusic.mp3";

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

    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void setVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
} 
package com.example.demo.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class StartScreen {

    private final Stage stage;
    private final Controller controller;
    private MediaPlayer mediaPlayer;

    public StartScreen(Stage stage, Controller controller) {
        this.stage = stage;
        this.controller = controller;
        initializeBackgroundMusic();
    }

    private void initializeBackgroundMusic() {
        try {
            String musicFile = "/music/backgroundmusic.mp3";  // 请确保这个文件存在
            Media sound = new Media(getClass().getResource(musicFile).toExternalForm());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // 循环播放
            mediaPlayer.setVolume(0.5); // 设置音量为50%
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Background music could not be loaded");
        }
    }

    public void show() {
        // Create a label for the title
        Label titleLabel = new Label("SKY BATTLE");
        titleLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        titleLabel.setTextFill(Color.YELLOW);

        // Style the buttons
        String buttonStyle = "-fx-font-size: 20px; " +
                "-fx-padding: 10px 30px; " +
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 5px;";

        Button startButton = new Button("Start Game");
        startButton.setStyle(buttonStyle);
        startButton.setOnAction(e -> {
            try {
                stopBackgroundMusic();
                controller.launchGame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setStyle(buttonStyle.replace("#4CAF50", "#f44336")); // Red color for exit
        exitButton.setOnAction(e -> {
            stopBackgroundMusic();
            stage.close();
        });

        // Create a VBox to hold the title and buttons
        VBox vbox = new VBox(30);
        vbox.getChildren().addAll(titleLabel, startButton, exitButton);
        vbox.setStyle("-fx-alignment: center; -fx-padding: 20px; " +
                "-fx-background-color: rgba(0, 0, 0, 0.7);");

        // Create a default background
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #1a237e, #000000);");

        try {
            Image backgroundImage = new Image(getClass().getResourceAsStream("/com/example/demo/images/background1.jpg"));
            ImageView backgroundView = new ImageView(backgroundImage);
            backgroundView.setFitWidth(stage.getWidth());
            backgroundView.setFitHeight(stage.getHeight());
            layout.getChildren().add(backgroundView);
        } catch (Exception e) {
            System.out.println("Background image could not be loaded, using default background");
        }

        layout.getChildren().add(vbox);

        Scene scene = new Scene(layout, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    private void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
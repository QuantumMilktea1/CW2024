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

/**
 * The {@code StartScreen} class is responsible for displaying the initial screen of the application.
 * <p>
 * This class includes functionality to show the title, start game and exit buttons, and play
 * background music. It sets up the UI elements and handles button actions to transition to
 * the game or close the application.
 * </p>
 */
public class StartScreen {

    /**
     * The primary stage for displaying the start screen.
     */
    private final Stage stage;

    /**
     * The controller that manages the game logic and transitions.
     */
    private final Controller controller;

    /**
     * MediaPlayer instance for playing background music.
     */
    private MediaPlayer mediaPlayer;

    /**
     * Constructs a {@code StartScreen} with the specified stage and controller.
     *
     * @param stage      the primary stage for this application
     * @param controller the controller that manages game logic
     */
    public StartScreen(Stage stage, Controller controller) {
        this.stage = stage;
        this.controller = controller;
        initializeBackgroundMusic();
    }

    /**
     * Initializes and plays the background music for the start screen.
     * <p>
     * The music will loop indefinitely at 50% volume. If the audio file cannot be loaded,
     * an error message will be printed to the console.
     * </p>
     */
    private void initializeBackgroundMusic() {
        try {
            String musicFile = "/music/menubackgroundmusic.mp3"; // Ensure this file exists in the resources
            Media sound = new Media(getClass().getResource(musicFile).toExternalForm());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music
            mediaPlayer.setVolume(0.5); // Set volume to 50%
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Background music could not be loaded");
        }
    }

    /**
     * Displays the start screen with a title, "Start Game" button, and "Exit" button.
     * <p>
     * The start screen includes a title label styled for prominence, buttons styled for
     * interactivity, and a background image or default gradient if the image fails to load.
     * </p>
     */
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
                controller.launchGame(); // Transition to game logic
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
            Image backgroundImage = new Image(getClass().getResourceAsStream("/com/example/demo/images/StartScreen.jpg"));
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

    /**
     * Stops the background music if it is currently playing.
     */
    private void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}

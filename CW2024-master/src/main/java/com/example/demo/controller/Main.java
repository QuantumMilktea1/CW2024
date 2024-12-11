package com.example.demo.controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The Main class is the entry point for the Sky Battle game application.
 * It extends the JavaFX Application class and sets up the initial stage and screen.
 *
 * <p>The game window is configured with a fixed size and title. The main controller is initialized
 * and the start screen is shown when the application starts.</p>
 *
 * @author Yewenfeng
 */
public class Main extends Application {

	// Constants for screen width, height, and window title
	private static final int SCREEN_WIDTH = 1300;
	private static final int SCREEN_HEIGHT = 750;
	private static final String TITLE = "Sky Battle";
	private Controller myController;

	/**
	 * The start method is called when the application is launched.
	 * It sets up the stage, configures the window, and shows the start screen.
	 *
	 * @param stage the primary stage for this application, onto which the scene is set
	 */
	@Override
	public void start(Stage stage) {
		// Set window properties
		stage.setTitle(TITLE);
		stage.setResizable(false);
		stage.setHeight(SCREEN_HEIGHT);
		stage.setWidth(SCREEN_WIDTH);

		// Initialize the main controller
		myController = new Controller(stage);

		// Show the start screen
		StartScreen startScreen = new StartScreen(stage, myController);
		startScreen.show();
	}

	/**
	 * The main method is the entry point of the application.
	 * It launches the JavaFX application.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		launch();
	}
}

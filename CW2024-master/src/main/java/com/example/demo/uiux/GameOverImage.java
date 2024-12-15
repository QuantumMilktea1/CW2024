package com.example.demo.uiux;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents the "Game Over" image that appears when the player loses the game.
 * It is an extension of the ImageView class to display the image at a specific position.
 */
public class GameOverImage extends ImageView {

	// Path to the game over image
	private static final String IMAGE_NAME = "/com/example/demo/images/gameover.png";

	/**
	 * Constructor to initialize the GameOverImage.
	 * It sets the image and position of the Game Over image.
	 *
	 * @param xPosition The X-coordinate where the image should be placed.
	 * @param yPosition The Y-coordinate where the image should be placed.
	 */
	public GameOverImage(double xPosition, double yPosition) {
		// Load the image from resources
		setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
		// Set the layout position of the image on the screen
		setLayoutX(xPosition);
		setLayoutY(yPosition);
	}
}

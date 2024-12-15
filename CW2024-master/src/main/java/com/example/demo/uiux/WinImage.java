package com.example.demo.uiux;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The WinImage class represents the "You Win" image that is displayed when the player wins the game.
 * This image can be shown or hidden based on the game state.
 */
public class WinImage extends ImageView {

	// Path to the "You Win" image
	private static final String IMAGE_NAME = "/com/example/demo/images/youwin.png";

	// Fixed size for the win image
	private static final int HEIGHT = 500;
	private static final int WIDTH = 600;

	/**
	 * Constructor to initialize the WinImage at a specified position.
	 *
	 * @param xPosition The X-coordinate for the "You Win" image.
	 * @param yPosition The Y-coordinate for the "You Win" image.
	 */
	public WinImage(double xPosition, double yPosition) {
		// Set the image from resources
		this.setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));

		// Initially, the win image is hidden
		this.setVisible(false);

		// Set the size of the image
		this.setFitHeight(HEIGHT);
		this.setFitWidth(WIDTH);

		// Set the layout position
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
	}

	/**
	 * Makes the win image visible, indicating that the player has won.
	 */
	public void showWinImage() {
		this.setVisible(true);
	}
}

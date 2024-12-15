package com.example.demo.uiux;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

/**
 * This class represents the shield image that can be shown or hidden for an entity in the game.
 * The shield image is displayed when the entity's shield is active.
 */
public class ShieldImage extends ImageView {

	// Path to the shield image
	private static final String IMAGE_NAME = "/com/example/demo/images/shield.png";
	// Size of the shield image (both height and width)
	private static final int SHIELD_SIZE = 200;

	/**
	 * Constructor to initialize the ShieldImage with the given position.
	 *
	 * @param xPosition The X-coordinate for the shield image.
	 * @param yPosition The Y-coordinate for the shield image.
	 */
	public ShieldImage(double xPosition, double yPosition) {
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);

		// Load the shield image from resources and set it to the ImageView
		this.setImage(new Image(Objects.requireNonNull(getClass().getResource("/com/example/demo/images/shield.png")).toExternalForm()));

		// Initially hide the shield image
		this.setVisible(false);

		// Set the shield image's size
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	/**
	 * Makes the shield visible on the screen (when the shield is activated).
	 */
	public void showShield() {
		this.setVisible(true);
	}

	/**
	 * Hides the shield from the screen (when the shield is deactivated).
	 */
	public void hideShield() {
		this.setVisible(false);
	}
}

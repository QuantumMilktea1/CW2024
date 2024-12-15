package com.example.demo.Actor;

import javafx.scene.image.*;

/**
 * Abstract class representing an active actor in a graphical environment.
 * <p>
 * This class extends {@link ImageView} to represent an actor that has a
 * visual representation and can move horizontally or vertically.
 * Subclasses are expected to provide specific behavior for updating positions.
 * </p>
 *
 * <h2>Usage:</h2>
 * <ul>
 * <li>Set the image, initial position, and size of the actor through the constructor.</li>
 * <li>Override the {@link #updatePosition()} method to define the actor's movement logic.</li>
 * <li>Use {@link #moveHorizontally(double)} and {@link #moveVertically(double)} for movement.</li>
 * </ul>
 */
public abstract class ActiveActor extends ImageView {

	/**
	 * Base location of the images used for the actors.
	 */
	private static final String IMAGE_LOCATION = "/com/example/demo/images/";

	/**
	 * Constructs an instance of ActiveActor with the specified image, dimensions, and position.
	 *
	 * @param imageName the name of the image file, relative to {@link #IMAGE_LOCATION}.
	 * @param imageHeight the height to set for the actor's image.
	 * @param initialXPos the initial X-coordinate of the actor.
	 * @param initialYPos the initial Y-coordinate of the actor.
	 */
	public ActiveActor(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		// Load the image from resources and set the actor's visual appearance.
		this.setImage(new Image(getClass().getResource(IMAGE_LOCATION + imageName).toExternalForm()));
		this.setLayoutX(initialXPos);
		this.setLayoutY(initialYPos);
		this.setFitHeight(imageHeight);
		this.setPreserveRatio(true); // Preserve the aspect ratio of the image.
	}

	/**
	 * Abstract method for updating the position of the actor.
	 * <p>
	 * Subclasses must implement this method to define how the actor moves or updates its position.
	 * </p>
	 */
	public abstract void updatePosition();

	/**
	 * Moves the actor horizontally by a specified amount.
	 *
	 * @param horizontalMove the distance to move the actor along the X-axis.
	 *                       Positive values move the actor to the right,
	 *                       and negative values move it to the left.
	 */
	protected void moveHorizontally(double horizontalMove) {
		this.setTranslateX(getTranslateX() + horizontalMove);
	}

	/**
	 * Moves the actor vertically by a specified amount.
	 *
	 * @param verticalMove the distance to move the actor along the Y-axis.
	 *                     Positive values move the actor downward,
	 *                     and negative values move it upward.
	 */
	protected void moveVertically(double verticalMove) {
		this.setTranslateY(getTranslateY() + verticalMove);
	}
}

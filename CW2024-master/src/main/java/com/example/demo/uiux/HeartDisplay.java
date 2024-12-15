package com.example.demo.uiux;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * This class represents the heart display UI element, showing a series of hearts
 * to indicate the player's health in the game.
 */
public class HeartDisplay {

	// Path to the heart image
	private static final String HEART_IMAGE_NAME = "/com/example/demo/images/heart.png";
	// Height of each heart image
	private static final int HEART_HEIGHT = 50;
	// The index of the first item in the container to remove a heart
	private static final int INDEX_OF_FIRST_ITEM = 0;

	// HBox container for the hearts
	private HBox container;
	// X and Y positions for the container
	private double containerXPosition;
	private double containerYPosition;
	// The number of hearts to display initially
	private int numberOfHeartsToDisplay;

	/**
	 * Constructor to initialize the heart display.
	 *
	 * @param xPosition The X-coordinate for the heart display.
	 * @param yPosition The Y-coordinate for the heart display.
	 * @param heartsToDisplay The number of hearts to initially display.
	 */
	public HeartDisplay(double xPosition, double yPosition, int heartsToDisplay) {
		this.containerXPosition = xPosition;
		this.containerYPosition = yPosition;
		this.numberOfHeartsToDisplay = heartsToDisplay;
		initializeContainer();
		initializeHearts();
	}

	/**
	 * Initializes the container (HBox) that holds the heart images.
	 */
	private void initializeContainer() {
		container = new HBox();
		container.setLayoutX(containerXPosition);
		container.setLayoutY(containerYPosition);
	}

	/**
	 * Initializes the heart images and adds them to the container.
	 */
	private void initializeHearts() {
		for (int i = 0; i < numberOfHeartsToDisplay; i++) {
			ImageView heart = new ImageView(new Image(getClass().getResource(HEART_IMAGE_NAME).toExternalForm()));
			heart.setFitHeight(HEART_HEIGHT);
			heart.setPreserveRatio(true);
			container.getChildren().add(heart);
		}
	}

	/**
	 * Removes one heart from the container. This is called when the player takes damage.
	 */
	public void removeHeart() {
		if (!container.getChildren().isEmpty())
			container.getChildren().remove(INDEX_OF_FIRST_ITEM);
	}

	/**
	 * Gets the container (HBox) that holds the hearts.
	 *
	 * @return The HBox container holding the heart images.
	 */
	public HBox getContainer() {
		return container;
	}
}

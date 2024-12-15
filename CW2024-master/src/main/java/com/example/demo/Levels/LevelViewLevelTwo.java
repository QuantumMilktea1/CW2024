package com.example.demo.Levels;

import com.example.demo.uiux.ShieldImage;
import javafx.scene.Group;

/**
 * Represents the view for Level Two in the game.
 * In addition to the elements from the base LevelView, it includes a shield image specific to Level Two.
 */
public class LevelViewLevelTwo extends LevelView {

	private static final int SHIELD_X_POSITION = 1150;
	private static final int SHIELD_Y_POSITION = 500;
	private final Group root;
	private final ShieldImage shieldImage;

	/**
	 * Constructs a new LevelViewLevelTwo instance.
	 * Initializes the view with the specified heart display and adds the shield image to the root.
	 *
	 * @param root The root group of the scene, where UI elements will be added.
	 * @param heartsToDisplay The initial number of hearts to display on the screen.
	 */
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
		addImagesToRoot();
	}

	/**
	 * Adds the shield image to the root group.
	 */
	private void addImagesToRoot() {
		root.getChildren().addAll(shieldImage);
	}

}

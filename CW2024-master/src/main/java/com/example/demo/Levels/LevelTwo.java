package com.example.demo.Levels;

import com.example.demo.Plane.Boss;
import com.example.demo.controller.BackgroundMusic;
import com.example.demo.uiux.ShieldImage;

/**
 * Represents the second level of the game.
 * This level includes a boss enemy and utilizes a shield mechanic.
 */
public class LevelTwo extends LevelParent {

	private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
	private static final int PLAYER_INITIAL_HEALTH = 5;
	private final Boss boss;
	private LevelViewLevelTwo levelView;
	private ShieldImage shieldImage;

	/**
	 * Constructs a new LevelTwo instance.
	 *
	 * @param screenHeight The height of the game screen.
	 * @param screenWidth  The width of the game screen.
	 */
	public LevelTwo(double screenHeight, double screenWidth) {
		super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
		boss = new Boss();
		shieldImage = boss.getShieldImage();
		initializeMusic(BackgroundMusic.LEVEL_TWO_MUSIC);
	}

	/**
	 * Initializes the friendly units for Level Two, including the user's plane
	 * and the boss's shield image.
	 */
	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
		getRoot().getChildren().add(shieldImage);
	}

	/**
	 * Checks the game state to determine if the game is over.
	 * Ends the game if the user is destroyed or if the boss is defeated.
	 */
	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
		} else if (boss.isDestroyed()) {
			stopMusic();
			winGame();
		}
	}

	/**
	 * Spawns the boss enemy unit if no enemies are currently active.
	 */
	@Override
	protected void spawnEnemyUnits() {
		if (getCurrentNumberOfEnemies() == 0) {
			addEnemyUnit(boss);
		}
	}

	/**
	 * Instantiates the level view for Level Two.
	 *
	 * @return The LevelView instance specific to Level Two.
	 */
	@Override
	protected LevelView instantiateLevelView() {
		levelView = new LevelViewLevelTwo(getRoot(), PLAYER_INITIAL_HEALTH);
		return levelView;
	}
}

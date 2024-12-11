package com.example.demo.Levels;

import com.example.demo.Actor.ActiveActorDestructible;
import com.example.demo.Plane.EnemyPlane;
import com.example.demo.controller.BackgroundMusic;

/**
 * LevelOne class represents the first level of the game.
 * It manages the game state, enemy spawning, and transitions to the next level.
 */
public class LevelOne extends LevelParent {

	private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg";
	private static final String NEXT_LEVEL = "com.example.demo.Levels.LevelTwo";
	private static final int TOTAL_ENEMIES = 5;
	private static final int KILLS_TO_ADVANCE = 10;
	private static final double ENEMY_SPAWN_PROBABILITY = .20;
	private static final int PLAYER_INITIAL_HEALTH = 5;

	/**
	 * Constructs a LevelOne instance with specified screen dimensions.
	 *
	 * @param screenHeight the height of the screen
	 * @param screenWidth  the width of the screen
	 */
	public LevelOne(double screenHeight, double screenWidth) {
		super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
		initializeMusic(BackgroundMusic.LEVEL_ONE_MUSIC);
	}

	/**
	 * Checks if the game is over based on the user's status.
	 * If the user is destroyed, the game is lost.
	 * If the user has reached the kill target, the next level is initiated.
	 */
	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
		}
		else if (userHasReachedKillTarget()) {
			stopMusic();
			goToNextLevel(NEXT_LEVEL);
		}
	}

	/**
	 * Initializes friendly units by adding the user to the game root.
	 */
	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
	}

	/**
	 * Spawns enemy units based on the defined spawn probability.
	 * The number of enemies spawned is determined by the current count.
	 */
	@Override
	protected void spawnEnemyUnits() {
		int currentNumberOfEnemies = getCurrentNumberOfEnemies();
		for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
			if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
				double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
				ActiveActorDestructible newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
				addEnemyUnit(newEnemy);
			}
		}
	}

	/**
	 * Instantiates the level view for the current level.
	 *
	 * @return a new LevelView instance
	 */
	@Override
	protected LevelView instantiateLevelView() {
		return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
	}

	/**
	 * Checks if the user has reached the kill target to advance to the next level.
	 *
	 * @return true if the user has reached the kill target, false otherwise
	 */
	private boolean userHasReachedKillTarget() {
		return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
	}

}

package com.example.demo.Plane;

import com.example.demo.Actor.ActiveActorDestructible;
import com.example.demo.Projectiles.BossProjectile;
import com.example.demo.uiux.ShieldImage;

import java.util.*;

/**
 * Represents the boss plane in the game. This plane has unique behaviors such as moving in a specific pattern,
 * firing projectiles, and activating a shield at random intervals.
 */
public class Boss extends FighterPlane {

	private static final String IMAGE_NAME = "bossplane.png";
	private static final double INITIAL_X_POSITION = 1000.0;
	private static final double INITIAL_Y_POSITION = 400;
	private static final double PROJECTILE_Y_POSITION_OFFSET = 75.0;
	private static final double BOSS_FIRE_RATE = .04;
	private static final double BOSS_SHIELD_PROBABILITY = .02;
	private static final int IMAGE_HEIGHT = 300;
	private static final int VERTICAL_VELOCITY = 8;
	private static final int HEALTH = 5;
	private static final int MOVE_FREQUENCY_PER_CYCLE = 5;
	private static final int ZERO = 0;
	private static final int MAX_FRAMES_WITH_SAME_MOVE = 10;
	private static final int Y_POSITION_UPPER_BOUND = -100;
	private static final int Y_POSITION_LOWER_BOUND = 475;
	private static final int MAX_FRAMES_WITH_SHIELD = 20;
	private final List<Integer> movePattern;
	private boolean isShielded;
	private int consecutiveMovesInSameDirection;
	private int indexOfCurrentMove;
	private int framesWithShieldActivated;
	private final ShieldImage shieldImage;

	/**
	 * Constructs a new Boss instance with default attributes.
	 * Initializes the boss's movement pattern, shield image, and other behaviors.
	 */
	public Boss() {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, HEALTH);
		movePattern = new ArrayList<>();
		consecutiveMovesInSameDirection = 0;
		indexOfCurrentMove = 0;
		framesWithShieldActivated = 0;
		isShielded = false;
		initializeMovePattern();
		shieldImage = new ShieldImage(INITIAL_X_POSITION, INITIAL_Y_POSITION);
	}

	/**
	 * Updates the position of the boss plane.
	 * Moves the boss vertically based on the current movement pattern,
	 * and updates the shield image's position.
	 */
	@Override
	public void updatePosition() {
		double initialTranslateY = getTranslateY();
		moveVertically(getNextMove());
		double currentPosition = getLayoutY() + getTranslateY();

		shieldImage.setLayoutX(getLayoutX());
		shieldImage.setLayoutY(currentPosition);

		if (currentPosition < Y_POSITION_UPPER_BOUND || currentPosition > Y_POSITION_LOWER_BOUND) {
			setTranslateY(initialTranslateY);
		}
	}

	/**
	 * Updates the boss plane and its shield.
	 * Calls the updatePosition method and manages shield activation/deactivation.
	 */
	@Override
	public void updateActor() {
		updatePosition();
		updateShield();
	}

	/**
	 * Fires a projectile from the boss plane with a certain probability.
	 *
	 * @return A new BossProjectile if the boss fires, or null if no projectile is fired.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return bossFiresInCurrentFrame() ? new BossProjectile(getProjectileInitialPosition()) : null;
	}

	/**
	 * Handles taking damage. The boss can only take damage if it is not shielded.
	 */
	@Override
	public void takeDamage() {
		if (!isShielded) {
			super.takeDamage();
		}
	}

	/**
	 * Initializes the boss's movement pattern.
	 * The pattern consists of alternating vertical movements.
	 */
	private void initializeMovePattern() {
		for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
			movePattern.add(VERTICAL_VELOCITY);
			movePattern.add(-VERTICAL_VELOCITY);
			movePattern.add(ZERO);
		}
		Collections.shuffle(movePattern);
	}

	/**
	 * Updates the boss's shield. If the shield is active, it counts the frames until it is exhausted.
	 * If the shield should be activated, it is done randomly based on the defined probability.
	 */
	private void updateShield() {
		if (isShielded) framesWithShieldActivated++;
		else if (shieldShouldBeActivated()) {
			activateShield();
			shieldImage.showShield();
		}
		if (shieldExhausted()) {
			deactivateShield();
			shieldImage.hideShield();
		}
	}

	/**
	 * Returns the next vertical movement for the boss plane based on its move pattern.
	 * Moves are selected randomly from the pattern.
	 *
	 * @return The next vertical movement direction for the boss.
	 */
	private int getNextMove() {
		int currentMove = movePattern.get(indexOfCurrentMove);
		consecutiveMovesInSameDirection++;
		if (consecutiveMovesInSameDirection == MAX_FRAMES_WITH_SAME_MOVE) {
			Collections.shuffle(movePattern);
			consecutiveMovesInSameDirection = 0;
			indexOfCurrentMove++;
		}
		if (indexOfCurrentMove == movePattern.size()) {
			indexOfCurrentMove = 0;
		}
		return currentMove;
	}

	/**
	 * Determines if the boss fires a projectile in the current frame based on its fire rate.
	 *
	 * @return True if the boss fires a projectile, otherwise false.
	 */
	private boolean bossFiresInCurrentFrame() {
		return Math.random() < BOSS_FIRE_RATE;
	}

	/**
	 * Returns the initial Y position for the projectile fired by the boss.
	 *
	 * @return The Y position where the projectile will be fired.
	 */
	private double getProjectileInitialPosition() {
		return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
	}

	/**
	 * Determines if the shield should be activated based on a random probability.
	 *
	 * @return True if the shield should be activated, otherwise false.
	 */
	private boolean shieldShouldBeActivated() {
		return Math.random() < BOSS_SHIELD_PROBABILITY;
	}

	/**
	 * Checks if the shield has been active for the maximum number of frames.
	 *
	 * @return True if the shield has been exhausted, otherwise false.
	 */
	private boolean shieldExhausted() {
		return framesWithShieldActivated == MAX_FRAMES_WITH_SHIELD;
	}

	/**
	 * Activates the boss's shield.
	 */
	private void activateShield() {
		isShielded = true;
	}

	/**
	 * Deactivates the boss's shield and resets the frame counter.
	 */
	private void deactivateShield() {
		isShielded = false;
		framesWithShieldActivated = 0;
	}

	/**
	 * Returns the shield image associated with the boss.
	 *
	 * @return The shield image.
	 */
	public ShieldImage getShieldImage(){
		return shieldImage;
	}

}

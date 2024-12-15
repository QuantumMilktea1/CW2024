package com.example.demo.Plane;

import com.example.demo.Actor.ActiveActorDestructible;
import com.example.demo.Projectiles.UserProjectile;

/**
 * Represents the user's plane in the game, which can move vertically and fire projectiles.
 * The user plane can be controlled by the player to move up or down, and it tracks the number of kills.
 */
public class UserPlane extends FighterPlane {

	private static final String IMAGE_NAME = "userplane.png";
	private static final double Y_UPPER_BOUND = -40;
	private static final double Y_LOWER_BOUND = 600.0;
	private static final double INITIAL_X_POSITION = 5.0;
	private static final double INITIAL_Y_POSITION = 300.0;
	private static final int IMAGE_HEIGHT = 150;
	private static final int VERTICAL_VELOCITY = 8;
	private static final int PROJECTILE_X_POSITION = 110;
	private static final int PROJECTILE_Y_POSITION_OFFSET = 20;

	private double velocityMultiplier;
	private int numberOfKills;

	/**
	 * Constructs a UserPlane with the specified initial health.
	 *
	 * @param initialHealth The initial health of the user plane.
	 */
	public UserPlane(int initialHealth) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, initialHealth);
		this.velocityMultiplier = 0;
		this.numberOfKills = 0;
	}

	/**
	 * Updates the position of the user plane. The plane can move vertically within the defined bounds.
	 * If the plane reaches the upper or lower bounds, its vertical position is reset to the previous valid position.
	 */
	@Override
	public void updatePosition() {
		if (isMoving()) {
			double initialTranslateY = getTranslateY();
			this.moveVertically(VERTICAL_VELOCITY * velocityMultiplier);
			double newPosition = getLayoutY() + getTranslateY();
			if (newPosition < Y_UPPER_BOUND || newPosition > Y_LOWER_BOUND) {
				this.setTranslateY(initialTranslateY);
			}
		}
	}

	/**
	 * Updates the user plane actor. This is called to apply any changes, such as movement.
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}

	/**
	 * Fires a projectile from the user plane. The projectile is created at a fixed horizontal position
	 * and a vertical position offset from the plane.
	 *
	 * @return A new `UserProjectile` object representing the fired projectile.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return new UserProjectile(PROJECTILE_X_POSITION, getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
	}

	/**
	 * Determines if the plane is moving based on its velocity multiplier.
	 *
	 * @return true if the plane is moving, false if the plane is stationary.
	 */
	private boolean isMoving() {
		return velocityMultiplier != 0;
	}

	/**
	 * Moves the user plane up by setting the velocity multiplier to a negative value.
	 */
	public void moveUp() {
		velocityMultiplier = -1.5;
	}

	/**
	 * Moves the user plane down by setting the velocity multiplier to a positive value.
	 */
	public void moveDown() {
		velocityMultiplier = 1.5;
	}

	/**
	 * Stops the user plane by setting the velocity multiplier to zero.
	 */
	public void stop() {
		velocityMultiplier = 0;
	}

	/**
	 * Gets the current number of kills made by the user plane.
	 *
	 * @return The number of kills made by the user plane.
	 */
	public int getNumberOfKills() {
		return numberOfKills;
	}

	/**
	 * Increments the kill count by one. This is called when the user plane destroys an enemy.
	 */
	public void incrementKillCount() {
		numberOfKills++;
	}

}

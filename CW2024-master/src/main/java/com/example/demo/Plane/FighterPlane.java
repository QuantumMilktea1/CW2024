package com.example.demo.Plane;

import com.example.demo.Actor.ActiveActorDestructible;

/**
 * An abstract class representing a fighter plane in the game.
 * A fighter plane has health, can take damage, and can fire projectiles.
 */
public abstract class FighterPlane extends ActiveActorDestructible {

	private int health;

	/**
	 * Constructs a new FighterPlane instance with the given image, position, and health.
	 *
	 * @param imageName The image representing the fighter plane.
	 * @param imageHeight The height of the image representing the fighter plane.
	 * @param initialXPos The initial X position of the fighter plane.
	 * @param initialYPos The initial Y position of the fighter plane.
	 * @param health The initial health of the fighter plane.
	 */
	public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		this.health = health;
	}

	/**
	 * Fires a projectile from the fighter plane. This method should be implemented by subclasses.
	 *
	 * @return An ActiveActorDestructible representing the fired projectile, or null if no projectile is fired.
	 */
	public abstract ActiveActorDestructible fireProjectile();

	/**
	 * Reduces the fighter plane's health by 1. If the health reaches zero, the plane is destroyed.
	 */
	@Override
	public void takeDamage() {
		health--;
		if (healthAtZero()) {
			this.destroy();
		}
	}

	/**
	 * Calculates the X position of the projectile based on the plane's current position and a specified offset.
	 *
	 * @param xPositionOffset The offset to be added to the plane's X position for the projectile.
	 * @return The calculated X position for the projectile.
	 */
	protected double getProjectileXPosition(double xPositionOffset) {
		return getLayoutX() + getTranslateX() + xPositionOffset;
	}

	/**
	 * Calculates the Y position of the projectile based on the plane's current position and a specified offset.
	 *
	 * @param yPositionOffset The offset to be added to the plane's Y position for the projectile.
	 * @return The calculated Y position for the projectile.
	 */
	protected double getProjectileYPosition(double yPositionOffset) {
		return getLayoutY() + getTranslateY() + yPositionOffset;
	}

	/**
	 * Checks if the fighter plane's health has reached zero.
	 *
	 * @return true if health is zero, false otherwise.
	 */
	private boolean healthAtZero() {
		return health == 0;
	}

	/**
	 * Gets the current health of the fighter plane.
	 *
	 * @return The health of the fighter plane.
	 */
	public int getHealth() {
		return health;
	}

}

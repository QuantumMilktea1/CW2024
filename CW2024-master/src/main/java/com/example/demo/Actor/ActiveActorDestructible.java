package com.example.demo.Actor;

/**
 * Abstract class representing an active actor that can be destroyed.
 * <p>
 * This class extends {@link ActiveActor} and implements the {@link Destructible} interface,
 * allowing the actor to take damage and be destroyed. It introduces a lifecycle where an actor
 * can exist, take damage, and eventually be marked as destroyed.
 * </p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 * <li>Tracks whether the actor is destroyed.</li>
 * <li>Provides methods to update position, handle destruction, and react to damage.</li>
 * <li>Designed to be extended by subclasses that define specific behavior.</li>
 * </ul>
 */
public abstract class ActiveActorDestructible extends ActiveActor implements Destructible {

	/**
	 * Tracks whether the actor has been destroyed.
	 */
	private boolean isDestroyed;

	/**
	 * Constructs an instance of {@code ActiveActorDestructible} with the specified image, dimensions, and position.
	 *
	 * @param imageName the name of the image file, relative to the image location path.
	 * @param imageHeight the height of the actor's image.
	 * @param initialXPos the initial X-coordinate of the actor.
	 * @param initialYPos the initial Y-coordinate of the actor.
	 */
	public ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		isDestroyed = false; // Initialize the actor as not destroyed.
	}

	/**
	 * Updates the position of the actor.
	 * <p>
	 * This method must be implemented by subclasses to define how the actor moves.
	 * </p>
	 */
	@Override
	public abstract void updatePosition();

	/**
	 * Updates the state of the actor.
	 * <p>
	 * Subclasses should implement this method to handle changes in the actor's state,
	 * such as reacting to interactions or environmental factors.
	 * </p>
	 */
	public abstract void updateActor();

	/**
	 * Applies damage to the actor.
	 * <p>
	 * This method must be implemented by subclasses to define how the actor reacts to damage
	 * (e.g., reducing health, changing state).
	 * </p>
	 */
	@Override
	public abstract void takeDamage();

	/**
	 * Marks the actor as destroyed.
	 * <p>
	 * When this method is called, the actor is considered no longer active.
	 * Subclasses can override this behavior if additional cleanup is required.
	 * </p>
	 */
	@Override
	public void destroy() {
		setDestroyed(true);
	}

	/**
	 * Sets the destruction state of the actor.
	 *
	 * @param isDestroyed {@code true} to mark the actor as destroyed, {@code false} otherwise.
	 */
	protected void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	/**
	 * Checks whether the actor is destroyed.
	 *
	 * @return {@code true} if the actor is destroyed, {@code false} otherwise.
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}
}

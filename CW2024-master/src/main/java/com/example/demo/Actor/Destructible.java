package com.example.demo.Actor;

/**
 * Interface representing objects that can take damage and be destroyed.
 * <p>
 * Classes implementing this interface should define specific behavior for handling damage
 * and destruction, allowing for flexibility in the implementation of destructible entities.
 * </p>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 * <li>Provide a mechanism to apply damage to the object.</li>
 * <li>Define the behavior when the object is destroyed.</li>
 * </ul>
 *
 * <h2>Intended Usage:</h2>
 * <p>
 * Implement this interface in classes that require destruction functionality, such as game actors
 * or environmental objects. The implementing class must define the effects of taking damage
 * and the consequences of destruction.
 * </p>
 */
public interface Destructible {

	/**
	 * Applies damage to the object.
	 * <p>
	 * This method should define the behavior of the object when damage is taken,
	 * such as reducing health or triggering visual/audio effects.
	 * </p>
	 */
	void takeDamage();

	/**
	 * Destroys the object.
	 * <p>
	 * This method should define the behavior when the object is destroyed,
	 * such as removing it from the game environment or playing destruction animations.
	 * </p>
	 */
	void destroy();
}

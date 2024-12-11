package com.example.demo.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.Levels.LevelParent;

/**
 * The Controller class manages the game flow and interactions between the view and the model.
 * It implements the Observer interface to respond to changes in the game state.
 */
public class Controller implements Observer {

	private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.Levels.LevelOne";
	private final Stage stage;

	/**
	 * Constructs a Controller with the specified stage.
	 *
	 * @param stage the primary stage for this application
	 */
	public Controller(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Launches the game by showing the stage and navigating to the first level.
	 *
	 * @throws ClassNotFoundException if the level class cannot be found
	 * @throws NoSuchMethodException if the constructor for the level class cannot be found
	 * @throws SecurityException if a security manager prevents access
	 * @throws InstantiationException if the class that declares the underlying constructor
	 *         represents an abstract class
	 * @throws IllegalAccessException if the constructor is inaccessible
	 * @throws IllegalArgumentException if the constructor is invoked with the wrong arguments
	 * @throws InvocationTargetException if the underlying constructor throws an exception
	 */
	public void launchGame() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {

		stage.show();
		
		goToLevel(LEVEL_ONE_CLASS_NAME);
	}

	/**
	 * Navigates to the specified level by class name.
	 *
	 * @param className the fully qualified name of the level class
	 * @throws ClassNotFoundException if the class cannot be found
	 * @throws NoSuchMethodException if the constructor for the level class cannot be found
	 * @throws SecurityException if a security manager prevents access
	 * @throws InstantiationException if the class that declares the underlying constructor
	 *         represents an abstract class
	 * @throws IllegalAccessException if the constructor is inaccessible
	 * @throws IllegalArgumentException if the constructor is invoked with the wrong arguments
	 * @throws InvocationTargetException if the underlying constructor throws an exception
	 */
	private void goToLevel(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> myClass = Class.forName(className);
		Constructor<?> constructor = myClass.getConstructor(double.class, double.class);
		LevelParent myLevel = (LevelParent) constructor.newInstance(stage.getHeight(), stage.getWidth());
		myLevel.addObserver(this);
		Scene scene = myLevel.initializeScene();
		stage.setScene(scene);
		myLevel.startGame();

	}

	/**
	 * Updates the controller when the observed object changes.
	 *
	 * @param arg0 the observable object
	 * @param arg1 the argument passed to the update method
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			goToLevel((String) arg1);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getClass().toString());
			alert.show();
		}
	}

}

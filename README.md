# COMP2042 Developing Maintainable Software

## 1.0 My GitHub
- **Name**: Ye Wenfeng
- **Student ID**: 20496457
- **Repository Link**: [GitHub Repository](https://github.com/QuantumMilktea1/CW2024)
---

## 2.0 Setup and Compilation Instructions

### 2.1 Prerequisites
- **Java Development Kit (JDK)**: Version 21 or higher
- **Apache Maven**: Version 3.8.0 or higher
- **JavaFX SDK**: Version 21.0.5
- **Git**: Installed and configured

### Recommended IDEs
- **IntelliJ IDEA**: Version 2023.3 or higher
- **Eclipse**: Version 2023-12 or higher
- **VS Code**: With Java Extension Pack and JavaFX Extension installed

---

## Environment Setup

### **1. Install Java Development Kit (JDK)**
1. Download JDK 21 from [Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or [OpenJDK](https://openjdk.org/).
2. Set up the `JAVA_HOME` environment variable:
    - **Windows**:
      ```powershell
      [Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-21", "Machine")
      [Environment]::SetEnvironmentVariable("Path", $env:Path + ";%JAVA_HOME%\bin", "Machine")
      ```
    - **Unix/MacOS**:
      ```bash
      echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home' >> ~/.bash_profile
      echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bash_profile
      source ~/.bash_profile
      ```
3. Verify installation:
   ```bash
   java --version


## **2. Install JavaFX SDK**
1. Download JavaFX SDK 21 from [OpenJFX](https://openjfx.io/).
2. Extract it to a preferred location.
3. Optionally, add it to your PATH (although Maven will handle dependencies automatically):
    - **Windows**:
      ```powershell
      [Environment]::SetEnvironmentVariable("PATH_TO_FX", "C:\Path\To\javafx-sdk-21\lib", "Machine")
      ```
    - **Unix/MacOS**:
      ```bash
      echo 'export PATH_TO_FX=/path/to/javafx-sdk-21/lib' >> ~/.bash_profile
      source ~/.bash_profile
      ```

---

## **3. Install Git**
1. Install Git for your operating system:
    - **Windows**: Download and install from [Git for Windows](https://git-scm.com/).
    - **macOS**: Install via Homebrew:
      ```bash
      brew install git
      ```
    - **Linux (Ubuntu/Debian)**:
      ```bash
      sudo apt-get install git
      ```
    - **Linux (Fedora)**:
      ```bash
      sudo dnf install git
      ```

2. Verify Git installation:
   ```bash
   git --version


## **4. Install Apache Maven**
1. Download Apache Maven from the [Maven Official Site](https://maven.apache.org/download.cgi).
2. Add Maven to your system PATH:
    - **Windows**:
      ```powershell
      [Environment]::SetEnvironmentVariable("Path", $env:Path + ";C:\Path\To\Maven\bin", "Machine")
      ```
    - **Unix/MacOS**:
      ```bash
      echo 'export PATH=/path/to/maven/bin:$PATH' >> ~/.bash_profile
      source ~/.bash_profile
      ```

---

### Verify Maven Installation
- To confirm Maven is installed correctly, run the following command:
    ```bash
    mvn --version


# Project Setup Guide

Follow the steps below to set up and run the project on your local environment.

---

## **2.2 Project Setup**

### Clone the Repository
1. Clone the project repository:
   ```bash
   git clone https://github.com/QuantumMilktea1/CW2024/blob/master/git
   cd CW2024

## **IDE Setup**

### **Eclipse**
1. Open Eclipse and import the project as a Maven project:
    - Go to **File** → **Import** → **Existing Maven Projects**.
    - Select the project folder and click **Finish**.
2. Configure the Java Build Path if necessary:
    - Right-click the project in the Project Explorer → **Properties** → **Java Build Path**.
    - Add JavaFX libraries if they are missing:
        - Go to the **Libraries** tab.
        - Click **Add External JARs...** and select the JavaFX JAR files from your JavaFX SDK.

---

### **IntelliJ IDEA**
1. Open IntelliJ IDEA and import the project as a Maven project:
    - Select **Open** from the IntelliJ start screen and choose the project folder.
    - IntelliJ will detect the `pom.xml` and set up the Maven configuration.
2. Verify the Project SDK:
    - Go to **File** → **Project Structure** → **Project Settings** → **Project SDK**.
    - Ensure the SDK is set to JDK 21.
3. Refresh Maven dependencies:
    - Open the Maven tool window (usually on the right-hand side).
    - Click **Reload All Maven Projects** to load all dependencies.
4. Wait for Maven to sync and ensure there are no errors in the dependencies.

---

4. Alternatively, set up a launch configuration to run the project directly:
    - Go to the **Run and Debug** panel → **Create a Launch Configuration** → Configure it for Maven.

---

## **Compile and Run the Application**

### **Compile the Project**
- Clean and compile the project using Maven:
    ```bash
    mvn clean compile
    ```
- Run the application:
    ```bash
    mvn javafx:run
    ```
- Package the application:
    ```bash
    mvn package
    ```

# Common Build Commands

Use the following Maven commands to build, test, package, and run the project.

---
**1. Clean Build Files**
- Removes all previously generated build files:
    ```bash
    mvn clean
    ```

**2. Compile the Project**
- Compiles the source code of the project:
    ```bash
    mvn compile
    ```

**3. Run Tests**
- Executes all test cases in the project:
    ```bash
    mvn test
    ```

**4. Package the Application**
- Packages the application into a JAR file:
    ```bash
    mvn package
    ```

**5. Install to Local Repository**
- Installs the application into the local Maven repository:
    ```bash
    mvn install
    ```

**6. Run the Application**
- Runs the application using the Maven JavaFX plugin:
    ```bash
    mvn javafx:run
    ```

## 3.0 Features

### 3.1 Implemented and Working Properly
1. **User Plane Movement**: Added up and down movement controls for the user plane.
    - **Classes Involved**:
        - `UserPlane` (actor)
        - `InputManager` (manager)
    - **Key Methods**:
        - `UserPlane.stopHorizontalMovement()`
        - `InputManager.createKeyPressedHandler()`
        - `InputManager.createKeyReleasedHandler()`

2. **StartScreen**: Implemented a visually styled startup screen with background music and game initialization logic.
    - **Classes Involved**:
        - `StartScreen` (UI logicUI logic)
        - `Controller`  (game logic)
    - **Key Methods**:
        - `StartScreen.initializeBackgroundMusic()`
        - `StartScreen.show()`
        - `StartScreen.stopBackgroundMusic()`
        - `Controller.launchGame()`
        - `Stage.close()`

3. **BackgroundMusic**: Implemented a reusable class for managing background music in the application.
    - **Classes Involved**:
        - `BackgroundMusic` (music management)
        - `PauseManager` (manager)
    - **Key Methods**:
        - `BackgroundMusic.play()`
        - `BackgroundMusic.stop()`

4. **ShieldImage**: Fix a custom ImageView subclass for rendering shield graphics in-game.
    - **Classes Involved**:
        - `ShieldImage`  (custom UI component for shield visualization).
        - `KillCountDisplay` (levelview)
    - **Key Methods**:
        - `ShieldImage(double xPosition, double yPosition)`
        - `ShieldImage.showShield()`
        - `ShieldImage.hideShield()`

5. **Visual and Audio Enhancements**: Changed background images and incorporated sound effects and background music.
    - **Classes Involved**:
        - `SoundManager` (manager)
        - `GameOverImage`, `WinImage`, `HeartDisplay`, `ShieldImage` (ui)
    - **Key Methods**:
        - `SoundManager.playSoundEffect()`
        - `SoundManager.playBackgroundMusic()`
        - `SoundManager.setBackgroundMusicVolume()`

6. **Additional Level**: Added an extra level to increase game complexity.
    - **Classes Involved**:
        - `BossLevel` (level)
        - `LevelTwo` (level)
        - `LevelParent` (level)
    - **Key Methods**:
        - `BossLevel.initializeScene()`
        - `updatePosition()`
        - `initializeMovePattern()`
        - `getNextMove()`

### 3.2 Implemented but Not Working Properly
1. **Boss Projectile Misalignment**: The projectiles fired by the boss occasionally appear offset from the intended firing position, leading to a mismatch between the visual effect and gameplay mechanics.
2. **Shield Overactivation**: The shield activation is too frequent due to the randomized probability, making the boss overly difficult to defeat.
3. **Music Overlap Issue**: Background music for Level Two occasionally overlaps with music from the previous level, causing a jarring auditory experience.
   - **Solution**:Added a stopMusic() call in the transition logic between levels to ensure proper handling of background music.
   
### 3.3 Not Implemented
1. **Tutorial Section**: A tutorial to teach beginners how to play the game.
2. **In-Game Power-Ups**: Implementation of power-ups that provide temporary advantages during gameplay.
3. **Final Score Display**: Displaying the user's  score on the game over

### 3.4 How to Fix Identified Issues

1. **Pause Menu Glitch**
    - **Validate Game State**: Ensure the game cannot resume if it's already in a game-over state.
    - **Manage Timelines**: Stop all active game timelines when the game ends to prevent unintended movements.
    - **Cleanup Pause Menu**: Disable or hide the pause menu upon triggering the game-over state to prevent further interactions.

2. **Unlimited Projectiles**
    - **Cooldown Timer**: Add a cooldown period between successive projectile firings to control the rate of fire.
    - **Ammo System**: Implement an ammo counter that decreases with each shot and requires reloading after depletion.
    - **UI Integration**: Display the current ammo count and cooldown status to inform players about their firing capabilities.

### 3.5 How to Add Missing Features

1. **Boss Projectile Mechanics**
    - **Refactor `BossProjectile` Class**: Adjust initial positioning logic to align projectiles consistently with the boss's firing point.
    - **Test and Debug**: Verify projectile trajectory in various boss movement states to ensure accuracy across all scenarios.
    - **Add Projectile Variations**: Introduce different projectile types (e.g., spread shot or homing missiles) for more engaging gameplay.

2. **Background Music Transition**
    - **Implement Music Transition Logic**:Ensure BackgroundMusic.stopMusic() is called before starting new level music to prevent overlapping.
    - **Add Fade-Out Effect**: Use JavaFX audio controls to fade out the previous music track before initiating the next one for smoother transitions.
    - **Test Across Levels**: Verify that the background music transitions correctly under different game progression paths.
---

## 4.0 Refactoring Process

### 4.1 New Java Classes

# StartScreen

| **Class Name**                | **Description**                                                                                                                                                                                                                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| StartScreen | This class is responsible for displaying the initial screen of the application, including a game title and interactive buttons to either start the game or exit the application. It also manages background music and provides a default or custom background image for the screen. | | Key Methods: | - initializeBackgroundMusic(): Initializes the background music for the application by loading the music file and setting up the MediaPlayer. The music is set to loop indefinitely at 50% volume, creating a consistent background atmosphere. If the music file can't be loaded, an error message is displayed. <br> - show(): Displays the start screen on the main application window. This method creates a title label, a "Start Game" button, and an "Exit" button. It arranges these UI elements in a VBox and sets up the stage with a background image (if available). Button actions are configured to stop the background music and either launch the game or exit the application. <br> - stopBackgroundMusic(): Stops the background music from playing if it’s currently active. This ensures that when the application is exited or the game is started, the music stops gracefully. |

# BackgroundMusic

| **Class Name**      | **Description**                                                                                                                                                                                                                                                                                                                                                                    |
|---------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BackgroundMusic | This class is responsible for managing background music playback within the application. It initializes a MediaPlayer object with a specified music file and provides methods to play, stop, and adjust the volume of the music. The class is designed to handle different music tracks for different game levels, providing an easy way to switch between them. | | Key Methods: | - BackgroundMusic(String musicFilePath): Constructor that initializes the MediaPlayer with a specified music file. The music file path is passed as an argument, and the player is set to loop the music indefinitely at 50% volume. If the music file cannot be loaded, an error message is printed. <br> - play(): Plays the background music if the MediaPlayer is initialized. <br> - stop(): Stops the background music if the MediaPlayer is initialized. <br> - setVolume(double volume): Adjusts the volume of the background music, where volume is a value between 0.0 (mute) and 1.0 (maximum volume). |                                                                                                                                          

# levelview

| **Class Name**         | **Description**                                                                                                                                                                                    | **Key Methods**                                                                                                                                                                                                                                                                                                                                                                                     |
|------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| LevelView | This class manages the visual elements of a level, including the heart display, win image, and game over screen. It interacts with the Group container to add, update, and remove visual components based on the game’s state. The class provides methods to show or remove hearts, display a win screen, and show the game over image. | | Key Methods: | - LevelView(Group root, int heartsToDisplay): Constructor that initializes the level view with a given Group container and the number of hearts to display. It also initializes the WinImage, GameOverImage, and HeartDisplay objects. <br> - showHeartDisplay(): Displays the heart icons on the screen by adding them to the root container. <br> - showWinImage(): Displays the win image on the screen and shows the win animation. <br> - showGameOverImage(): Displays the game over image on the screen. <br> - removeHearts(int heartsRemaining): Removes heart icons from the display based on the remaining number of hearts. It calculates how many hearts need to be removed and removes them from the HeartDisplay object. |

# ShieldImage

| **Class Name**           | **Description**                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ShieldImage | This class is responsible for managing the shield image in the game. It extends the ImageView class to display an image representing a shield. The class allows for controlling the visibility of the shield and positioning it on the screen. | | Key Methods: | - ShieldImage(double xPosition, double yPosition): Constructor that initializes the shield image at a specified position (xPosition, yPosition) on the screen. It loads the shield image and sets its size to a fixed value (SHIELD_SIZE), and initially hides it. <br> - showShield(): Makes the shield image visible on the screen. <br> - hideShield(): Hides the shield image from the screen. |
### 4.2 Modified Java Classes

- Actor

| **Class Name**            | **Description**                                                                                                                                                  | **Changes**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|---------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ActiveActorDestructible | This abstract class represents an active actor in the game that is destructible. It extends the ActiveActor class and implements the Destructible interface. This class provides the functionality to track the destruction state of the actor and manage the actor's health (taking damage and being destroyed). The actor’s position and other actor-specific actions are updated through abstract methods that must be implemented by subclasses. | | Key Methods: | - ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos): Constructor that initializes the actor with an image, height, and initial position. It also sets the initial destruction state (isDestroyed) to false. <br> - updatePosition(): Abstract method for updating the position of the actor, which must be implemented by subclasses. <br> - updateActor(): Abstract method for updating the actor’s state (e.g., movement or other behavior), which must also be implemented by subclasses. <br> - takeDamage(): Abstract method for handling damage taken by the actor, which must be implemented by subclasses to define the behavior when the actor takes damage. <br> - destroy(): Marks the actor as destroyed by setting the isDestroyed flag to true. <br> - setDestroyed(boolean isDestroyed): A protected method that sets the destruction state of the actor. <br> - isDestroyed(): Returns whether the actor is destroyed (true) or not (false). |                                                                                                                                                                    | 2. 
- controller

| **Class Name** | **Description**                                                                                                                 | **Changes**                                                                                                                                                                                                                                    |
|----------------|---------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Controller | This class is responsible for managing the flow of the game and handling interactions between the view (UI) and the model (game logic). It implements the Observer interface to respond to changes in the game state, such as when a new level is triggered. It is responsible for launching the game, navigating between levels, and handling level transitions. The controller interacts with the Stage to manage the scene and communicates with LevelParent objects to initialize and start levels. | | Key Methods: | - Controller(Stage stage): Constructor that initializes the Controller with the specified stage. The stage represents the main window of the game. <br> - launchGame(): This method shows the primary stage and starts the game by navigating to the first level (LevelOne). It uses reflection to dynamically load and instantiate the specified level class. <br> - goToLevel(String className): This method navigates to the level specified by the fully qualified class name. It uses reflection to load the level class, instantiate it with the stage's width and height, and set up the scene. It also starts the game for that level. <br> - update(Observable arg0, Object arg1): This method is called when the observed object (a LevelParent instance) changes its state. It handles level transitions by invoking the goToLevel method with the new level class name provided. If any errors occur during the level transition, an error alert is displayed. |

- level

| **Class Name** | **Description**                                                                                                                                                                    | **Changes**                                                                                                                                                                                                                                                                                                                                                                                  |
|----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| LevelParent | This abstract class manages the gameplay mechanics, such as actors (planes and projectiles), game state, and level transitions. It controls the game loop via the Timeline and handles various game actions, including player input, enemy spawning, projectile firing, collision detection, and game over/level win conditions. The class also manages the display of the background, level-specific visuals (e.g., hearts), and music. Specific level behavior is customized through abstract methods implemented in subclasses. | | Key Fields: | - screenHeight and screenWidth: Dimensions of the game screen. <br> - enemyMaximumYPosition: The maximum Y position where enemy units can spawn. <br> - root: A Group used to contain all visible game elements. <br> - timeline: A Timeline for the game loop, which updates the game state at regular intervals. <br> - user: The UserPlane object representing the player's plane. <br> - friendlyUnits and enemyUnits: Lists of active destructible actors (friendly and enemy units). <br> - userProjectiles and enemyProjectiles: Lists of projectiles fired by the player and enemies. <br> - currentNumberOfEnemies: The number of active enemies. <br> - levelView: An instance of LevelView for displaying level-specific UI elements like hearts. <br> - backgroundMusic: An instance of BackgroundMusic for managing background music. | | Key Methods: | - initializeScene(): Initializes the scene, background, and friendly units for the level. <br> - startGame(): Starts the game loop and plays the background music. <br> - goToNextLevel(String levelName): Ends the current game and notifies observers (e.g., controller) to transition to the next level. <br> - updateScene(): Updates the game state each frame, including spawning enemies, checking collisions, and removing destroyed actors. <br> - initializeBackground(): Initializes the background and sets up player input handling (e.g., movement, projectile firing). <br> - handleCollisions(): Detects and handles collisions between actors (e.g., planes and projectiles). <br> - winGame() and loseGame(): Stop the game and display the win or loss screen. <br> - endGame(): Stops the game, clears the scene, and removes all actors. <br> - initializeMusic(String musicPath): Initializes and plays background music. | | Abstract Methods: | - initializeFriendlyUnits(): Abstract method to initialize friendly units (e.g., the player's plane). <br> - checkIfGameOver(): Abstract method to check if the game is over (e.g., if the player’s health reaches zero). <br> - spawnEnemyUnits(): Abstract method to spawn enemy units in the level. <br> - instantiateLevelView(): Abstract method to instantiate and return a LevelView object, which handles level-specific UI elements like heart displays. |

- levelview

| **Class Name** | **Description**                                                                                                                                        | **Changes**                                                                                                                                                                                                                                                              |
|----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `LevelView`    | Represents the UI components and visual feedback for a game level, including heart displays, win/loss screens, and optional elements like boss health. | 1. **Shield Integration**: Added `ShieldImage` with `showShield` and `hideShield` methods to display and manage a shield icon for boss.<br>2. **Boss Health Display**: Added `Text` and `Pane` components to display and dynamically update the boss's health.           |
|                |                                                                                                                                                        | 3. **Kill Count Integration**: Introduced `killCountText` for tracking and displaying kill counts. Added methods `showKillCountDisplay` and `updateKillCountDisplay` to manage this feature.<br>4. **Warning Label**: Added optional warning labels for specific levels. |
|                |                                                                                                                                                        | 5. **Improved Image Management**: Ensured unique addition of `WinImage` and `GameOverImage` to avoid duplicate entries in the game root.<br>6. **Dynamic Feedback**: Updated warning labels dynamically based on progress towards kill targets.                          |

- projectile

| **Class Name**    | **Description**                                                                                                                | **Changes**                                                                                                                                                                                                                                  |
|-------------------|--------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BossProjectile | This class represents the projectiles fired by the boss in the game. It extends the Projectile class and defines specific properties such as the image, size, and velocity for boss projectiles. It moves horizontally at a fixed speed and is updated on each frame to simulate the projectile's movement. | | Key Methods: | - BossProjectile(double initialYPos): Constructor that initializes the projectile with the specified vertical position (initialYPos). The horizontal position is set to a fixed value (950), and the image height is set to 75. <br> - updatePosition(): This method updates the horizontal position of the projectile by moving it left at a speed of −15 units per frame. <br> - updateActor(): Calls updatePosition() to update the position of the projectile during the game loop. | | EnemyProjectile | This class represents the projectiles fired by enemy units. It extends the Projectile class and defines properties such as the image, size, and velocity for enemy projectiles. It moves horizontally at a fixed speed and is updated on each frame to simulate the projectile's movement. | | Key Methods: | - EnemyProjectile(double initialXPos, double initialYPos): Constructor that initializes the projectile with the specified horizontal and vertical positions (initialXPos, initialYPos). The image height is set to 50. <br> - updatePosition(): This method updates the horizontal position of the projectile by moving it left at a speed of −10 units per frame. <br> - updateActor(): Calls updatePosition() to update the position of the projectile during the game loop. | | UserProjectile | This class represents the projectiles fired by the user (player). It extends the Projectile class and defines properties such as the image, size, and velocity for user projectiles. It moves horizontally at a fixed speed and is updated on each frame to simulate the projectile's movement. | | Key Methods: | - UserProjectile(double initialXPos, double initialYPos): Constructor that initializes the projectile with the specified horizontal and vertical positions (initialXPos, initialYPos). The image height is set to 125. <br> - updatePosition(): This method updates the horizontal position of the projectile by moving it right at a speed of 15 units per frame. <br> - updateActor(): Calls updatePosition() to update the position of the projectile during the game loop. |

- ui

| **Class Name**  | **Description**                                                            | **Changes**                                                                                                                                                        |
|-----------------|----------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GameOverImage | This class represents the game over image displayed when the player loses the game. It extends ImageView and is responsible for setting up the image and its position on the screen. | | Key Methods: | - GameOverImage(double xPosition, double yPosition): Constructor that initializes the game over image at the specified xPosition and yPosition. It sets the image to "gameover.png". | | HeartDisplay | This class represents the heart display shown in the game to indicate the player's health. It uses an HBox to display a row of heart images. It can dynamically remove hearts when the player takes damage. | | Key Methods: | - HeartDisplay(double xPosition, double yPosition, int heartsToDisplay): Constructor that initializes the heart display with the specified position and the number of hearts to show. <br> - removeHeart(): Removes the first heart from the display when the player takes damage. <br> - getContainer(): Returns the container (HBox) that holds the heart images. | | ShieldImage | This class represents a shield image that can be shown or hidden to indicate the availability of a shield for the player. It extends ImageView and is used to control the visibility of the shield on the screen. | | Key Methods: | - ShieldImage(double xPosition, double yPosition): Constructor that initializes the shield image at the specified xPosition and yPosition. The shield image is initially hidden. <br> - showShield(): Makes the shield visible. <br> - hideShield(): Hides the shield. | | WinImage | This class represents the win image displayed when the player wins the game. It extends ImageView and is responsible for setting up the image and its position on the screen. | | Key Methods: | - WinImage(double xPosition, double yPosition): Constructor that initializes the win image at the specified xPosition and yPosition. It sets the image to "youwin.png" and makes it initially invisible. <br> - showWinImage(): Makes the win image visible when the player wins. |

## 5.0 Summary

### 5.1 Features

1. **Start Screen**
    - **Description**: Implemented a start screen with a title, "Start Game," and "Exit" buttons. Added background music that loops indefinitely at 50% volume.
    - **Background Music**: Integrated background music that starts playing automatically when the start screen is displayed, and stops when the game starts or the application is closed.
    - **Classes Involved**:
        - `StartScreen` (UI screen)
        - `Controller ` (game logic controller)
    - **Key Methods**:
        - `StartScreen.show()`
        - `StartScreen.initializeBackgroundMusic()`
        - `StartScreen.stopBackgroundMusic()`
        - `Controller.launchGame()`

2. **Boss Class Implementation**
    - **Description**:Created a Boss class that extends the FighterPlane class, representing the main enemy in the game with dynamic movement patterns, projectile firing, and shield activation.
  - **Key Features**:The Boss has a move pattern with random vertical movements, periodically activates a shield to block damage, and fires projectiles at a certain rate. It also has a health value that decreases when not shielded.
    - **Classes Involved**:
        - `Boss` (extends FighterPlane)
        - `BossProjectile` (projectile fired by Boss)
    - **Key Methods**:
        - `Boss.updatePosition()`  (updates the position of the Boss)
        - `Boss.updateActor()` (updates both position and shield status)
        - `Boss.takeDamage()` (handles damage, considering the shield)
        - `Boss.initializeMovePattern()` (sets the Boss's movement pattern)
        - `Boss.updateShield()`(manages shield activation and deactivation)
        - `Boss.getNextMove()`  (determines the next move in the Boss's pattern)
        - `Boss.activateShield()` (activates the shield)
        - `Boss.deactivateShield()` (deactivates the shield)

3. **Background Music Management**
    - **Description**: Implemented a reusable class for managing background music in the application.
    - **Classes Involved**:
        - `BackgroundMusic` (controller)
        - `LevelParent` (level)
    - **Key Methods**:
        - `BackgroundMusic.play()`
        - `BackgroundMusic.stop()`
        - `LevelParent.initializeMusic()`


### 5.2 Refactoring

1. **Package Organization**
    - **Description**: Reorganized the project structure into specific packages (`actor`,`controller`, `level`, `levelview`, `manager`, `projectiles`, `ui/ux`) to enhance code maintainability and readability.
    - **Benefits**:
        - Improved modularity.
        - Easier navigation and management of classes.
        - Enhanced scalability for future developments.

2. **Background Music Management**
    - **Description**:Implemented background music functionality to enhance the gaming experience by adding dynamic music playback for different levels and menu screens.
    - **Key Changes**:
        - Implemented background music initialization in StartScreen.initializeBackgroundMusic(), using MediaPlayer to load and play the music file.
        - Introduced StartScreen.stopBackgroundMusic() method to stop the music when transitioning to the game or when exiting the application.

3. **Game State Management**
    - **Description**: Refactored game state transitions and pause/resume functionalities to ensure smooth and error-free gameplay, especially during critical states like game-over.
    - **Key Changes**:
        - Implemented state checks within `PauseManager` to prevent unintended game resumes.
        - Ensured timelines are appropriately managed during state transitions.

4. **`LevelViewLevelTwo`**
    - **Description**: The `LevelViewLevelTwo` class and integrated its functionalities into the `LevelView` class by adding `showShield()` and `hideShield()` methods.
    - **Solution**: redundant methods and unused code to improve code readability and maintainability.

5. **Fixed Shield Display in Boss Level**
    - **Description**: The shield was not displaying correctly in the boss level.
    - **Solution**: Moved the shield showing functionality to the `LevelBoss` class for better separation of concerns.

### 5.3 Achievements

1. **Successful Implementation of Background Music System**
    - **Description**:  Developed and integrated a flexible background music management system using JavaFX, enabling dynamic music transitions between different game levels and menu screens. The system includes controls for playing, stopping, and adjusting the volume of the music, with the ability to loop tracks infinitely, providing a seamless auditory experience for players.
    - **Impact**:
        - Enhanced the overall user experience with immersive background music.
        - Allowed for customization of music tracks based on different game scenarios.
        - Contributed to a more polished and professional game atmosphere. 

2. **Development of a Comprehensive Boss Level**
    - **Description**: Designed and implemented a challenging boss level featuring a unique boss with shield mechanics, custom animations, and specific win/lose conditions. This addition introduced a new layer of difficulty and excitement, offering players a formidable challenge and a sense of accomplishment upon victory.
    - **Impact**:
        - Elevated the overall game difficulty and player satisfaction.
        - Showcased advanced game design and development capabilities.

3. ** Implemented Start Menu**
    - **Description**: CDeveloped a start menu that enables users to begin a new game, load saved progress, and access game settings.
    - **Impact**:
        - Provided a clear and intuitive starting point for players to interact with the game.
        - Streamlined the navigation process, enhancing overall user experience and game flow.

4. **Shield Display Fix**
    - **Description**: ixed the issue with the shield display, ensuring it renders correctly during gameplay.
    - **Impact**:
        - Improved visual clarity and accuracy of the shield feature.
        - Enhanced gameplay by ensuring players can rely on the correct shield representation during critical moments.

---

## 6.0 Unexpected Problems

### 1. **Hitbox Not Functional**
- **Issue**: Certain characters or objects in the game had non-functional hitboxes, causing collision detection to fail and affecting gameplay.
- **Solution**:
-Fixed the issue by ensuring that hitboxes were correctly assigned and updated in each game frame.
-Added additional unit tests to verify that all hitboxes were functioning as expected across different game states.
- Investigated the hitbox calculation logic and found errors in how hitboxes were being defined and updated.
- Conducted manual testing for various game objects to confirm that collisions were detected accurately, improving overall gameplay stability.

### 2. **Integration Issues After Refactoring Game Levels**
- **Issue**: After refactoring the codebase to introduce new manager classes, issues emerged with the transition between game levels. Players encountered crashes or lag when moving from one level to the next, interrupting the gameplay flow.

- **Solution**:
    - Implemented an incremental refactoring approach to ensure that changes were made in manageable portions, allowing for continuous testing.
    - Focused on testing level transitions specifically, identifying that the new manager classes were not properly handling the state changes between levels.
    - Adjusted the logic in the level manager to ensure that it properly initialized and cleaned up resources between level transitions.
    - Worked with the team to review the changes and ensure that the refactor did not introduce unintended side effects. This included reviewing object dependencies and ensuring the state management system was robust across different game levels.
    - 
### 3. **Conflict During End Screen Display**
- **Issue**: When the game reached the end screen, some UI elements conflicted, resulting in abnormal displays or the inability to exit the screen properly. This led to issues where the player was stuck or unable to interact with the UI correctly.
- **Solution**:
    - Investigated the UI flow for the end screen and discovered that there was a timing issue in how the end screen UI elements were being initialized and displayed.
    - Introduced a flag to control the end screen’s visibility, making sure it only displayed once all game processes had completed and resources were cleared.
    - Resolved the conflict by redesigning the screen transition process, ensuring that elements were loaded and displayed in a synchronized manner.

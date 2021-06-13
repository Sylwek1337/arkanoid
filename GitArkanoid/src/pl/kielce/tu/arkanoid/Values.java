package pl.kielce.tu.arkanoid;

public class Values {
	static GameState gameState;
	static int currentMenuOption = 0;
	static boolean gameStarted = false;
	static int currentSettingsOption = 0;
	static DifficultyLevel difficultyLevel;
	static boolean soundEnabled = true;
	static boolean leftKeyPressed = false;
	static boolean rightKeyPressed = false;
	static boolean newGame = false;
	static int score = 0;
	static int destroyedBlocks = 0;
	static boolean endGame = false;
	
	
	static MoveDirection direction = MoveDirection.LEFT;
}

enum MoveDirection{
	LEFT,
	RIGHT
}

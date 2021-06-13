package pl.kielce.tu.arkanoid;

public enum DifficultyLevel {
	EASY(0, 6, 6, GraphicsSystem.width/7, 1.9, -3.8),
	MEDIUM(1, 7, 8, GraphicsSystem.width/8, 2.2, -4.0),
	HARD(2, 8, 9, GraphicsSystem.width/10, 2.5, -4.8),
	IMPOSSIBLE(3, 9, 9, GraphicsSystem.width/15, 3, -4.5);
	
	public int toInt() {
		return currentLevel;
	}
	
	int currentLevel;
	
	int blockRows;
	int blockCols;
	double shelfWidth;
	double ballXMovement;
	double ballYMovement;
	DifficultyLevel(int currentLevel, int blockRows, int blockCols, double shelfWidth, double ballXMovement, double ballYMovement){
		this.currentLevel = currentLevel;
		this.blockCols = blockCols;
		this.blockRows = blockRows;
		this.shelfWidth = shelfWidth;
		this.ballXMovement = ballXMovement;
		this.ballYMovement = ballYMovement;
	}
	
	public DifficultyLevel next() {
		return values()[ordinal() + 1];
	}
	
	public DifficultyLevel prev() {
		return values()[ordinal() - 1];
	}
	
	GameConfig getConfigInstance() {
		GameConfig config = new GameConfig();
		config.blockCols = this.blockCols;
		config.blockRows = blockRows;
		config.shelfWidth = this.shelfWidth;
		config.ballXMovement = this.ballXMovement;
		config.ballYMovement = ballYMovement;
		return config;
	}
}

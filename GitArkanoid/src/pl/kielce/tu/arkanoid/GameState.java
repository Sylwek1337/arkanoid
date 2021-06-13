package pl.kielce.tu.arkanoid;

public enum GameState {
	MENU(0),
	GAME(1),
	SETTINGS(2),
	QUIT(3);
	private int n;
	GameState(int n){
		this.n = n;
	}
	public int toNumber() {
		return n;
	}
}

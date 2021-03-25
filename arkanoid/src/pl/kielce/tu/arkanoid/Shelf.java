package pl.kielce.tu.arkanoid;

public class Shelf {
	double xPos;
	double yPos;
	int width;
	double movementSpeed;
	int height = 20;
	public Shelf(double xPos, double yPos, int width, double movementSpeed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.movementSpeed = movementSpeed;
	}

}

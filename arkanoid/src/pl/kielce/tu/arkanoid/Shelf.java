package pl.kielce.tu.arkanoid;

public class Shelf {
	double xPos;
	double yPos;
	double width;
	double movementSpeed;
	int height = 20;
	public Shelf(double xPos, double yPos, double shelfWidth, double movementSpeed) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = shelfWidth;
		this.movementSpeed = movementSpeed;
	}

}

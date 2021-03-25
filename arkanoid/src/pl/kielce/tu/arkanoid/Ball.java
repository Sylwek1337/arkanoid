package pl.kielce.tu.arkanoid;

public class Ball {
	double xPos;
	double yPos;
	final double radius;
	double xMovement;
	double yMovement;
	
	public Ball(double xPos, double yPos, double radius, double xMovement, double yMovement) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.radius = radius;
		this.xMovement = xMovement;
		this.yMovement = yMovement;
	}

	
}

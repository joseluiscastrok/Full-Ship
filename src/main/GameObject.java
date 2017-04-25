package main;


import java.awt.Graphics;

public abstract class GameObject {

	protected double x, y;
	protected double speedX;
	protected double speedY;
	
	protected double travelDirection;
	protected double  shipDirection;	// 0 - 359 grados
	protected double rotationSpeed;
	protected double acceleration;
	protected double accelerationSpeed;
	protected boolean isVisible;
	protected double timeToLive;
	protected int id;
	
	public GameObject (double x, double y, double speedX, double speedY,double travelDirection ,
			double direction, double directionSpeed, double acceleration ,double accelerationSpeed,
			boolean isVisible, double timeToLive, int id) {
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		
		this.travelDirection = travelDirection;
		this.shipDirection = direction;
		this.rotationSpeed = directionSpeed;
		this.acceleration = acceleration;
		this.accelerationSpeed = accelerationSpeed;
		this.isVisible = isVisible;
		this.timeToLive = timeToLive;
		this.id = id;
		
	}
	

	public abstract void tick();
	public abstract void render(Graphics g);

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	
	public double getShipDirection() {
		return shipDirection;
	}
	public void setShipDirection(double direction) {
		this.shipDirection = direction;
	}
	public void setRotationSpeed(double directionSpeed) {
		this.rotationSpeed = directionSpeed;
	}
	
	public double getRotationSpeed() {
		return rotationSpeed;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	public double getAcceleration() {
		return acceleration;
	}
	public void setAccelerationSpeed(double accelerationSpeed) {
		this.accelerationSpeed = accelerationSpeed;
	}
	
	public double getAccelerationSpeed() {
		return accelerationSpeed;
	}

	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}
	
	public double getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(double timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	
	
}

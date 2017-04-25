package main;

import java.awt.Color;
import java.awt.Graphics;



public class Bullet extends GameObject {
    

	public Bullet(double x, double y, double speedX, double speedY, double travelDirection, double direction,
			double directionSpeed, double acceleration, double accelerationSpeed, boolean isVisible, double timeToLive, int id) {
		super(x, y, speedX, speedY, travelDirection, direction, directionSpeed, acceleration, accelerationSpeed, isVisible, timeToLive, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (this.timeToLive>0) { 
			this.timeToLive = this.timeToLive-1;
			if (this.timeToLive == 0) {this.isVisible=false;}
		
			x=x+Game.BULLETSPEED*Math.cos(Math.toRadians(this.shipDirection));
			y=y+Game.BULLETSPEED*Math.sin(Math.toRadians(this.shipDirection));
			
		}
				
	} 

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		int myX = (int)x;
		int myY = (int)y;
		int myX2 = myX+(int)Math.round(5*Math.cos(Math.toRadians(this.shipDirection)));
		int myY2 = myY+(int)Math.round(5*Math.sin(Math.toRadians(this.shipDirection)));
		
		if (isVisible) {
		g.setColor(Color.WHITE);
		
		g.drawLine(myX, myY, myX2, myY2);
		
		
		
		}
		
	}
	

	
}

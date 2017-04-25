package main;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ShipV extends GameObject {

	Random rand = new Random(8);
	
	public ShipV(double x, double y, double speedX, double speedY, double travelDirection, double shipDirection,
			double rotationSpeed, double acceleration ,double accelerationSpeed ,boolean isVisible, double timeToLive, int id) {
		super(x, y, speedX, speedY, travelDirection, shipDirection, rotationSpeed, acceleration,accelerationSpeed, isVisible, timeToLive, id);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		// gravity
		speedY = speedY + Game.GRAVITY;
		
		
		// rotation
		shipDirection = shipDirection + rotationSpeed;
		
		if (shipDirection <0) {shipDirection = shipDirection + 360 ;}
		if (shipDirection >360) {shipDirection = shipDirection - 360;}
		
		// speed
		if (acceleration < .05) { acceleration=acceleration+accelerationSpeed;}
       //limit max speed
		if (Math.abs(speedX + acceleration*Math.cos(Math.toRadians(shipDirection)))+Math.abs(speedY + acceleration*Math.sin(Math.toRadians(shipDirection)))< Game.MAXSHIPSPEED) {
			speedX = speedX + acceleration*Math.cos(Math.toRadians(shipDirection));
			speedY= speedY + acceleration*Math.sin(Math.toRadians(shipDirection));
		}
				
		
		if (accelerationSpeed <= 0 && acceleration >0) {acceleration = acceleration * .8;}
		
		//Friction
		speedX = speedX*(1-Game.FRICTION);
		speedY = speedY*(1-Game.FRICTION);
		
		x=x+speedX;
		y=y+speedY;
		
		if (x <10 && speedX <0 ) { speedX = speedX * -1;};
		if (y <10 && speedY <0) { speedY = speedY * -1;};
		if (x > Game.WIDTH -10 && speedX >0) { speedX = speedX * -1;};
		if (y > Game.HEIGHT -10 && speedY >0) { speedY = speedY * -1;};
		
		//System.out.println(acceleration);
		
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		double myCos = Math.cos(Math.toRadians(shipDirection));
		double mySin = Math.sin(Math.toRadians(shipDirection));
		int myX = (int)x;
		int myY = (int)y;
		
				
		int[] myShipX = new int[] {12,-8,-12,-8,-8,-12,-8};
		int[] myShipY = new int[] {0, 8, 6, 4,-4,-6,-8};
		double[] myShipD = new double[myShipX.length];
		double[] myShipA = new double[myShipX.length];
		int[] myShipDrawX = new int[myShipX.length];
		int[] myShipDrawY = new int[myShipX.length];
		

		double flashy;
		if (acceleration > 0.005 ) {flashy = rand.nextInt(8);}
		else {flashy = 0;}
		
		int[] myTrustX = new int[] {-8,(int)(acceleration*-1000-8-flashy)  ,-8};
		
		int[] myTrustY = new int[] {-4,0,4};
		double[] myTrustD = new double[myTrustX.length];
		double[] myTrustA = new double[myTrustX.length];
		int[] myTrustDrawX = new int[myTrustX.length];
		int[] myTrustDrawY = new int[myTrustX.length];
				
		//  D is for Dimension (size) A is for Angle 
		for (int i =0 ; i < myShipX.length; i++) {
		//myShipX[i]=myX+(int)(myShipX[i]*Math.cos(Math.atan2(myShipY[i],myShipX[i])));
		//myShipY[i]=myY+(int)(myShipY[i]*Math.sin(Math.atan2(myShipY[i],myShipX[i])));
		myShipD[i] = Math.sqrt(myShipX[i]*myShipX[i]+myShipY[i]*myShipY[i]);
		myShipA[i] = Math.atan2(myShipY[i],myShipX[i]);
		myShipDrawX[i]=myX+(int)(myShipD[i]*Math.cos(myShipA[i]+Math.toRadians(shipDirection)));
		myShipDrawY[i]=myY+(int)(myShipD[i]*Math.sin(myShipA[i]+Math.toRadians(shipDirection)));
		}

		for (int i =0 ; i < myTrustX.length; i++) {
		myTrustD[i] = Math.sqrt(myTrustX[i]*myTrustX[i]+myTrustY[i]*myTrustY[i]);
		myTrustA[i] = Math.atan2(myTrustY[i],myTrustX[i]);
		myTrustDrawX[i]=myX+(int)(myTrustD[i]*Math.cos(myTrustA[i]+Math.toRadians(shipDirection)));
		myTrustDrawY[i]=myY+(int)(myTrustD[i]*Math.sin(myTrustA[i]+Math.toRadians(shipDirection)));
		}
		
		// draw Truster
		g.setColor(Color.RED);
		g.drawPolygon(myTrustDrawX, myTrustDrawY, myTrustX.length);
	
		
		//g.setColor(Color.WHITE);
		//g.drawLine(myX, myY,(int)(x+10*myCos),(int)(y+10*mySin) );
		//g.drawOval((int)x, (int)y, 3, 3);
	
		// Draw the Ship		
		if (id ==1) {g.setColor(Color.WHITE);}
		if (id >=2) {g.setColor(Color.YELLOW);}
	
	
		//g.drawPolygon(myShipX, myShipY, myShipX.length);
		g.drawPolygon(myShipDrawX, myShipDrawY, myShipX.length);
		
		
	}

	
	
}

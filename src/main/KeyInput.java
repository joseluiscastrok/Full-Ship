package main;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private double tempShipX;
	private double tempShipY;
	private double tempShipDirection;
	
	
	public KeyInput (Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed (KeyEvent e) {
	
		int key = e.getKeyCode();
//		System.out.println("KEY : "+key);		
		for (int i = 0 ;  i < handler.objects.size(); i++ ) {
		GameObject tempObject = handler.objects.get(i);		
		if (tempObject.id == 1)  { 
				if (key == KeyEvent.VK_RIGHT) {	tempObject.setRotationSpeed(5);}
				if (key == KeyEvent.VK_LEFT) {	tempObject.setRotationSpeed(-5);}
				if (key == KeyEvent.VK_UP) {	tempObject.setAccelerationSpeed(.005);}		
				tempShipX=tempObject.getX();
				tempShipY=tempObject.getY();
				tempShipDirection=tempObject.getShipDirection();
				
		}		

		if (tempObject.id > 100)  { 
			if (key == KeyEvent.VK_A && tempObject.getIsVisible()==false) {	
				tempObject.setIsVisible(true);
				tempObject.setTimeToLive(Game.BULLETTTL);
				tempObject.setX(tempShipX);
				tempObject.setY(tempShipY);
				tempObject.setShipDirection(tempShipDirection);
				i=i+Game.MAXBULLET;
							
				}
	}		

		
		
		}
		
	}
	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
//		System.out.println("KEY : "+key);		
		for (int i = 0 ;  i < handler.objects.size(); i++ ) {
		GameObject tempObject = handler.objects.get(i);		
		if (tempObject.id == 1)  { 
				if (key == KeyEvent.VK_RIGHT) {	tempObject.setRotationSpeed(0);}
				if (key == KeyEvent.VK_LEFT) {	tempObject.setRotationSpeed(0);}
				if (key == KeyEvent.VK_UP) {	tempObject.setAccelerationSpeed(0);}
			
		}		
		}
	
		
	}
	public void keyTyped (KeyEvent e) {
//		System.out.println("ddddd");

		
		
	}
}

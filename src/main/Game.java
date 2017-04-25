package main;




import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1285670934175365101L;
	
	public static final int WIDTH = 900, HEIGHT = 600;
	public static final double GRAVITY = 0.000;
	public static final double MAXSHIPSPEED = 3;
	public static final double BULLETSPEED = 3;
	public static final double BULLETTTL = 100;
	public static final int MAXBULLET = 20;
	
	
	

	public static final double FRICTION = .01;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window (WIDTH, HEIGHT, "this is the title", this);
		// x,y,speedX,speedY,shipDirection,rotationSpeed,acceleration,id
	//	handler.addObject(new ShipV(100,100,0,0,0,270,0,0,0,1));
	//	handler.addObject(new ShipV(250,200,0,0,0,270,0,0,0,2));
	//	handler.addObject(new ShipV(200,250,0,0,0,270,0,0,0,3));
	//	handler.addObject(new ShipV(300,300,0,0,0,270,0,0,0,4));

		// add 3 ships, the 1st ship is controllable , ship >2 is random
		for (int i = 1 ; i < 11 ; i++) {
			handler.addObject(new ShipV(10+10*i,10+10*i,0,0,0,270,0,0,0,true,0,i));;		
		}
		for (int i = 1 ; i < MAXBULLET ; i++) {
		handler.addObject(new Bullet(10,10,0,0,0,0,0,0,0,false,0,100+i));
		}
		

	}
		
	public synchronized void start() {
		Thread thread = new Thread(this);
		thread.start();
		running= true;
	}
		
	public void stop() {
		try {
			thread.join();
			running = false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void run() {
        //init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
        	this.setFocusable(true);
        	
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
               render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//               System.out.println(updates + " Ticks, Fps " + frames);
//               System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
                updates = 0;
                frames = 0;
            }

        }
        stop();
	}
	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
		return;
		} 
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		handler.render(g);

		g.dispose();
		bs.show();

		
	}


	private void tick() {
		handler.tick();
		
		
	
	}


	public static void main (String[] args)  {
		new Game();
	}
	
	
	
	
}

package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game {
	
	private final long UPDATES_PER_SEC = 60;
	private final long SECOND_NS = 1000000000L;
	private final long SECOND_MS = 1000L;
	
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	
	
	private long fps;	// frames per second
	private long ups;	// updates per second
	private long updates; //number of updates
	private long frames; //number of frames
	
	
	private long lastTime;
	private long currTime;
	private long prevTimeMillis;
	private double delta;
	private long elapsed;
	
	//private World world;
	
	private boolean running;
	private boolean paused;
	//private GamePhysics physics;
	

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	private Game()
	{
		fps = ups = 0;
		//updates = UPDATES_PER_SEC;
		updates = 0;
		frames = 0;
		delta = 0;
		lastTime = System.nanoTime();
		prevTimeMillis = System.currentTimeMillis();
		elapsed = 1;
	}
	
	private void start()
	{
		if(running) return;
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
			Keyboard.create();
			Mouse.create();
			Display.setTitle("Game");
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		run();
	}
	
	private void run()
	{
		running = true;
		while(running)
		{
			
			if(Display.isCloseRequested()) stop();
			if(paused)
			{
				
			} else
			{
			
				currTime = System.nanoTime();
				delta += (currTime - lastTime) / (SECOND_NS / (double)UPDATES_PER_SEC);
				lastTime = currTime;
				
				while(delta >= 1)
				{
					//world.update();
					updates++;
					delta--;
				}
				
				
				input();
				update();
				render();
				//frames++;
				
				currTime = System.currentTimeMillis();
				elapsed += currTime - prevTimeMillis;
				prevTimeMillis = currTime;
				ups = (updates * SECOND_MS) / elapsed;
				//fps = (frames * SECOND_MS) / elapsed;
				//System.out.println(ups);
				//System.out.println(fps);
				
				if(elapsed > Long.MAX_VALUE / 2)
				{
					elapsed = 1;
					updates = 0;
				}
			
			}
		}
		
		cleanup();
	}
	
	private void stop()
	{
		if(!running) return;
		running = false;
	}
	
	private void cleanup()
	{
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	
	private void render()
	{
		//world.render();
		Display.update();
	}
	
	
	private void input()
	{
		
	}
	
	private void update()
	{
		
	}
	

}

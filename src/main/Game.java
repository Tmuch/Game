package main;

import input.InputManager;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import entities.EntityPlayer;
import static org.lwjgl.opengl.GL11.*;
import physics.Camera;
import physics.Vector3f;
import physics.World;
import utils.RenderUtils;

public class Game {
	
	private final long UPDATES_PER_SEC = 60;
	private final long SECOND_NS = 1000000000L;
	private final long SECOND_MS = 1000L;
	
	private final int WIDTH = 1200;
	private final int HEIGHT = 900;
	
	
	private long fps;	// frames per second
	private long ups;	// updates per second
	private long updates; //number of updates
	private long frames; //number of frames
	
	
	private long lastTime;
	private long currTime;
	private long prevTimeMillis;
	private double delta;
	private long elapsed;
	
	private World world;
	//private Camera cam;
	
	private EntityPlayer player;
	
	private InputManager input;
	private boolean running;
	private boolean paused;
	
	
	private boolean inMenu;

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
		
		inMenu = false;
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
			
			input = InputManager.getManager();
			
			/* Must be here (for now) because OpenGL context must be initialized */
			//cam = new Camera(70, (float) Display.getWidth() / (float) Display.getHeight(), 0.3f, 1000);
			player = new EntityPlayer();
			RenderUtils.initGraphics();
			world = new World();
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
			/*if(paused)
			{
				
			} else
			*/{
			
				currTime = System.nanoTime();
				delta += (currTime - lastTime) / (SECOND_NS / (double)UPDATES_PER_SEC);
				lastTime = currTime;
				
				while(delta >= 1)
				{
					input();
					update();
					render();
					updates++;
					delta--;
				}
				
				render();
				//frames++;
				
				currTime = System.currentTimeMillis();
				elapsed += currTime - prevTimeMillis;
				prevTimeMillis = currTime;
				ups = (updates * SECOND_MS) / elapsed;
				
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
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		player.updateView();
		world.render();
		Display.update();
	}
	
	
	private void input()
	{
		input.update();
		
		
		if(!inMenu)
			player.input(input);
		
		
		
	}
	
	private void update()
	{
		world.update();
	}

}

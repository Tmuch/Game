package main;

public class Game {
	
	private final long UPDATES_PER_SEC = 60;
	private final long SECOND_NS = 1000000000L;
	private final long SECOND_MS = 1000L;
	
	
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
		run();
	}
	
	private void run()
	{
		System.out.println(Long.MAX_VALUE);
		running = true;
		while(running)
		{
			currTime = System.nanoTime();
			delta += (currTime - lastTime) / (SECOND_NS / (double)UPDATES_PER_SEC);
			lastTime = currTime;
			
			while(delta >= 1)
			{
				//System.out.println("update");
				updates++;
				delta--;
			}
			
			currTime = System.currentTimeMillis();
			elapsed += currTime - prevTimeMillis;
			prevTimeMillis = currTime;
			ups = (updates * SECOND_MS) / elapsed;
			System.out.println(ups);
			
			if(elapsed > Long.MAX_VALUE / 2)
			{
				elapsed = 1;
				updates = 0;
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
		
	}
	
	
	
	

}

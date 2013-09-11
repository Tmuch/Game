package physics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import utils.RenderUtils;
import blocks.*;

public class World {
	
	private int width;
	private int length;
	private int height;
	
	private ArrayList<Block> blocks;
	
	public World()
	{
		width = 40;
		length = 40;
		height = 100;
		blocks = new ArrayList<Block>();
		init();
	}
	
	public World(int w, int l, int h)
	{
		this.width = w;
		this.length = l;
		this.height = h;
		blocks = new ArrayList<Block>();
		init();
	}
	
	
	private void init()
	{
		//entities.add(new Entity(20, 20, -10, 20, 15, 50, Color.LIGHT_GRAY));
		//entities.add(new Entity());
		
		blocks.add(new Block(5,  5, 5,  5, 5, 5, Color.WHITE, Color.GREEN, Color.RED));
		blocks.add(new Block(15, 5, 5, 5, 5, 5, Color.LIGHT_GRAY, Color.BLUE, Color.ORANGE));
	}
	
	public void render()
	{
		glPushMatrix();
		{
			RenderUtils.setColor(Color.DARK_GRAY);
			glBegin(GL_QUADS);
			{
				float w = (float)width / (float)2;
				glVertex3f(-w, 0f, w);
				glVertex3f(-w, 0f, -w);
				glVertex3f(w, 0f, -w);
				glVertex3f(w, 0f, w);
			}
			glEnd();
			
		}
		glPopMatrix();
		
		
		for(Block e : blocks)
		{
			e.render();
		}
		
	}
	
	
	public void test()
	{
		AABB copy = blocks.get(0).bounds.copy();
		copy.offset(0.025f, 0, 0);
		if(!copy.collides(blocks.get(1).bounds))
		{
			blocks.get(0).bounds = copy;
		}
	}
	
	public void update()
	{
		
	}
	
	

}

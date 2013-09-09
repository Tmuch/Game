package physics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import utils.RenderUtils;
import entities.Entity;

public class World {
	
	private int width;
	private int length;
	private int height;
	
	private ArrayList<Entity> entities;
	
	public World()
	{
		width = 40;
		length = 40;
		height = 100;
		entities = new ArrayList<Entity>();
		init();
	}
	
	public World(int w, int l, int h)
	{
		this.width = w;
		this.length = l;
		this.height = h;
		entities = new ArrayList<Entity>();
		init();
	}
	
	
	private void init()
	{
		//entities.add(new Entity(20, 20, -10, 20, 15, 50, Color.LIGHT_GRAY));
		//entities.add(new Entity());
		
		entities.add(new Entity(5,  5, 5,  5, 5, 5, Color.WHITE, Color.GREEN, Color.RED));
		entities.add(new Entity(15, 5, 5, 5, 5, 5, Color.LIGHT_GRAY, Color.BLUE, Color.ORANGE));
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
		
		
		for(Entity e : entities)
		{
			e.render();
		}
		
	}
	
	
	public void test()
	{
		
		AABB copy = entities.get(0).bounds.copy();
		copy.offset(0.05f, 0, 0);
		if(!copy.collides(entities.get(1).bounds))
		{
			entities.get(0).bounds = copy;
		}
	}
	
	public void update()
	{
		
	}
	
	

}

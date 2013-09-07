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
		entities.add(new Entity(15, 5, 15, 5, 5, 5, Color.LIGHT_GRAY, Color.BLUE, Color.ORANGE));
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
			
			//2D test
			/*
			glColor3f(.5f, .8f, 1f);
			glTranslatef(-5f, -5f, -10);
			glBegin(GL_QUADS);
			{
				glVertex2f(0f, 0f);
				glVertex2f(0f, 5f);
				glVertex2f(5f, 5f);
				glVertex2f(5f, 0f);
			}
			glEnd();*/
		}
		glPopMatrix();
		
		
		for(Entity e : entities)
		{
			e.render();
		}
		
		
		
	}
	
	public void test()
	{
		float x = entities.get(0).bounds.getPos().getX();
		float y = entities.get(0).bounds.getPos().getY();
		float z = entities.get(0).bounds.getPos().getZ();
		Vector3f p, s;
		p = new Vector3f(x + 0.005f, y,z);
		s = entities.get(0).bounds.getSize();
		AABB nbb = new AABB(p, s);
		if(!nbb.collides(entities.get(1).bounds))
		{
			entities.get(0).bounds = nbb;
		}
	}
	
	public void update()
	{
		if(entities.get(0).collides(entities.get(1)))
		{
			System.out.println("Collides!!!");
		}
	}
	
	

}

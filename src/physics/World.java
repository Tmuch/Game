package physics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

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
		entities.add(new Entity());
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glColor3f(1f, 1f, 1f);
			glBegin(GL_QUADS);
			{
				float w = (float)width / (float)2;
				glVertex3f(-w, -5f, w);
				glVertex3f(-w, -5f, -w);
				glVertex3f(w, -5f, -w);
				glVertex3f(w, -5f, w);
			}
			glEnd();
			
			for(Entity e : entities)
			{
				e.render();
			}
			
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
		
		
		
	}
	
	public void update()
	{
		
	}
	
	

}

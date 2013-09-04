package entities;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import static utils.RenderUtils.*;

import physics.Color;

public class Entity {
	
	/*
	 * Position of the entity.
	 * 	Always the most negative extremities of the object.
	 */
	private float x, y, z;
	private float length, width, height;
	private Color color, color2, color3;
	
	public Entity()
	{
		this.x = 0f;
		this.y = -3f;
		this.z = -10f;
		this.length = 2f;
		this.width = 2f;
		this.height = 5f;
		color = Color.BLUE;
		color2 = Color.GREEN;
		color3 = Color.RED;
	}
	
	public Entity(float x, float y, float z, float l, float w, float h, Color c)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.length = l;
		this.width = w;
		this.height = h;
		color = color2 = color3 = c;
	}
	
	public void render()
	{
		
		glPushMatrix();
		{
			//glColor3f(1.0f, 0.5f, 0f);
			glTranslatef(x, y, z);
			//glRotatef(x, 1, 1.5f, 0.75f);
			glBegin(GL_QUADS);
			{
				setColor(color3);
				//Left face
				/*glVertex3f(1, 1, 1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, 1, -1);*/
				
				
				// Left face
				glVertex3f(0f, 0f, 0f);
				glVertex3f(0f, height, 0f);
				glVertex3f(0f, height, length);
				glVertex3f(0f, 0f, length);
				

				setColor(color2);
				//Front face
				/*glVertex3f(-1, 1, 1);
				glVertex3f(-1, -1, 1);
				glVertex3f(1, -1, 1);
				glVertex3f(1, 1, 1);*/
				
				
				// Front face
				glVertex3f(0f, 0f, length);
				glVertex3f(0f, height, length);
				glVertex3f(width, height, length);
				glVertex3f(width, 0f, length);

				setColor(color3);
				//right face
				/*glVertex3f(1, 1, 1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);*/
				
				// Right face
				glVertex3f(width, 0f, length);
				glVertex3f(width, height, length);
				glVertex3f(width, height, 0f);
				glVertex3f(width, 0f, 0f);

				setColor(color2);
				//back face
				/*glVertex3f(-1, -1, -1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, -1, -1);*/
				
				// Back face
				glVertex3f(width, 0f, 0f);
				glVertex3f(width, height, 0f);
				glVertex3f(0f, height, 0f);
				glVertex3f(0f, 0f, 0f);

				setColor(color);
				//top face
				/*glVertex3f(-1, 1, 1);
				glVertex3f(-1, 1, -1);
				glVertex3f(1, 1, -1);
				glVertex3f(1, 1, 1);*/
				
				// Top face
				glVertex3f(0f, height, length);
				glVertex3f(0f, height, 0f);
				glVertex3f(width, height, 0f);
				glVertex3f(width, height, length);

				setColor(color);
				//bottom face
				/*glVertex3f(-1, -1, 1);
				glVertex3f(-1, -1, -1);
				glVertex3f(1, -1, -1);
				glVertex3f(1, -1, 1);*/
				
				// Bottom face
				glVertex3f(0f, 0f, length);
				glVertex3f(0f, 0f, 0f);
				glVertex3f(width, 0f, 0f);
				glVertex3f(width, 0f, length);
			}
			glEnd();

		}
		glPopMatrix();
	}
	
}

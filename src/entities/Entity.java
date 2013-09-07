package entities;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import static utils.RenderUtils.*;
import physics.AABB;
import physics.Color;
import physics.Vector3f;

public class Entity {
	
	/*
	 * Position of the entity.
	 * 	Always the most negative extremities of the object.
	 */
	
	/*
	 * The position and size variables represent the bounding box of this entity.
	 * This bounding box will be used to detect collision.
	 * All bounding boxes will be axis aligned.
	 */
	//private float x, y, z;
	//private Vector3f pos;
	//private float length, width, height;
	
	private AABB bounds;
	
	private Color color, color2, color3;
	
	public Entity()
	{
		Vector3f p = new Vector3f(0f, 1f, -10f);
		Vector3f s = new Vector3f(2f, 2f, 5f);
		bounds = new AABB(p, s);
		color = Color.BLUE;
		color2 = Color.GREEN;
		color3 = Color.RED;
	}
	
	public Entity(float x, float y, float z, float l, float w, float h, Color c)
	{
		Vector3f p = new Vector3f(x, y, y);
		Vector3f s = new Vector3f(w, h, l);
		bounds = new AABB(p, s);
		color = color2 = color3 = c;
	}
	
	public void render()
	{
		
		glPushMatrix();
		{
			//glColor3f(1.0f, 0.5f, 0f);
			glTranslatef(bounds.getX(), bounds.getY(), bounds.getZ());
			//glRotatef(x, 1, 1.5f, 0.75f);
			glBegin(GL_QUADS);
			{
				
				float width, height, length;
				width = bounds.getWidth();
				height = bounds.getHeight();
				length = bounds.getLength();
				
				setColor(color3);
				// Left face
				glVertex3f(0f, 0f, 0f);
				glVertex3f(0f, height, 0f);
				glVertex3f(0f, height, length);
				glVertex3f(0f, 0f, length);
				

				setColor(color2);
				// Front face
				glVertex3f(0f, 0f, length);
				glVertex3f(0f, height, length);
				glVertex3f(width, height, length);
				glVertex3f(width, 0f, length);

				setColor(color3);
				// Right face
				glVertex3f(width, 0f, length);
				glVertex3f(width, height, length);
				glVertex3f(width, height, 0f);
				glVertex3f(width, 0f, 0f);

				setColor(color2);
				// Back face
				glVertex3f(width, 0f, 0f);
				glVertex3f(width, height, 0f);
				glVertex3f(0f, height, 0f);
				glVertex3f(0f, 0f, 0f);

				setColor(color);
				// Top face
				glVertex3f(0f, height, length);
				glVertex3f(0f, height, 0f);
				glVertex3f(width, height, 0f);
				glVertex3f(width, height, length);

				setColor(color);
				// Bottom face
				glVertex3f(0f, 0f, length);
				glVertex3f(width, 0f, length);
				glVertex3f(width, 0f, 0f);
				glVertex3f(0f, 0f, 0f);
			}
			glEnd();

		}
		glPopMatrix();
	}
	
}

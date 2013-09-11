package entities;

import physics.AABB;
import physics.World;

public abstract class Entity {
	
	
	/* Bounding box of a concrete entity will be a cylinder.
	 * The center of this will be at x, y, z
	 * with a radius of width/2 and height = height.
	 */
	
	protected float posX, posY, posZ;
	protected float rotX, rotY, rotZ;
	protected float width, height;
	
	/* World that this Entity is in */
	protected World world; 
	
	/* Entity's velocity in the x, y, and z directions */
	protected float velX, velY, velZ;
	
	protected AABB bounds;
	
	
	
	
	
	

}

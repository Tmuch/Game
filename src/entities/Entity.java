package entities;

import physics.AABB;
import physics.World;

public abstract class Entity {
	
	
	/* Bounding box of a concrete entity will be a cylinder.
	 * The center of this will be at x, y, z
	 * with a radius of width/2 and height = height.
	 */
	
	private float posX, posY, posZ;
	private float width, height;
	
	/* World that this Entity is in */
	private World world; 
	
	/* Entity's velocity in the x, y, and z directions */
	private float velX, velY, velZ;
	
	public AABB bounds;
	
	
	
	
	
	

}

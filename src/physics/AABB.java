package physics;

/**
 * The AABB class represents an axis-aligned bounding box. This box will be the
 * bounds of all entities in this game. AABB's are mainly used to detect
 * collisions.
 * 
 * @author Tyler Much
 * 
 */
public class AABB {

	
	/* Minimum x, y, and z values represent the AABBs location */
	private float minX;
	private float maxX;
	private float minY;
	private float maxY;
	private float minZ;
	private float maxZ;
	
	public AABB(Vector3f pos, Vector3f size)
	{
		minX = Math.min(pos.getX() + size.getX(), pos.getX());
		maxX = Math.max(pos.getX() + size.getX(), pos.getX());
		minY = Math.min(pos.getY() + size.getY(), pos.getY());
		maxY = Math.max(pos.getY() + size.getY(), pos.getY());
		minZ = Math.min(pos.getZ() + size.getZ(), pos.getZ());
		maxZ = Math.max(pos.getZ() + size.getZ(), pos.getZ());
		
	}
	
	public AABB(float minX, float maxX, float minY, float maxY, float minZ, float maxZ)
	{
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.minZ = minZ;
		this.maxZ = maxZ;
	}
	
	
	
	public boolean collides(AABB b)
	{
		if(b.getMaxX() > this.minX && b.getMinX() < this.maxX)
		{
			if(b.getMaxY() > this.minY && b.getMinY() < this.maxY)
			{
				if(b.getMaxZ() > this.minZ && b.getMinZ() < this.maxZ)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public void offset(float x, float y, float z)
	{
		this.minX += x;
		this.maxX += x;
		this.minY += y;
		this.maxY += y;
		this.minZ += z;
		this.maxZ += z;
		
	}
	
	public AABB copy()
	{
		return new AABB(this.minX, this.maxX, this.minY, this.maxY, this.minZ, this.maxZ);
	}
	

	public float getMinX() {
		return minX;
	}

	public void setMinX(float minX) {
		this.minX = minX;
	}

	public float getMaxX() {
		return maxX;
	}

	public void setMaxX(float maxX) {
		this.maxX = maxX;
	}

	public float getMinY() {
		return minY;
	}

	public void setMinY(float minY) {
		this.minY = minY;
	}

	public float getMaxY() {
		return maxY;
	}

	public void setMaxY(float maxY) {
		this.maxY = maxY;
	}

	public float getMinZ() {
		return minZ;
	}

	public void setMinZ(float minZ) {
		this.minZ = minZ;
	}

	public float getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(float maxZ) {
		this.maxZ = maxZ;
	}
	
	public float getX()
	{
		return minX;
	}
	
	public float getY()
	{
		return minY;
	}
	
	public float getZ()
	{
		return minZ;
	}
	
	public String toString()
	{
		return "-----\nMinX: " + minX + "\nmaxX: " + maxX + "\nminY: " + minY + "\nmaxY: " + maxY + "\nminZ: " + minZ + "\nmaxZ: " + minZ + "\n-----";
	}
	
}

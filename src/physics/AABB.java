package physics;

/**
 * The AABB class represents an axis-aligned bounding box. 
 * This box will be the bounds of all entities in this game. 
 * AABB's are mainly used to detect collisions.
 * @author Tyler Much
 *
 */
public class AABB {
	
	private Vector3f pos, size;
	/*
	 * Size:
	 * x = width
	 * y = height
	 * z = length
	 */
	
	public AABB()
	{
		pos = size = null;
	}
	
	public AABB(Vector3f p, Vector3f s)
	{
		this.pos = p;
		this.size = s;
	}
	
	
	
	
	public boolean collides(AABB b){
		Vector3f halfSizeA = this.size.div(2f);
		Vector3f centerA = this.pos.add(halfSizeA);
		Vector3f halfSizeB = b.size.div(2f);
		Vector3f centerB = this.pos.add(halfSizeB);
		
		if(Math.abs(centerA.getX() - centerB.getX()) < halfSizeA.getX() + halfSizeB.getX())
		{
			if(Math.abs(centerA.getY() - centerB.getX()) < halfSizeA.getY() + halfSizeB.getY())
			{
				if(Math.abs(centerA.getZ() - centerB.getZ()) < halfSizeA.getZ() + halfSizeB.getZ())
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	
	
	

	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	public Vector3f getSize() {
		return size;
	}

	public void setSize(Vector3f size) {
		this.size = size;
	}

	public float getX()
	{
		return pos.getX();
	}
	
	public float getY()
	{
		return pos.getY();
	}
	
	public float getZ()
	{
		return pos.getZ();
	}
	
	public float getHeight()
	{
		return size.getY();
	}
	
	public float getWidth()
	{
		return size.getX();
	}
	
	public float getLength()
	{
		return size.getZ();
	}
	
}

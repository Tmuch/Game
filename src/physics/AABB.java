package physics;

/**
 * The AABB class represents an axis-aligned bounding box. 
 * This box will be the bounds of all entities in this game. 
 * AABB's are mainly used to detect collisions.
 * @author Tyler Much
 *
 */
public class AABB {
	
	public Vector3f pos, size;
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
	
	
	
	boolean printed = true;
	public boolean collides(AABB b){
		Vector3f halfSizeA = this.size.div(2f);
		Vector3f centerA = this.pos.add(halfSizeA);
		Vector3f halfSizeB = b.size.div(2f);
		Vector3f centerB = b.pos.add(halfSizeB);
		
		/* If difference between centerpoints of two AABB's is smaller than
		 * the sum of the distances between each AABB's centerpoint and edge of its
		 * respective box.
		 */
		
		
		if(!printed)
		{
			System.out.println("a.pos: " + this.pos);
			System.out.println("a.size: " + this.size);
			System.out.println("b.pos: " + b.pos);
			System.out.println("b.size: " + b.size);
			
			
			System.out.println("halfSizeA: " + halfSizeA);
			System.out.println("centerA: " + centerA);
			System.out.println("halfSizeB: " + halfSizeB);
			System.out.println("centerB: " + centerB);
			
		}
		printed = true;
		
		
		if(Math.abs(centerA.getX() - centerB.getX()) < (halfSizeA.getX() + halfSizeB.getX()))
		{
			if(Math.abs(centerA.getY() - centerB.getY()) < (halfSizeA.getY() + halfSizeB.getY()))
			{
				if(Math.abs(centerA.getZ() - centerB.getZ()) < (halfSizeA.getZ() + halfSizeB.getZ()))
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

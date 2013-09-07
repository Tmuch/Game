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

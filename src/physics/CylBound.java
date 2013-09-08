package physics;

public class CylBound extends Bound{
	
	public Vector3f pos; //location of center of bottom circle
	public float radius, height;
	
	public boolean collides(Bound b)
	{
		return false;
	}

}

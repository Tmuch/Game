package physics;

public class Vector3f {
	
	private float x, y, z;
	
	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
	public float dot(Vector3f v)
	{
		return x * v.getX() + y * v.getY() + z * v.getZ();
	}
	
	public Vector3f cross(Vector3f r)
	{
		float x_ = y * r.getZ() - z * r.getY();
		float y_ = z * r.getX() - x * r.getZ();
		float z_ = x * r.getY() - y * r.getX();
		return new Vector3f(x_, y_, z_);
	}
	
	
	/*
	 * Changes this vector's length to 1 and returns this vector.
	 */
	public Vector3f normalize()
	{
		float length = length();
		x /= length;
		y /= length;
		z /= length;
		return this;
	}
	
	public Vector3f rotate()
	{
		return null;
	}
	
	
	public Vector3f add(Vector3f v)
	{
		return new Vector3f(x + v.getX(), y + v.getY(), z + v.getZ());
	}
	
	public Vector3f add(float r)
	{
		return new Vector3f(x + r, y + r, z + r);
	}
	
	public Vector3f sub(Vector3f v)
	{
		return new Vector3f(x - v.getX(), y - v.getY(), z - v.getZ());
	}
	
	public Vector3f sub(float r)
	{
		return new Vector3f(x - r, y - r, z - r);
	}
	
	public Vector3f mul(Vector3f v)
	{
		return new Vector3f(x * v.getX(), y * v.getY(), z * v.getZ());
	}
	
	public Vector3f mul(float r)
	{
		return new Vector3f(x * r, y * r, z * r);
	}
	
	public Vector3f div(Vector3f v)
	{
		return new Vector3f(x / v.getX(), y / v.getY(), z / v.getZ());
	}
	
	public Vector3f div(float r)
	{
		return new Vector3f(x / r, y / r, z / r);
	}
	
	
	
	public String toString()
	{
		return "(" + x + ", " + y + ", " + z +  ")";
	}
	
	

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

}

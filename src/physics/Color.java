package physics;

public class Color {

	private int r,g,b;
	private int alpha;
	
	public static Color BLACK = new Color(java.awt.Color.BLACK);
	public static Color BLUE = new Color(java.awt.Color.BLUE);
	public static Color CYAN = new Color(java.awt.Color.CYAN);
	public static Color DARK_GRAY = new Color(java.awt.Color.DARK_GRAY);
	public static Color GRAY = new Color(java.awt.Color.GRAY);
	public static Color GREEN = new Color(java.awt.Color.GREEN);
	public static Color LIGHT_GRAY = new Color(java.awt.Color.LIGHT_GRAY);
	public static Color MAGENTA = new Color(java.awt.Color.MAGENTA);
	public static Color ORANGE = new Color(java.awt.Color.ORANGE);
	public static Color PINK = new Color(java.awt.Color.PINK);
	public static Color RED = new Color(java.awt.Color.RED);
	public static Color WHITE = new Color(java.awt.Color.WHITE);
	public static Color YELLOW = new Color(java.awt.Color.YELLOW);
	
	public Color(java.awt.Color c)
	{
		r = c.getRed();
		g = c.getGreen();
		b = c.getBlue();
		alpha = c.getAlpha();
	}
	
	public Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(float r, float g, float b)
	{
		this.r = (int)(r * 255);
		this.g = (int)(g * 255);
		this.b = (int)(b * 255);
	}
	
	public float getRf()
	{
		return r / 255f;
	}
	
	public float getGf()
	{
		return g / 255f;
	}
	
	public float getBf()
	{
		return b / 255f;
	}
	
	public float getAlpha()
	{
		return alpha / 255f;
	}
}

package utils;
import physics.Color;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;


public class RenderUtils {
	
	public static void setColor(Color c)
	{
		glColor3f(c.getRf(), c.getGf(), c.getBf());
	}

}

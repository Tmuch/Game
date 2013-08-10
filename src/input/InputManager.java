package input;

public class InputManager {
	
	public static InputManager singleManager = null;
	
	public static InputManager getManager()
	{
		if(singleManager == null)
			singleManager = new InputManager();
		return singleManager;
	}
	
	private InputManager()
	{
		
	}
	
	public void update()
	{
		
	}

}

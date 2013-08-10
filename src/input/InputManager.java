package input;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class InputManager {
	
	private static InputManager singleManager = null;
	
	private final int NUM_KEYCODES = 256;
	private final int MOUSE_BUTTONS = 5;
	
	private ArrayList<Integer> currentKeys;
	private ArrayList<Integer> upKeys;
	private ArrayList<Integer> downKeys;
	
	private ArrayList<Integer> currentMouse;
	private ArrayList<Integer> upMouse;
	private ArrayList<Integer> downMouse;
	private int deltaX;
	private int deltaY;
	
	
	public static InputManager getManager()
	{
		if(singleManager == null)
			singleManager = new InputManager();
		return singleManager;
	}
	
	private InputManager()
	{
		currentKeys = new ArrayList<Integer>(); //keys that are currently being pressed
		upKeys = new ArrayList<Integer>();	//keys that were just unpressed
		downKeys = new ArrayList<Integer>(); //keys that were just pressed down
		
		currentMouse = new ArrayList<Integer>();
		upMouse = new ArrayList<Integer>();
		downMouse = new ArrayList<Integer>();
	}
	
	
	/* For Keyboard */
	
	public boolean getKey(int keyCode)
	{
		return Keyboard.isKeyDown(keyCode);
	}
	
	public boolean getKeydown(int keyCode)
	{
		return downKeys.contains(keyCode);
	}
	
	public boolean getKeyUp(int keyCode)
	{
		return upKeys.contains(keyCode);
	}
	
	
	
	
	
	/* ****************************** */
	
	
	
	/* For Mouse */
	
	public boolean getMouse(int mouseButton)
	{
		return Mouse.isButtonDown(mouseButton);
	}
	
	public boolean getMouseDown(int mouseButton)
	{
		return downMouse.contains(mouseButton);
	}
	
	public boolean getMouseUp(int mouseButton)
	{
		return upMouse.contains(mouseButton);
	}
	
	public void grabMouse()
	{
		if(Mouse.isGrabbed()) return;
		Mouse.setGrabbed(true);
		deltaX = deltaY = 0;
	}
	
	public void unGrabMouse()
	{
		if(!Mouse.isGrabbed()) return;
		Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
		Mouse.setGrabbed(false);
	}
	
	
	/* ******************************* */
	
	
	
	public void update()
	{	
		
		/* Keyboard */
		upKeys.clear();
		for(int i = 0; i < NUM_KEYCODES; i++)
			if(!getKey(i) && currentKeys.contains(i))
				upKeys.add(i);
		
		downKeys.clear();
		for(int i = 0; i < NUM_KEYCODES; i++)
			if(getKey(i) && !currentKeys.contains(i))
				downKeys.add(i);
				
				
		currentKeys.clear();
		for(int i = 0; i < NUM_KEYCODES; i++)
			if(getKey(i)) 
				currentKeys.add(i);
		
		/* Mouse */
		upMouse.clear();
		for(int i = 0; i < MOUSE_BUTTONS; i++)
			if(!getMouse(i) && currentMouse.contains(i))
				upMouse.add(i);
		
		downMouse.clear();
		for(int i = 0; i < MOUSE_BUTTONS; i++)
			if(getMouse(i) && !currentMouse.contains(i))
				downMouse.add(i);
		
		currentMouse.clear();
		for(int i = 0; i < MOUSE_BUTTONS; i++)
			if(getMouse(i))
				currentMouse.add(i);
		
		
	}

}

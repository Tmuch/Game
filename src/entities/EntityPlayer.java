package entities;

import input.InputManager;

import org.lwjgl.input.Keyboard;

import physics.Camera;

public class EntityPlayer extends Entity {
	
	
	public Camera cam;
	public boolean isJumping;
	
	float fbSpeed;
	float lrSpeed;
	float generalMoveSpeed;
	
	float lookSpeed;
	
	private static boolean created = false;
	
	
	public EntityPlayer()
	{
		if(!created)
		{
			created = true;
		}
	}
	
	
	public void move(float pos_neg, float dir)
	{
		
	}
	
	
	public void input(InputManager input)
	{
		if(input.getKey(Keyboard.KEY_S))
		{
			cam.move(-fbSpeed * generalMoveSpeed, Camera.DIR_FB);
		}
		if(input.getKey(Keyboard.KEY_W))
		{
			cam.move(fbSpeed * generalMoveSpeed, Camera.DIR_FB);
		}
		
		if(input.getKey(Keyboard.KEY_A))
		{
			cam.move(lrSpeed * generalMoveSpeed, Camera.DIR_LR);
		}
		
		if(input.getKey(Keyboard.KEY_D))
		{
			cam.move(-lrSpeed * generalMoveSpeed, Camera.DIR_LR);
		}
		
		if(input.getKey(Keyboard.KEY_LSHIFT))
		{
			cam.moveDown(0.12f);
		}
		
		if(input.getKey(Keyboard.KEY_RSHIFT))
		{
			cam.toggleCheat();
		}
		
		if(input.getKey(Keyboard.KEY_SPACE))
		{
			if(cam.getCheat())
			{
				cam.jump();
			} else
				cam.moveUp(0.12f);
		}
		
		if(input.getKey(Keyboard.KEY_ESCAPE))
		{
			input.grabMouse();
		}
		
		if(input.getKey(Keyboard.KEY_TAB))
		{
			input.unGrabMouse();
		}
		
		if(input.mouseXYChange())
		{
			cam.rotateY(input.getDX() * lookSpeed);
			cam.rotateX(input.getDY() * lookSpeed * -1f);
		}
	}
	

}

package entities;

import java.util.ArrayList;

import input.InputManager;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import blocks.Block;
import physics.AABB;
import physics.Camera;
import physics.World;

public class EntityPlayer extends Entity {
	
	
	public Camera cam;
	private float camHeight;
	public boolean isJumping;
	
	private float fbSpeed;
	private float lrSpeed;
	private float generalMoveSpeed;
	
	float lookSpeed;
	
	private static boolean created = false;
	
	
	public EntityPlayer(World w)
	{
		if(!created)
		{
			cam = new Camera(70, (float)Display.getWidth() / (float)Display.getHeight(), 0.3f, 1000);
			
			fbSpeed = 0.15f;
			lrSpeed = 0.1f;
			generalMoveSpeed = 1.2f;
			
			lookSpeed = 0.04f;
			
			camHeight = height * 0.75f;
			world = w;
			width = 5;
			height = 9;
			
			created = true;
		}
	}
	
	public void updateView()
	{
		cam.useView();
	}
	
	public void move(float amt, float dir)
	{
		/* 
		 * TODO: Implement collision detection here.
		 */
		
		float tY, tX, tZ;
		tX = posX;
		tY = posY;
		tZ = posZ;
		
		
		
		if(dir == Camera.DIR_UD)
		{
			posY += amt;
		} else
		{
			posZ += amt * Math.sin(Math.toRadians(rotY + 90 * dir));
			posX += amt * Math.cos(Math.toRadians(rotY + 90 * dir));
		}
		
		ArrayList<Block> blocks = world.blocks;
		for(Block b : blocks)
		{
			if(collides(b.bounds))
			{
				posX = tX;
				posY = tY;
				posZ = tZ;
				return;
			}
		}
		
		updateCam();	
	}
	
	private void rotateView(InputManager input)
	{
		float ry = input.getDX() * lookSpeed;
		float rx = input.getDY() * -lookSpeed;
		cam.rotateY(ry);
		rotY += ry;
		cam.rotateX(rx);
		rotX += rx;
		updateCam();
	}
	
	private void updateCam()
	{
		cam.setX(-posX);
		cam.setZ(-posZ);
		cam.setY(posY + camHeight);
		
		cam.setRotx(rotX);
		cam.setRoty(rotY);
		
	}
	
	private void jump()
	{
		float initVelo;
		float grav;
		/* 
		 * TODO
		 */
	}
	
	
	public void input(InputManager input)
	{
		if(input.getKey(Keyboard.KEY_S))
		{
			//cam.move(-fbSpeed * generalMoveSpeed, Camera.DIR_FB);
			move(fbSpeed * generalMoveSpeed, Camera.DIR_FB);
		}
		if(input.getKey(Keyboard.KEY_W))
		{
			//cam.move(fbSpeed * generalMoveSpeed, Camera.DIR_FB);
			move(-fbSpeed * generalMoveSpeed, Camera.DIR_FB);
		}
		
		if(input.getKey(Keyboard.KEY_A))
		{
			//cam.move(lrSpeed * generalMoveSpeed, Camera.DIR_LR);
			move(-lrSpeed * generalMoveSpeed, Camera.DIR_LR);
		}
		
		if(input.getKey(Keyboard.KEY_D))
		{
			//cam.move(-lrSpeed * generalMoveSpeed, Camera.DIR_LR);
			move(lrSpeed * generalMoveSpeed, Camera.DIR_LR);
		}
		
		if(input.getKey(Keyboard.KEY_LSHIFT))
		{
			//cam.moveDown(0.12f);
			move(0.12f, Camera.DIR_UD);
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
				//cam.moveUp(0.12f);
				move(-0.12f, Camera.DIR_UD);
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
			//cam.rotateY(input.getDX() * lookSpeed);
			//cam.rotateX(input.getDY() * lookSpeed * -1f);
			rotateView(input);
		}
	}
	
	
	/*
	 * TODO: Collision detection.
	 */
	
	public boolean collides(AABB box)
	{
		/* 
		 * Skipping vertical collision for now. Focusing on 2D.
		 * 
		 */
		
		/*
		 * (posX, posZ) = center of circle
		 * width = diameter of circle
		 */
		
		/* Line segment from (minX, minZ) to (maxX, minZ) */
		float radius = width/2;
		
		
		/*System.out.println("-------------");
		System.out.println("posX: " + posX);
		System.out.println("box.getMinX(): " + box.getMinX());
		System.out.println("box.getMaxX(): " + box.getMaxX());*/
		
		if(posX >= box.getMinX() && posX <= box.getMaxX())
		{
			System.out.println("here");
			if(Math.abs(box.getMinZ() - posZ) <= radius)
			{
				System.out.println("\there");
				return true;
			}
		} else
		{
			float a, b, c;
			a = box.getMinX() - posX;
			b = box.getMinZ() - posZ;
			c = box.getMaxX() - posX;
			
			if(((a*a + b*b) <= radius*radius) || ((c*c + b*b) <= radius*radius))
			{
				return true;
			}
		}
		
		return false;
	}

}

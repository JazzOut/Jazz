package com.jazz.jazz;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class GameCollision implements ContactListener {


	
	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		Body a = contact.getFixtureA().getBody();
		Body b = contact.getFixtureB().getBody();
		
	
		
		if(a.getUserData() instanceof Ball){
			if(b.getUserData() instanceof Block){
				((Block)b.getUserData()).hit();
				if(((Block)b.getUserData()).hits <= 0){
					((Block)b.getUserData()).isAlive = false;
				}
			}
			
			if(b.getUserData() instanceof Wall){
				Wall wall = (Wall) b.getUserData();
				if(wall.deathWall){
					((Ball)a.getUserData()).isAlive = false;
				}
			}
		}
		else if(b.getUserData() instanceof Ball){
			if(a.getUserData() instanceof Block){
				((Block)a.getUserData()).hit();
				if(((Block)a.getUserData()).hits <= 0){
					((Block)a.getUserData()).isAlive = false;
				}
			}
			
			if(a.getUserData() instanceof Wall){
				Wall wall = (Wall) a.getUserData();
				if(wall.deathWall){
					((Ball)b.getUserData()).isAlive = false;
				}
			}
		}
		
		if(a.getUserData() instanceof Paddle){
			if(b.getUserData() instanceof Crystal){
				Crystal c = (Crystal) b.getUserData();
				c.isAlive = false;
				c.collected = true;
			}
		}else if(b.getUserData() instanceof Paddle){
			if(a.getUserData() instanceof Crystal){
				Crystal c = (Crystal) a.getUserData();
				c.isAlive = false;
				c.collected = true;
			}
		}
		

	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}

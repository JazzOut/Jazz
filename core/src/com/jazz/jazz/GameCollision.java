package com.jazz.jazz;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class GameCollision implements ContactListener {

	private static Vector2 otherPos;
	private static Vector2 thisPos;
	
	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		Body a = contact.getFixtureA().getBody();
		Body b = contact.getFixtureB().getBody();
		
	
		
		if(a.getUserData() instanceof Ball){
			if(b.getUserData() instanceof Block){
				((Block)b.getUserData()).hits--;
				if(((Block)b.getUserData()).hits <= 0){
					((Block)b.getUserData()).isAlive = false;
				}
			}
		}
		else if(b.getUserData() instanceof Ball){
			if(a.getUserData() instanceof Block){
				((Block)a.getUserData()).hits--;
				if(((Block)a.getUserData()).hits <= 0){
					((Block)a.getUserData()).isAlive = false;
				}
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

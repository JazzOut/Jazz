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
//		Body a = contact.getFixtureA().getBody();
//		Body b = contact.getFixtureB().getBody();
//		
//		if(a.getUserData() instanceof Ball){
//			Ball ball = (Ball) a.getUserData();
//			b.getPosition();
//			ball.setSpeed(JazzCore.tmp.set(-ball.speed.x, ball.speed.y));
//		}
//		else if(b.getUserData() instanceof Ball){
//			Ball ball = (Ball) b.getUserData();
//			otherPos = a.getPosition();
//			thisPos = b.getPosition();
//			float x = ball.speed.x;
//			float y = ball.speed.y;
//			
//			if(thisPos.x  < otherPos.x){
//				x = -x;
//			}else if(thisPos.x  < otherPos.x)
//			ball.setSpeed(JazzCore.tmp.set(-ball.speed.x, ball.speed.y));
//		}
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

package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StandardBall extends Ball {

	private final float MAX_SPEED = 150;
	
	public StandardBall() {
		super();
	}

	public World init(World world, Vector2 pos, Vector2 speed) {

		super.init(world, new ModelInstance(BlockTypes.SMALL_CIRCLE.getCopy()),
				BlockTypes.SMALL_CIRCLE.getBodyType(),
				BlockTypes.SMALL_CIRCLE.getFixtureDef(), pos, speed);
		super.body.setLinearVelocity(speed);
		
		return world;
	}
	
	public void update(){

		Vector2 temp= super.body.getLinearVelocity();
		if(temp.len() != getMaxSpeed()){
			temp = temp.nor().scl(getMaxSpeed());
		}
		super.body.setLinearVelocity(temp.x, temp.y);
	}
	
	public float getMaxSpeed(){
		return MAX_SPEED;
	}
}

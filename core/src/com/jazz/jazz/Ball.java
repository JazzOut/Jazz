package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class Ball implements Poolable{
	
	
	
	static BodyDef ballBodyDef = new BodyDef();

	private ModelInstance modInst;
	Body body;
	Vector2 speed;
	
	protected boolean isLockedToPaddle;
	protected boolean isAlive;
	
	public Ball(){
		modInst = null;
		body = null;
		speed = null;
		isLockedToPaddle = false;
		isAlive = false;
	}
	
	public World init(World world, ModelInstance modInst, BodyType bodyType, FixtureDef fix, Vector2 pos, Vector2 speed){
		
		ballBodyDef.type = bodyType;
		ballBodyDef.position.set(pos);
		this.modInst = modInst;
		this.speed = speed;
		body = world.createBody(ballBodyDef);
		body.createFixture(fix);
		body.setUserData(this);
		isLockedToPaddle = true;
		isAlive = true;
		return world;
	}
	
	public abstract void update();
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzCore.get3D(body.getPosition())).rotate(JazzCore.axis, body.getAngle()*MathUtils.radiansToDegrees);
	}
	
	public void setSpeed(Vector2 speed){
		this.speed = speed;
	}
	
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		modInst = null;
		body = null;
		speed = null;
		isLockedToPaddle = false;
		isAlive = false;
	}
	
	public void dispose(){
		
	}

	
	public ModelInstance getModInst() {
		return modInst;
	}
	
	public void setModInst(ModelInstance modInst) {
		this.modInst = modInst;
	}
}

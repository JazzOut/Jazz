package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Wall {
	
	static BodyDef wallBodyDef = new BodyDef();
	
	private ModelInstance modInst;
	private Body body;
	protected boolean deathWall;
	
	public Wall(){
		modInst = null;
		body = null;
		deathWall = false;
	}
	
	public World init(World world, ModelInstance modInst, BodyType bodyType, FixtureDef fix, Vector2 pos, boolean deathWall){
		
		wallBodyDef.type = bodyType;
		wallBodyDef.position.set(pos);
		this.modInst = modInst;
		fix.filter.categoryBits = 2;
		body = world.createBody(wallBodyDef);
		if(deathWall){
			FixtureDef fix2 = new FixtureDef();
			fix2.density = fix.density;
			fix2.restitution = fix.restitution;
			fix2.friction = fix.friction;
			fix2.shape = fix.shape;
			fix2.filter.categoryBits = fix.filter.categoryBits;
			fix2.isSensor = true;
			body.createFixture(fix2);
		}else{
			body.createFixture(fix);
		}
		body.setUserData(this);
		updateModel();
		this.deathWall = deathWall;

		return world;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzGame.get3D(body.getPosition())).rotate(JazzGame.axis, body.getAngle()*MathUtils.radiansToDegrees);
	}
	
	public void dispose(){
		
	}
	
	public Body getBody(){
		return body;
	}
	
	public void setPosition(Vector2 pos){
		setPosition(pos.x, pos.y);
	}
	
	public void setPosition(float x, float y){
		body.setTransform(x, y, body.getAngle());
		updateModel();
	}
	
	public void rotate(float angle){
		body.setTransform(body.getPosition(), angle* MathUtils.degreesToRadians);
		updateModel();
	}
	
	public ModelInstance getModInst() {
		return modInst;
	}
	
	public void setModInst(ModelInstance modInst) {
		this.modInst = modInst;
	}
	
}

package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Block implements Poolable{

	//need a body for 2d
	//modelbuilder for the models till we get blender
	//create the model using the modelbuilder
	//set the model into an instance
	//
	//  so modelbuilder -<builds>> model -<goesin>> instance -<goes in body>> userdata
	//
	//need bodydefinition for body
	//set body position, type
	//need fixture for body
	//set fixture with density, restitution, and friction
	//create shape for the fixture
	//set the shape
	//create body using world.createbody
	//set 3d modelinstance to body using setuserdata
	
	static BodyDef bodyDef = new BodyDef();
	
	private ModelInstance modInst;

	private Body body;
	
	public Block(){
		modInst = null;
		body = null; 
	}

	public World init(World world, ModelInstance modInst, BodyType bodyType, FixtureDef fix, Vector2 pos){
		
		bodyDef.type = bodyType;
		bodyDef.position.set(pos);
		this.modInst = modInst;
		body = world.createBody(bodyDef);
		body.createFixture(fix);
		body.setUserData(this);
		return world;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzCore.get3D(body.getPosition())).rotate(JazzCore.axis, body.getAngle());
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.body = null;
		modInst = null;
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

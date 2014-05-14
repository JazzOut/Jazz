package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class Block implements Poolable{

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
	private final int MAXHITS = 1;
	
	private ModelInstance modInst;

	private Body body;
	
	protected boolean isAlive;
	protected int hits;
	
	public static final int crystalsDropped = 5;
	
	public Block(){
		modInst = null;
		body = null; 
		isAlive = false;
		hits = 0;
	}

	public World init(World world, ModelInstance modInst, BodyType bodyType, FixtureDef fix, Vector2 pos, int maxHits){
		
		isAlive = true;
		hits = maxHits;
		bodyDef.type = bodyType;
		bodyDef.position.set(pos);
		this.modInst = modInst;
		body = world.createBody(bodyDef);
		body.createFixture(fix);
		body.setUserData(this);
		return world;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzGame.get3D(body.getPosition())).rotate(JazzGame.axis, body.getAngle()*MathUtils.radiansToDegrees);
	}
	
	public void rotate(float angle){
		body.setTransform(body.getPosition(), angle* MathUtils.degreesToRadians);
		updateModel();
	}
	
	public void setPosition(Vector2 pos){
		setPosition(pos.x, pos.y);
	}
	
	public void setPosition(float x, float y){
		body.setTransform(x, y, body.getAngle());
		updateModel();
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.body = null;
		modInst = null;
		isAlive = false;
		hits = 0;
	}

	public void dispose(){
		
	}
	
	public void hit(){
		hits--;
	}
	
	public ModelInstance getModInst() {
		return modInst;
	}
	
	public void setModInst(ModelInstance modInst) {
		this.modInst = modInst;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
	public int getCrystalsDroppedAmt(){
		return crystalsDropped;
	}
}

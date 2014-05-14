package com.jazz.jazz;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;

public class Paddle {

	static BodyDef bodyDef = new BodyDef();
	static Model paddleModel = null;
	
	private ModelInstance modInst;
	private Body body;
	private float lastMove;
	private int force;
	protected float score;
	
	public Paddle(){
		modInst = null;
		score = 0;
	}
	
	public World init(World world, Vector2 pos, float lower, float upper){
		
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(pos);
		force = 0;
		
		this.modInst = new ModelInstance(getModel());
		
		body = world.createBody(bodyDef);
		
		PrismaticJointDef prisDef = new PrismaticJointDef();
		prisDef.bodyA = body;
		bodyDef.type = BodyType.StaticBody;
		Body bodB = world.createBody(bodyDef);
		prisDef.initialize(body, bodB, pos, new Vector2(0,1));
		prisDef.lowerTranslation = lower;
		prisDef.upperTranslation = upper;
		prisDef.enableLimit = true;
//		prisDef.collideConnected = true;
		
		
		

		body.createFixture(createFixtureDef(10, 0, 0));
		body.setUserData(this);
		world.createJoint(prisDef);
		//body.setLinearDamping(100000);
		return world;
	}
	
	private static Model getModel(){
		
		if(paddleModel == null){
			AssetManager assets = new AssetManager();
			assets.load("data/Paddle.g3db", Model.class);
			assets.finishLoading();
			paddleModel = assets.get("data/Paddle.g3db");
		}
		
		return paddleModel;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzGame.get3D(body.getPosition())).rotate(JazzGame.axis, body.getAngle()*MathUtils.radiansToDegrees);
	}
	
	public void setPull(){
		force = -1;
	}
	
	public void setPush(){
		force = 1;
	}
	
	public void setOff(){
		force = 0;
	}
	
	public int getAction(){
		return force;
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
	
	public ModelInstance getModInst() {
		return modInst;
	}
	
	public void setModInst(ModelInstance modInst) {
		this.modInst = modInst;
	}

	public Body getBody() {
		return body;
	}
	
	public void mouseY(float y){
		y =  -y *body.getMass()*body.getMass();
		//body.applyLinearImpulse(0, y, body.getPosition().x, body.getPosition().y, true);
		body.applyForceToCenter(new Vector2(0,y), true);
//		body.setTransform(new Vector2(body.getPosition().x,body.getPosition().y +y), body.getAngle());
		updateModel();
		lastMove = y;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
	private FixtureDef createFixtureDef(float density, float friction, float restitution){
		FixtureDef fix = new FixtureDef();
		fix.density = density;
		fix.filter.categoryBits = 2;
		fix.friction = friction;
		fix.restitution = restitution;
		
		BoundingBox box = new BoundingBox();
		Vector3 dim;
		
		modInst.calculateBoundingBox(box);
		dim = box.getDimensions();
		fix.shape = new PolygonShape();
		((PolygonShape) fix.shape).setAsBox(dim.x/2, dim.y/2);
		
		return fix;
		
	}
	
}

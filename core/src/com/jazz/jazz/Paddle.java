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
	
	public Paddle(){
		modInst = null;
	}
	
	public World init(World world, Vector2 pos){
		
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(pos);
		this.modInst = new ModelInstance(getModel());
		body = world.createBody(bodyDef);
		PrismaticJointDef prisDef;
		prisDef = new PrismaticJointDef();

		body.createFixture(createFixtureDef(10, 0, 0));
		body.setUserData(this);
		body.setLinearDamping(100000);
		return world;
	}
	
	private static Model getModel(){
		
		if(paddleModel == null){
			AssetManager assets = new AssetManager();
			assets.load("data/paddle.g3db", Model.class);
			assets.finishLoading();
			paddleModel = assets.get("data/paddle.g3db");
		}
		
		return paddleModel;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzCore.get3D(body.getPosition())).rotate(JazzCore.axis, body.getAngle()*MathUtils.radiansToDegrees);
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
		body.setLinearVelocity(0, y*10);
		updateModel();
		lastMove = y*10;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
	private FixtureDef createFixtureDef(float density, float friction, float restitution){
		FixtureDef fix = new FixtureDef();
		fix.density = density;
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

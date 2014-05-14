package com.jazz.jazz;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Crystal implements Poolable{
	
	
	public static final Pool<Crystal> crystalPool = new Pool<Crystal>() {
		@Override
		protected Crystal newObject() {
			return new Crystal();
		}
	};
	
	public static Model crystalModel;
	public static FixtureDef fix = new FixtureDef();
	public static BodyDef crystalDef = new BodyDef();
	public ModelInstance modInst;
	protected Body body;
	protected boolean isAlive;
	protected boolean collected;
	
	public Crystal(){
		reset();
	}
	
	public World init(World world, Vector2 pos){
		
		modInst = new ModelInstance(getModel());
		crystalDef.type = BodyType.DynamicBody;
		crystalDef.position.set(pos);
		body = world.createBody(crystalDef);
		
		fix.density = 10;
		fix.friction = 0;
		fix.restitution = 0;
		
		fix.shape = new CircleShape();
		fix.shape.setRadius(2);
		fix.filter.categoryBits =2;
		fix.filter.maskBits = 2;
		//fix.isSensor = true;
		body.createFixture(fix);
		body.setUserData(this);
		isAlive = true;
		collected = false;
		
		return world;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		body = null;
		modInst = null;
		isAlive = false;
		collected = false;
	}
	
	
	public static Model getModel(){
		if(crystalModel == null){
			AssetManager assets = new AssetManager();
			assets.load("data/Crystal.g3db", Model.class);
			assets.finishLoading();
			crystalModel = assets.get("data/Crystal.g3db");
		}
		
		return crystalModel;
	}
	
	public void updateModel(){
		modInst.transform.setToTranslation(JazzGame.get3D(body.getPosition())).rotate(JazzGame.axis, body.getAngle()*MathUtils.radiansToDegrees);
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
	
	
	
	
}

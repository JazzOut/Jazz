package com.jazz.jazz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public enum BlockTypes {

	SMALL_CIRCLE(new ModelBuilder().createSphere(2, 2, 2, 19, 19, new Material(), Usage.Normal | Usage.Position, 0, 360, 0, 360), "sphere", BodyType.DynamicBody, 10f, 0f, 1f),
	REG_BLOCK(new ModelBuilder().createBox(10, 5, 5, new Material(), Usage.Normal | Usage.Position), "rectangle", BodyType.StaticBody, 10f, .5f, 0f),
	HARD_BLOCK(new ModelBuilder().createBox(10, 5, 5, new Material(ColorAttribute.createDiffuse(Color.GREEN)),Usage.Position | Usage.Normal), "rectangle", BodyType.StaticBody, 10f, .5f, 0f),
	WALL(new ModelBuilder().createBox(5, 200, 5, new Material(), Usage.Normal | Usage.Position), "rectangle",BodyType.StaticBody, 0,0,0),
	LONG_WALL(new ModelBuilder().createBox(5, 300, 5, new Material(), Usage.Normal | Usage.Position), "rectangle",BodyType.StaticBody, 0,0,0);
	
	private Model model;
	private BodyType bodType;
	private FixtureDef fix;
	private String shapeType;
	
	BlockTypes(Model model, String shapeType, BodyType bodType, float density, float friction, float restitution){
		this.model = model;
		this.shapeType = shapeType;
		this.bodType = bodType;
		setFixture(density, friction, restitution);
	}
	
	private void setFixture(float density, float friction, float restitution ){
		fix = new FixtureDef();
		fix.density = density;
		fix.friction = friction;
		fix.restitution = restitution;
		
		BoundingBox box = new BoundingBox();
		Vector3 dim;
		if(shapeType.equals("rectangle")){
			model.calculateBoundingBox(box);
			dim = box.getDimensions();
			fix.shape = new PolygonShape();
			((PolygonShape) fix.shape).setAsBox(dim.x/2, dim.y/2);
			
		}else if(shapeType.equals("sphere")){
			model.calculateBoundingBox(box);
			dim = box.getDimensions();
			fix.shape = new CircleShape();
			fix.shape.setRadius(dim.y/2);
		}
	}
	
	public BodyType getBodyType(){
		return bodType;
	}
	
	public Model getCopy(){
		return model;
	}
	
	public FixtureDef getFixtureDef(){
		return fix;
	}
	
}

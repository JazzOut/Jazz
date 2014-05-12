package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;



public class Boundaries {
	
	public static final float sizeOffset = 2.5f;
	public static final float downShift = 5f;
	
	String shape;
	Array<Wall> walls = new Array<Wall>();
	
	
	
	public Boundaries(String shape){
		this.shape = shape;
		
	}
	
	
	
	public World init(World world){
		if(shape.equals("std_rect")){
			Wall wall = new Wall();
			Vector2 pos = new Vector2(0,0);
			world = wall.init(world, new ModelInstance(BlockTypes.WALL.getCopy()), BlockTypes.WALL.getBodyType(), BlockTypes.WALL.getFixtureDef(), pos.set(0-sizeOffset, 100-downShift));
			walls.add(wall);
			wall = new Wall();
			world = wall.init(world, new ModelInstance(BlockTypes.WALL.getCopy()), BlockTypes.WALL.getBodyType(), BlockTypes.WALL.getFixtureDef(), pos.set(300-sizeOffset, 100-downShift));
			walls.add(wall);
			wall = new Wall();
			world = wall.init(world, new ModelInstance(BlockTypes.LONG_WALL.getCopy()), BlockTypes.LONG_WALL.getBodyType(), BlockTypes.LONG_WALL.getFixtureDef(), pos.set(150-sizeOffset, 0+sizeOffset-downShift));
			wall.rotate(-90f);
			walls.add(wall);
			wall = new Wall();
			world = wall.init(world, new ModelInstance(BlockTypes.LONG_WALL.getCopy()), BlockTypes.LONG_WALL.getBodyType(), BlockTypes.LONG_WALL.getFixtureDef(), pos.set(150-sizeOffset, 200-sizeOffset-downShift));
			wall.rotate(90f);
			walls.add(wall);
		}
		
		return world;
	}
	
	public void render(ModelBatch batch, Environment env){
		for(int i = 0; i < walls.size; i++){
			walls.get(i).updateModel();
			batch.render(walls.get(i).getModInst(), env);
		}
	}
	
}

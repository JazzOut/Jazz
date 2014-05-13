package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public abstract class Level {

	protected final Array<Block> activeBlocks = new Array<Block>();
	protected Boundaries bound;
	protected Ball ball;
	
	public Level(){

	}
	
	public abstract World render(ModelBatch modelBatch, World world, Environment environment);
	
	public abstract World create(World world);
	
	
	
	
}

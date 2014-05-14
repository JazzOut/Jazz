package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class SquareBlock extends StandardBlock {

	public SquareBlock(){
		super();
	}
	
	
	public World init(World world, Vector2 pos) {
		super.init(world, new ModelInstance(BlockTypes.SQUARE_REG_BLOCK.getCopy()),
				BlockTypes.SQUARE_REG_BLOCK.getBodyType(),
				BlockTypes.SQUARE_REG_BLOCK.getFixtureDef(), pos, getMaxHits());
		
		return world;
	}
}

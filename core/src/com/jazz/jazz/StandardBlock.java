package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StandardBlock extends Block {

	private final int MAXHITS = 1;
	
	public StandardBlock() {
		super();
	}

	public World init(World world, Vector2 pos) {
		super.init(world, new ModelInstance(BlockTypes.REG_BLOCK.getCopy()),
				BlockTypes.REG_BLOCK.getBodyType(),
				BlockTypes.REG_BLOCK.getFixtureDef(), pos, getMaxHits());
		
		return world;
	}
	
	protected int getMaxHits(){
		return MAXHITS;
	}

}

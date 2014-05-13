package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class HardBlock extends StandardBlock {

	private final int MAXHITS = 2;

	public HardBlock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public World init(World world, Vector2 pos) {
		super.init(world, new ModelInstance(BlockTypes.HARD_BLOCK.getCopy()),
				BlockTypes.HARD_BLOCK.getBodyType(),
				BlockTypes.HARD_BLOCK.getFixtureDef(), pos, getMaxHits());
		
		return world;
	}
	
	protected int getMaxHits(){
		return MAXHITS;
	}
}

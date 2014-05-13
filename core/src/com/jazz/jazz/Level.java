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
	
	//public abstract World render(ModelBatch modelBatch, World world, Environment environment);
	
	public abstract World create(World world);
	
	public World render(ModelBatch modelBatch, World world, Environment environment){
		((StandardBall)ball).update();
		ball.updateModel();
		activeBlocks.get(0).getModInst().transform.getTranslation(JazzCore.threeD);
		Block block;
		for (int i = 0; i < activeBlocks.size; i++) {
			block = activeBlocks.get(i);
			if (!block.isAlive) {
				activeBlocks.removeIndex(i);
				world.destroyBody(block.getBody());
				if(block instanceof HardBlock){
					Levels.hardBlockPool.free((HardBlock) block);
				}else if(block instanceof StandardBlock){
					Levels.standardBlockPool.free((StandardBlock) block);
				}
				i--;
			} else {
				block.updateModel();
				modelBatch.render(block.getModInst(), environment);
				bound.render(modelBatch, environment);
			}
		}
		ball.updateModel();
		modelBatch.render(ball.getModInst(), environment);
		
		return world;
	}
	
	
	
}

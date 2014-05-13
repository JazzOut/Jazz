package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public abstract class Level {

	protected final Array<Block> activeBlocks = new Array<Block>();
	protected Boundaries bound;
	protected Array<Ball> balls;
	
	public Level(){

	}
	
	//public abstract World render(ModelBatch modelBatch, World world, Environment environment);
	
	public abstract World create(World world);
	
	public World render(ModelBatch modelBatch, World world, Environment environment, Paddle paddle){
		//balls = new Array<Ball>();

		
		bound.render(modelBatch, environment);
		
		if(balls.size != 0){
			Ball b;
			for(int i = 0; i < balls.size; i++){
				b = balls.get(i);
				if(!b.isAlive){
					balls.removeIndex(i);
					world.destroyBody(b.body);
					if(b instanceof StandardBall){
						Levels.standardBallPool.free((StandardBall) b);
					}
					i--;
				}else{
					b.update();
					b.updateModel();
					modelBatch.render(b.getModInst(), environment);
				}
			}
		}
		
		if(activeBlocks.size == 0){
			return world;
		}
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
			}
		}

		
		
		return world;
	}
	
	public float getTopLeftY(){
		return bound.topLeftY;
	}
	
	
	
}

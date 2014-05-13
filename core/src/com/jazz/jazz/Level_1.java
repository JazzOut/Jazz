package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Level_1 extends Level {

	public Level_1(){
		super();
	}
	
	//add any new levels to Levels.java enum
	
	
	//make sure to implement create
	//instantiate any objects you need here.
	public World create(World world){

		int rowCount = 10;
		int columCount = 12;
		Block block;
		Random rnd = new Random();
		Vector2 pos = new Vector2();
		for (int j = 0; j < columCount; j++) {
			for (int i = 0; i < rowCount; i++) {
				if(rnd.nextFloat() < .5){
					block = Levels.standardBlockPool.obtain();
					world = ((StandardBlock) block).init(world,
							pos.set(i * 10 + 100, j * 15 + 10));
				}else{
					block = Levels.hardBlockPool.obtain();
					world = ((HardBlock) block).init(world,
							pos.set(i * 10 + 100, j * 15 + 10));
				}
				block.rotate(90);
				block.updateModel();
				activeBlocks.add(block);
			}
		}
	
		ball = new StandardBall();
		((StandardBall)ball).init(world, new Vector2(10, 50), new Vector2(2, 1));
		ball.updateModel();
		
		bound = new Boundaries("std_rect");
		world = bound.init(world);
		return world;
	}
	
	//update and render any objects you need here
	//you have to return world
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

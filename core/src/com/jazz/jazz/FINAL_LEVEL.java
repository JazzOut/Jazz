package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class FINAL_LEVEL extends Level {

	public FINAL_LEVEL(){
		super();
	}
	
	//add any new levels to Levels.java enum
	
	
	//make sure to implement create
	//instantiate any objects you need here.
	public World create(World world){

		int columnCount = 12;
		int rowCount = 12;
		Block block;
		Vector2 pos = new Vector2();
		int skip = 1;
		for(int i = 0; i < 2; i++){
			for (int j = 0; j < 20; j++){
				block = Levels.squareBlockPool.obtain();
				world = ((StandardBlock) block).init(world,
					pos.set(i * 13 + 80, j * 9 + 10));
				block.updateModel();
				activeBlocks.add(block);
				block = Levels.squareBlockPool.obtain();
				world = ((StandardBlock) block).init(world,
					pos.set(i * 13 + 275, j * 9 + 10));
				block.updateModel();
				activeBlocks.add(block);
			}
		}
		for (int i = 0; i < columnCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				if((j < 6 && i >= 6) || (j >= 6 && i < 6)) {
					if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
						block = Levels.hardBlockPool.obtain();
						world = ((StandardBlock) block).init(world,
							pos.set(i * 14 + 108, j * 15 + 15));
						block.rotate(45);
						block.updateModel();
						activeBlocks.add(block);
					}else {
						block = Levels.standardBlockPool.obtain();
						world = ((StandardBlock) block).init(world,
							pos.set(i * 14 + 108, j * 15 + 15));
						block.rotate(45);
						block.updateModel();
						activeBlocks.add(block);
					}
				}else{
					if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
						block = Levels.hardBlockPool.obtain();
						world = ((StandardBlock) block).init(world,
							pos.set(i * 14 + 108, j * 15 + 15));
						block.rotate(135);
						block.updateModel();
						activeBlocks.add(block);
					}else {
						block = Levels.standardBlockPool.obtain();
						world = ((StandardBlock) block).init(world,
							pos.set(i * 14 + 108, j * 15 + 15));
						block.rotate(135);
						block.updateModel();
						activeBlocks.add(block);
					}
				}
			}
		}
	
		balls = new Array<Ball>();
		StandardBall ball = Levels.standardBallPool.obtain();
		ball.init(world, new Vector2(10, 50), new Vector2(2, 0));
		ball.updateModel();
		balls.add(ball);
		
		bound = new Boundaries("std_rect");
		world = bound.init(world);
		return world;
	}
	
//if you want to do sometghing fancy overwrite render
	
}

package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Level_2 extends Level {

	public Level_2(){
		super();
	}
	
	//add any new levels to Levels.java enum
	
	
	//make sure to implement create
	//instantiate any objects you need here.
	public World create(World world){

		int rowCount = 12;
		int columCount = 12;
		Block block;
		Vector2 pos = new Vector2();
		
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 0 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 0 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
//		block = Levels.standardBlockPool.obtain();
//		world = ((StandardBlock) block).init(world,
//				pos.set(6 * 13 + 100, 0 * 14 + 10));
//		block.rotate(90);
//		block.updateModel();
//		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 2 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 1 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 4 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 1 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 2 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 13 + 100, 2 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 2 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 13 + 100, 3 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(4 * 13 + 100, 3 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 4 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 1 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 5 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(9 * 13 + 100, 4 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 13 + 100, 6 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(11 * 13 + 100, 6 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 7 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(10 * 13 + 100, 5 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(10 * 13 + 100,7 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 8 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 8 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(9 * 13 + 100, 8 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 13 + 100, 9 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(4 * 13 + 100, 9 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 10 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 11 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 10 * 14 + 10));
		block.rotate(135);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 13 + 100, 10 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 10 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 11 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
//		block = Levels.standardBlockPool.obtain();
//		world = ((StandardBlock) block).init(world,
//				pos.set(6 * 13 + 100, 12 * 14 + 10));
//		block.rotate(90);
//		block.updateModel();
//		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 12 * 14 + 10));
		block.rotate(45);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 11 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 13 + 100, 12 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 1 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.standardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 13 + 100, 11 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 10 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 13 + 100, 8 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 13 + 100, 2 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 13 + 100, 4 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 10 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 11 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 10 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 9 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 3 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 13 + 100, 2 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 2 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 13 + 100, 1 * 14 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		
		for(int i = 4; i < 8; i++){
			for(int j = 4; j < 9; j++){
				block = Levels.hardBlockPool.obtain();
				world = ((StandardBlock) block).init(world,
						pos.set(i * 13 + 100, j * 14 + 10));
				block.rotate(90);
				block.updateModel();
				activeBlocks.add(block);
			}
		}
/*		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.hardBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(i * 10 + 100, j * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
*/		
		
		
	
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

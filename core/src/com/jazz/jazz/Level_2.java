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
		
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 0 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 10 + 100, 0 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 10 + 100, 0 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 10 + 100, 2 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 10 + 100, 1 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 1 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 10 + 100, 2 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 10 + 100, 2 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 10 + 100, 2 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 2 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 10 + 100, 3 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 10 + 100, 3 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(4 * 10 + 100, 3 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 3 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 10 + 100, 4 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 1 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(9 * 10 + 100, 4 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 10 + 100, 5 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(10 * 10 + 100, 5 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(11 * 10 + 100, 5 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 10 + 100, 6 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(12 * 10 + 100, 6 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 10 + 100, 7 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(10 * 10 + 100, 5 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(11 * 10 + 100, 5 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 10 + 100, 8 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 8 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(9 * 10 + 100, 7 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 10 + 100, 9 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(3 * 10 + 100, 9 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(4 * 10 + 100, 9 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 9 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(0 * 10 + 100, 10 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(1 * 10 + 100, 10 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(2 * 10 + 100, 10 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(5 * 10 + 100, 10 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 10 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 10 + 100, 11 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 11 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(6 * 10 + 100, 11 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(7 * 10 + 100, 11 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
		block = Levels.squareBlockPool.obtain();
		world = ((StandardBlock) block).init(world,
				pos.set(8 * 10 + 100, 11 * 15 + 10));
		block.rotate(90);
		block.updateModel();
		activeBlocks.add(block);
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
		ball.init(world, new Vector2(10, 50), new Vector2(2, 1));
		ball.updateModel();
		balls.add(ball);
		
		bound = new Boundaries("std_rect");
		world = bound.init(world);
		return world;
	}
	
//if you want to do sometghing fancy overwrite render
	
}
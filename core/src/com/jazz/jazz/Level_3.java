package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Level_3 extends Level {

	public Level_3(){
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
		int skip = 2;
		int[] startSkip = {3,4,5,6,6,5,4,4,5,6,7,7,8,7,7}; 
		for (int i = 0; i < columnCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				if(j<startSkip[i] || j>(startSkip[i]+skip)) {
					block = Levels.standardBlockPool.obtain();
					world = ((StandardBlock) block).init(world,
					pos.set(i * 15 + 100, j * 15 + 10));

					block.updateModel();
					activeBlocks.add(block);
				}
//				else{
//					block = Levels.hardBlockPool.obtain();
//					world = ((HardBlock) block).init(world,
//							pos.set(i * 10 + 100, j * 15 + 10));
//				}

				
			}
		}
	
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

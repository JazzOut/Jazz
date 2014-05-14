package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Level_4 extends Level {

	public Level_4(){
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
		//int[] startSkip = {3,4,5,6,6,5,4,4,5,6,7,8,8,7,6}; 
		for (int i = 0; i < columnCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				if((i%4==0)||(i%4==1)||(i%4==2)) {
					if((j%4==0)||(j%4==1)||(j%4==2)) {
						if(i<=3){
							block = Levels.squareBlockPool.obtain();
							world = ((StandardBlock) block).init(world,
									pos.set(i * 15 + 110, j * 15 + 20));
							block.updateModel();
							activeBlocks.add(block);
						}
						else if (i>3&&i<7){
							block = Levels.standardBlockPool.obtain();
							world = ((StandardBlock) block).init(world,
									pos.set(i * 15 + 110, j * 15 + 20));
							block.updateModel();
							activeBlocks.add(block);
						}
						else{
							block = Levels.hardBlockPool.obtain();
							world = ((StandardBlock) block).init(world,
									pos.set(i * 15 + 110, j * 15 + 20));
							block.updateModel();
							activeBlocks.add(block);
						}
					}
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
		ball.init(world, new Vector2(10, 50), new Vector2(2, 0));
		ball.updateModel();
		balls.add(ball);
		
		bound = new Boundaries("std_rect");
		world = bound.init(world);
		return world;
	}
	
//if you want to do sometghing fancy overwrite render
	
}

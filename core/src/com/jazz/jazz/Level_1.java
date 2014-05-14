package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

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
		float tmp = 0;
		for (int j = 0; j < columCount; j++) {
			for (int i = 0; i < rowCount; i++) {
				tmp = rnd.nextFloat();
				if(tmp < .1){
					block = Levels.standardBlockPool.obtain();
					world = ((StandardBlock) block).init(world,
							pos.set(i * 10 + 100, j * 15 + 10));
				}else if(tmp > .1 && tmp < .7){
					block = Levels.squareBlockPool.obtain();
					world = ((SquareBlock) block).init(world,
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

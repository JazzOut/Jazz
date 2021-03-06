package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public abstract class Level {

	protected final Array<Block> activeBlocks = new Array<Block>();
	protected Boundaries bound;
	protected Array<Ball> balls;
	protected Array<Crystal> crystals = new Array<Crystal>();
	protected boolean levelOver = false;
	protected boolean ballsDead = false;
	public static Sound crystalCollect= Gdx.audio.newSound(Gdx.files.internal("data/Blop.mp3"));
	
	public Level(){
		
	}
	
	//public abstract World render(ModelBatch modelBatch, World world, Environment environment);
	
	public abstract World create(World world);
	
	public World update(World world, Paddle paddle, boolean unlock){
	
		if(balls.size != 0){
			Ball b;
			for(int i = 0; i < balls.size; i++){
				b = balls.get(i);
				if(unlock){
					b.unlock();
				}
				if(b.isLockedToPaddle){
					b.setPosition(paddle.getBody().getPosition().x + 10, paddle.getBody().getPosition().y );
				}
				if(!b.isAlive){
					balls.removeIndex(i);
					world.destroyBody(b.body);
					if(b instanceof StandardBall){
						Levels.standardBallPool.free((StandardBall) b);
					}
					i--;
				}else{
					if(paddle.getAction() == 1){
						applyPush(paddle, b.body);
					}else if(paddle.getAction() == -1){
						applyPull(paddle, b.body);
					}
					b.update();
				}
			}
		}else{
			ballsDead = true;
		}
		
		if(activeBlocks.size != 0){
		
			Block block;
			for (int i = 0; i < activeBlocks.size; i++) {
				block = activeBlocks.get(i);
				if (!block.isAlive) {
					activeBlocks.removeIndex(i);
					int add = block.getCrystalsDroppedAmt();
					Crystal c;
					Random rnd = new Random();
					for(int o = 0; o < add; o++){
						c = Crystal.crystalPool.obtain();
						c.init(world, block.getBody().getPosition().add(rnd.nextFloat()/64, rnd.nextFloat()/64));
						c.body.setLinearVelocity(rnd.nextFloat()*100-50, rnd.nextFloat()*100-50);
						crystals.add(c);
					}
					world.destroyBody(block.getBody());
					if(block instanceof HardBlock){
						Levels.hardBlockPool.free((HardBlock) block);
					}else if(block instanceof SquareBlock){
						Levels.squareBlockPool.free((SquareBlock) block);
					}else if(block instanceof StandardBlock){
						Levels.standardBlockPool.free((StandardBlock) block);
					}
					i--;
				} else {
					//block.updateModel();
				}
			}
		}else{
			levelOver = true;
		}
		
		if(crystals.size != 0){
			Crystal c;
			for(int i = 0; i < crystals.size; i++){
				c = crystals.get(i);
				if(!c.isAlive){
					crystals.removeIndex(i);
					if(c.collected){
						paddle.score +=85;
						crystalCollect.setVolume(crystalCollect.play(), .5f);
					}
					world.destroyBody(c.body);
					Crystal.crystalPool.free(c);
					i--;
				}else{
					if(paddle.getAction() == 1){
						applyPush(paddle, c.body);
					}else if(paddle.getAction() == -1){
						applyPull(paddle, c.body);
					}
				}
			}
		}

		
		return world;
	}
	
	public World render(ModelBatch modelBatch, World world, Environment environment){
		//balls = new Array<Ball>();

		
		bound.render(modelBatch, environment);
		
		if(balls.size != 0){
			Ball b;
			for(int i = 0; i < balls.size; i++){
				b = balls.get(i);	
				b.updateModel();
				modelBatch.render(b.getModInst(), environment);
			}
		}
		

		if(activeBlocks.size !=0){
			Block block;
			for (int i = 0; i < activeBlocks.size; i++) {
				
				block = activeBlocks.get(i);
				block.updateModel();
				modelBatch.render(block.getModInst(), environment);
			}
		}
	
		Crystal crystal;
		for(int i= 0; i < crystals.size; i++){
			crystal = crystals.get(i);
			crystal.updateModel();
			modelBatch.render(crystal.getModInst(), environment);
		}
	
		
		return world;
	}
	
	public float getTopLeftY(){
		return bound.topLeftY;
	}
	
	private void applyPull(Paddle paddle, Body body){	
		body.applyForceToCenter(calcForce(paddle, body), true);
	}
	
	private void applyPush(Paddle paddle, Body body){	
		body.applyForceToCenter(calcForce(paddle, body).scl(-1), true);
	}
	
	private Vector2 calcForce(Paddle paddle, Body body){
		Vector2 dir = paddle.getBody().getPosition().sub(body.getPosition());
		float distanceToCenter = dir.len();
		dir = dir.nor();
		float forceMagnitude = 200 ;
		body.applyForceToCenter(dir.scl(forceMagnitude), true);
		return dir.scl(forceMagnitude);
	}
	
	public void destroy(World world){
		Block block;
		while(activeBlocks.size !=0){
				block = activeBlocks.get(0);
				activeBlocks.removeIndex(0);
				world.destroyBody(block.getBody());
				if(block instanceof HardBlock){
					Levels.hardBlockPool.free((HardBlock) block);
				}else if(block instanceof SquareBlock){
					Levels.squareBlockPool.free((SquareBlock) block);
				}else if(block instanceof StandardBlock){
					Levels.standardBlockPool.free((StandardBlock) block);
				}
		}
		
		Crystal c;
		while(crystals.size != 0){
			c = crystals.get(0);
			crystals.removeIndex(0);
			world.destroyBody(c.body);
			Crystal.crystalPool.free(c);
		}
		
		Ball b;
		while(balls.size != 0){
			b = balls.get(0);
			balls.removeIndex(0);
			world.destroyBody(b.body);
			if(b instanceof StandardBall){
				Levels.standardBallPool.free((StandardBall) b);
			}
		
		}
		bound = null;
		
		levelOver = false;
		ballsDead = false;
		
	}
	
	
	
}

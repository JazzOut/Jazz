package com.jazz.jazz;

import com.badlogic.gdx.utils.Pool;

public enum Levels {
	
	LEVEL_1(new Level_1());

	private Level level;
	
	private Levels(Level level){
		this.level = level;
	}
	
	public static final Pool<StandardBlock> standardBlockPool = new Pool<StandardBlock>() {
		@Override
		protected StandardBlock newObject() {
			return new StandardBlock();
		}
	};
	
	public static final Pool<HardBlock> hardBlockPool = new Pool<HardBlock>() {
		@Override
		protected HardBlock newObject() {
			return new HardBlock();
		}
	};
	
	
	public Level getLevel(){
		return level;
	}
	

}

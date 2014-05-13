package com.jazz.jazz;

import com.badlogic.gdx.utils.Pool;

public enum Levels {
	
	LEVEL_1();

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
	
	

}

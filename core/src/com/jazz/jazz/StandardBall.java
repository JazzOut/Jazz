package com.jazz.jazz;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class StandardBall extends Ball {

	public StandardBall() {
		super();
	}

	public World init(World world, Vector2 pos) {

		super.init(world, new ModelInstance(BlockTypes.SMALL_CIRCLE.getCopy()),
				BlockTypes.SMALL_CIRCLE.getBodyType(),
				BlockTypes.SMALL_CIRCLE.getFixtureDef(), pos);

		return world;
	}
}

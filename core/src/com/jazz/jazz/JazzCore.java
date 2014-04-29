package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class JazzCore extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Body body;
	World world;
	PerspectiveCamera camera;
	Box2DDebugRenderer render;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		camera = new PerspectiveCamera();
		camera.viewportWidth = 100;
		camera.viewportHeight = 80;
		camera.fieldOfView = 67;
		camera.far = 10000f;
		camera.near = 1f;
		//render = new Box2DDebugRenderer();
		camera.update();
		
		world = new World(new Vector2(0,-10), true);
		
		BodyDef def = new BodyDef();
		def.position.set(new Vector2(0,0));
		def.type = BodyType.DynamicBody;
		
		//body = world.createBody(def);
		FixtureDef fix = new FixtureDef();
		fix.density = 10f;
		fix.restitution = .1f;
		fix.friction = 0f;
		
		CircleShape circ = new CircleShape();
		circ.setRadius(10f);
		fix.shape = circ;
		
		//body.createFixture(fix);
		PolygonShape box = new PolygonShape();
		Random rnd = new Random();
		int i;
		for(i = 0; i < 1000; i++){
			def.position.set(new Vector2(rnd.nextFloat()*5,2f*i));
			//circ.setRadius(rnd.nextFloat());
			box.setAsBox((1+rnd.nextFloat()*5)/1f, (1+rnd.nextFloat()*0)/1f);
			fix.shape = box;
			world.createBody(def).createFixture(fix);
		}
		
		fix.shape = circ;
		fix.density =500f;
		fix.restitution = 0f;
		def.position.set(0, 2f*i + 100);
		world.createBody(def).createFixture(fix);
		
		def.type = BodyType.StaticBody;
		def.position.set(new Vector2(0,-40));
		//PolygonShape box = new PolygonShape();
		box.setAsBox(100, 10);
		fix.shape = box;
		fix.restitution = 0;
		
		world.createBody(def).createFixture(fix);
		//def.position.set(0, 40);
		//world.createBody(def).createFixture(fix);
		box.setAsBox(2, 10000);
		def.position.set(40, 0);
		world.createBody(def).createFixture(fix);
		def.position.set(-40, 0);
		world.createBody(def).createFixture(fix);
		
		render = new Box2DDebugRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		//body.applyLinearImpulse(1, 1, 0, 0, true);
		Array<Body> bodies = new Array<Body>();
		world.getBodies(bodies);
		Random rnd = new Random();
		for(int i = 0; i< bodies.size; i++){
			//bodies.get(i).applyLinearImpulse(-1*rnd.nextFloat(),-1*rnd.nextFloat(),0, 0, true);
			//bodies.get(i).applyForce(-1*rnd.nextFloat(),-1*rnd.nextFloat(),1, 0, true);
		}
		
		world.step(1/60f, 5, 2);
		
		
		render.render(world, camera.combined);
		
		//test test
	}
}

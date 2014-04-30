package com.jazz.jazz;

//github.com/JazzOut/Jazz.git
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
	public PerspectiveCamera cam;
	//public OrthographicCamera cam;
	public CameraInputController camController;
	public Environment environment;
	public ModelBatch modelBatch;
	public Model model;
	public Model sphere;
	public ModelInstance instance;
	public ModelInstance sphereInst;
	public Box2DDebugRenderer render;
	public World world;
	public DirectionalLight light;
	
	@Override
	public void create () {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, .4f, .4f, .4f, 1f));
		light = new DirectionalLight().set(.8f,.8f,.8f,-1f,-.8f,-.2f);
		environment.add(light);
		//environment.add(new DirectionalLight().set(.8f,.8f,.8f,-1f,-.8f,-.2f));
		
		
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0f,100f,400f);
		//cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 5000f;
		cam.update();
		
		camController = new CameraInputController(cam);
		camController.scrollFactor = -10;
		Gdx.input.setInputProcessor(camController);
		Body body;
		ModelBuilder modelBuilder = new ModelBuilder();
		sphere = modelBuilder.createSphere(20f, 20f, 20f, 20, 20, 
				new Material(ColorAttribute.createDiffuse(Color.GREEN)), 
						Usage.Position | Usage.Normal, 
						0f, 360f, 0f, 360f);
		model = modelBuilder.createBox(5f, 5f, 100f,
				new Material(ColorAttribute.createDiffuse(Color.GREEN)), 
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
		sphereInst = new ModelInstance(sphere);
		
		world = new World(new Vector2(0,-10), true);
		
		BodyDef def = new BodyDef();
		def.position.set(new Vector2(0,0));
		def.type = BodyType.DynamicBody;
		
		
		//body = world.createBody(def);
		FixtureDef fix = new FixtureDef();
		fix.density = 10f;
		fix.restitution = 0f;
		fix.friction = 1f;
		
		CircleShape circ = new CircleShape();
		circ.setRadius(10f);
		fix.shape = circ;
		
		//body.createFixture(fix);
		PolygonShape box = new PolygonShape();
		Random rnd = new Random();
		int i = 0;
		for(i = 0; i < 2500; i++){
			def.position.set(new Vector2(rnd.nextInt(120-5-2)-60+2,2f*i));
			//circ.setRadius(2.5f);
			box.setAsBox((2.5f+rnd.nextFloat()*0)/1f, (2.5f+rnd.nextFloat()*0)/1f);
			fix.shape = box;
			body = world.createBody(def);
			body.createFixture(fix);
			body.setUserData(instance);
		}
		
		fix.shape = circ;
		fix.density =50000f;
		fix.restitution = 0f;
		def.position.set(0, 2f*i + 100);
		body = world.createBody(def);
		body.createFixture(fix);
		body.setUserData(sphereInst);
		
		
		def.type = BodyType.StaticBody;
		def.position.set(new Vector2(0,-40));
		//PolygonShape box = new PolygonShape();
		box.setAsBox(100, 10);
		fix.shape = box;
		fix.restitution = 0;
		
		body = world.createBody(def);
		body.createFixture(fix);
		body.setUserData(instance);
		//def.position.set(0, 40);
		//world.createBody(def).createFixture(fix);
		box.setAsBox(2, 10000);
		def.angle = -10;
		def.position.set(60, 0);
		body = world.createBody(def);
		body.createFixture(fix);
		body.setUserData(instance);
		def.angle = 10;
		def.position.set(-60, 0);
		body = world.createBody(def);
		body.createFixture(fix);
		body.setUserData(instance);
		
		
		render = new Box2DDebugRenderer();
	}

	@Override
	public void render () {
		camController.update();
		//light.set(.8f,.8f,.8f,cam.direction.x,cam.direction.y,cam.direction.z);

		//Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		//Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
		world.step(1/60f, 5, 2);
		Array<Body> bodies = new Array<Body>(); 
		world.getBodies(bodies);
		Vector3 pos = new Vector3();
		Vector2 pos2D = new Vector2();
		modelBatch.begin(cam);
		int i=0;

		ModelInstance tmp;
		for(i = 0; i<bodies.size; i++){
			pos2D = bodies.get(i).getPosition();

			//bodies.get(i).applyForceToCenter(force.x,force.y,true);
			pos.x = pos2D.x;
			pos.y = pos2D.y;
			pos.z = 0;
			tmp = (ModelInstance) bodies.get(i).getUserData();
			//instance.transform.setToRotation(new Vector3(0,0,1), bodies.get(i).getAngle() * MathUtils.radiansToDegrees).setToTranslation(pos);
			if(tmp != null){
				tmp.transform.setToTranslation(pos).rotate(new Vector3(0,0,1), bodies.get(i).getAngle() * MathUtils.radiansToDegrees);
				modelBatch.render(tmp, environment);
			}
		}

		modelBatch.end();
		render.render(world, cam.combined);
		
		//instance.transform.rotate(new Vector3(0,0,1), 1f);

	//	instance.transform.setToTranslation(new Vector3(10,0,0));
		
		

		
		
	}
	
	@Override
	public void dispose(){
		modelBatch.dispose();
		model.dispose();
		sphere.dispose();
	}
}

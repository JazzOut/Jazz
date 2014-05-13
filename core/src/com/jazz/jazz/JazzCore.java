package com.jazz.jazz;

//github.com/JazzOut/Jazz.git
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class JazzCore extends ApplicationAdapter {

	public static Vector3 threeD = new Vector3(0, 0, 0);
	public static final Vector3 axis = new Vector3(0, 0, 1);
	public static final Vector2 tmp = new Vector2(0, 0);
	private final Array<Block> activeBlocks = new Array<Block>();


	public PerspectiveCamera cam;
	// public OrthographicCamera cam;
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
	public Boundaries bound;
	private StandardBall ball;
	Array<Level> levels;
	private int currLevel;

	@Override
	public void create() {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, .4f,
				.4f, .4f, 1f));
		light = new DirectionalLight().set(.8f, .8f, .8f, -1f, -.8f, -.5f);
		environment.add(light);
		// environment.add(new
		// DirectionalLight().set(.8f,.8f,.8f,-1f,-.8f,-.2f));

		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		// cam = new OrthographicCamera(Gdx.graphics.getWidth(),
		// Gdx.graphics.getHeight());
		cam.position.set(0f, 100f, 400f);
		// cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 5000f;
		cam.update();

		camController = new CameraInputController(cam);
		camController.scrollFactor = -10;
		Gdx.input.setInputProcessor(camController);
		levels = new Array<Level>();
		Levels[] levs = Levels.values();
		for(Levels l : levs){
			levels.add(l.getLevel());
		}
		currLevel = 0;
		
		// Body body;
		// ModelBuilder modelBuilder = new ModelBuilder();

		// need a body for 2d
		// modelbuilder for the models till we get blender
		// create the model using the modelbuilder
		// set the model into an instance
		//
		// so modelbuilder -<builds>> model -<goesin>> instance -<goes in body>>
		// userdata
		//
		// need bodydefinition for body
		// set body position, type
		// need fixture for body
		// set fixture with density, restitution, and friction
		// create shape for the fixture
		// set the shape
		// create body using world.createbody
		// set 3d modelinstance to body using setuserdata

		// model example
		// model = modelBuilder.createBox(5f, 5f, 5f,
		// new Material(ColorAttribute.createDiffuse(Color.GREEN)),
		// Usage.Position | Usage.Normal);
		// instance = new ModelInstance(model);

		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new GameCollision());

//		int rowCount = 10;
//		int columCount = 12;
//		
//		Block block;
//		Random rnd = new Random();
//		Vector2 pos = new Vector2();
//		for (int j = 0; j < columCount; j++) {
//			for (int i = 0; i < rowCount; i++) {
//				if(rnd.nextFloat() < .5){
//					block = Levels.standardBlockPool.obtain();
//					world = ((StandardBlock) block).init(world,
//							pos.set(i * 10 + 100, j * 15 + 10));
//				}else{
//					block = Levels.hardBlockPool.obtain();
//					world = ((HardBlock) block).init(world,
//							pos.set(i * 10 + 100, j * 15 + 10));
//				}
//				block.rotate(90);
//				block.updateModel();
//				activeBlocks.add(block);
//			}
//		}
//
//		ball = new StandardBall();
//		ball.init(world, new Vector2(0, 0), new Vector2(2, 10));
//		ball.updateModel();
//
//		bound = new Boundaries("std_rect");
//		world = bound.init(world);

		for(Level l : levels){
			l.create(world);
		}
		
		render = new Box2DDebugRenderer();
	}

	@Override
	public void render() {
		camController.update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);


		world.step(1 / 60f, 5, 2);
		modelBatch.begin(cam);
			levels.get(currLevel).render(modelBatch, world, environment);
		modelBatch.end();
		//render.render(world, cam.combined);
		
	}

	public static Vector3 get3D(Vector2 twoD) {
		return threeD.set(twoD.x, twoD.y, 0);

	}

	@Override
	public void dispose() {
		modelBatch.dispose();
	}
}

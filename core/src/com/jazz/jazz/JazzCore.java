package com.jazz.jazz;

//github.com/JazzOut/Jazz.git
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.badlogic.gdx.math.collision.Ray;
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
	Array<Level> levels;
	private int currLevel;
	Array<StarLayer> stars;
	Paddle paddle;
	
	private float lastY;

	
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
		cam.position.set(150f, 100f, 400f);
		
		// cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 5000f;
		cam.update();

		camController = new CameraInputController(cam);
		camController.scrollFactor = -5;
		Gdx.input.setCursorCatched(true);
		Gdx.input.setCursorPosition(0,0);
		//Gdx.input.setInputProcessor(camController);
		levels = new Array<Level>();
		Levels[] levs = Levels.values();
		for(Levels l : levs){
			levels.add(l.getLevel());
		}
		currLevel = 1;

		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new GameCollision());

		levels.get(currLevel).create(world);
		
		stars = new Array<StarLayer>();
		StarLayer starL;
		for(int i = 0; i<10; i++){
			starL = new StarLayer();
			starL.init(600, -500-100*i, 100);
			stars.add(starL);
		}
		
		paddle = new Paddle();
		paddle.init(world, new Vector2(10,100), -100,100 );
		lastY = Gdx.input.getY();
		
		render = new Box2DDebugRenderer();
	}

	@Override
	public void render() {
		camController.update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		threeD.set(0,Gdx.input.getY() , 0);
		cam.project(threeD);
		
		if(lastY != Gdx.input.getY()){
			paddle.getBody().setLinearDamping(0);
			paddle.mouseY(Gdx.input.getY());
			Gdx.input.setCursorPosition(0, 0);
			lastY = Gdx.input.getY();
		}
		else{
			paddle.getBody().setLinearDamping(1000000);
		}

		boolean unlock = false;
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			unlock = true;
			paddle.setPull();
		}else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
			paddle.setPush();
		}else{
			paddle.setOff();
		}
		
		levels.get(currLevel).update(world, paddle, unlock);

		world.step(1 / 60f, 5, 2);
		
		modelBatch.begin(cam);
			levels.get(currLevel).render(modelBatch, world, environment);
			for(StarLayer s : stars){
				s.render(modelBatch, environment);
			
			}
			paddle.updateModel();
			modelBatch.render(paddle.getModInst(), environment);
		modelBatch.end();
		render.render(world, cam.combined);
		
	}

	public static Vector3 get3D(Vector2 twoD) {
		return threeD.set(twoD.x, twoD.y, 0);

	}

	@Override
	public void dispose() {
		modelBatch.dispose();
		Star.model.dispose();
	}
}

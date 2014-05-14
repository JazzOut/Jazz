package com.jazz.jazz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jazz.jazz.screens.PauseMenu;

public class JazzGame implements Screen{
	public static PauseMenu pauseMenu = new PauseMenu();
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
	float time;
	Music clearSideVirus;

	private boolean pushingS;
	private boolean pushingD;
	private BitmapFont font;
	private SpriteBatch textBatch;
	
	private float lastY;

	public JazzGame(){
		create();
	}
	
	
	public void create() {
		time = 0;
		pushingS = false;
		pushingD = false;
		font = new BitmapFont();
		textBatch = new SpriteBatch();
		
		
		//song is Virus by Clearside. https://soundcloud.com/clearside/clearside-virus
		//liscened under creative commons, attribution non-comercial
		clearSideVirus = Gdx.audio.newMusic(Gdx.files.internal("data/ClearsideVirus.mp3")); 
		clearSideVirus.setLooping(true);
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, .4f,
				.4f, .4f, 1f));
		light = new DirectionalLight().set(.8f, .8f, .8f, -1f, -.8f, -.5f);
		environment.add(light);
		// environment.add(new
		// DirectionalLight().set(.8f,.8f,.8f,-1f,-.8f,-.2f));

		modelBatch = new ModelBatch();

//		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
//				Gdx.graphics.getHeight());
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		// cam = new OrthographicCamera(Gdx.graphics.getWidth(),
		// Gdx.graphics.getHeight());
		cam.position.set(150f, 100f, 400f);
		
		//cam.lookAt(150,0,0);
		cam.near = 1f;
		cam.far = 5000f;
		cam.update();

		camController = new CameraInputController(cam);
		camController.scrollFactor = -5;
		Gdx.input.setCursorCatched(true);
		//Gdx.input.setCursorPosition(0,0);
		//Gdx.input.setInputProcessor(camController);
		levels = new Array<Level>();
		Levels[] levs = Levels.values();
		for(Levels l : levs){
			levels.add(l.getLevel());
		}
		currLevel = 0;

		world = new World(new Vector2(0, 0), true);
		world.setContactListener(new GameCollision());

		levels.get(currLevel).create(world);
		
		stars = new Array<StarLayer>();
		StarLayer starL;
		for(int i = 0; i<6; i++){
			starL = new StarLayer();
			starL.init(600, -500-100*i, 100);
			stars.add(starL);
		}
		
		paddle = new Paddle();
		paddle.init(world, new Vector2(0,100), -100,100 );
		lastY = Gdx.input.getY();
		
		render = new Box2DDebugRenderer();
	}

	@Override
	public void render(float delta) {

		if (Gdx.input.isKeyPressed(Input.Keys.P)){
			pause();
			
		}else if(Gdx.input.isKeyPressed(Input.Keys.S) && !pushingS){
			pushingS = true;
			
			levels.get(currLevel).destroy(world);
			currLevel++;
			if(currLevel > levels.size-1){
				currLevel = levels.size -1;
			}
			levels.get(currLevel).create(world);
			time = 0;
		}else if(!Gdx.input.isKeyPressed(Input.Keys.S) && pushingS){
			pushingS = false;
		}else if(Gdx.input.isKeyPressed(Input.Keys.D) && !pushingD){
			pushingD = true;
			
			levels.get(currLevel).destroy(world);
			currLevel--;
			if(currLevel < 0){
				currLevel = 0;
			}
			levels.get(currLevel).create(world);
			time = 0;
		}else if(!Gdx.input.isKeyPressed(Input.Keys.D) && pushingD){
			pushingD = false;
		}
		camController.update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		
		if(lastY != Gdx.input.getY()){
			paddle.getBody().setLinearDamping(0);
			paddle.mouseY(Gdx.input.getY());
			Gdx.input.setCursorPosition(0,0);
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

		world.step(1 / 60f, 8, 2);
		
		modelBatch.begin(cam);
			levels.get(currLevel).render(modelBatch, world, environment);
			for(StarLayer s : stars){
				s.render(modelBatch, environment);
			
			}
			paddle.updateModel();
			textBatch.begin();
			if(levels.get(currLevel).ballsDead){
				font.draw(textBatch, "You lost, new level in "+ Integer.toString(3-(int)time) +" seconds!", 210, 15);
			}else if(levels.get(currLevel).levelOver){
				font.draw(textBatch, "Good Job, new level in "+ Integer.toString(3-(int)time) +" seconds!", 210, 15);
			}
			font.draw(textBatch, Integer.toString((int)paddle.score), 10, 15);
			textBatch.end();
			modelBatch.render(paddle.getModInst(), environment);
		modelBatch.end();
		if(levels.get(currLevel).levelOver || levels.get(currLevel).ballsDead){
			time +=delta;
			System.out.println(delta);
			if(time > 3){
				levels.get(currLevel).destroy(world);
				currLevel++;
				if(currLevel > levels.size-1){
					currLevel = levels.size -1;
				}
				levels.get(currLevel).create(world);
				time = 0;
				
			}
		}
		//render.render(world, cam.combined);
		
	}



	public static Vector3 get3D(Vector2 twoD) {
		return threeD.set(twoD.x, twoD.y, 0);

	}

	@Override
	public void dispose() {
		modelBatch.dispose();
		Star.model.dispose();
		Crystal.crystalModel.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setCursorCatched(true);
		clearSideVirus.play();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		clearSideVirus.pause();
		((Game) Gdx.app.getApplicationListener()).setScreen(pauseMenu);
	}

	public void resume() {
		clearSideVirus.play();
		Gdx.input.setCursorCatched(true);
		
	}

}

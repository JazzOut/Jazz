package com.jazz.jazz;


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
import com.badlogic.gdx.math.Vector3;

public class JazzCore extends ApplicationAdapter {
	public PerspectiveCamera cam;
	//public OrthographicCamera cam;
	public CameraInputController camController;
	public Environment environment;
	public ModelBatch modelBatch;
	public Model model;
	public ModelInstance instance;
	
	
	@Override
	public void create () {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, .4f, .4f, .4f, 1f));
		environment.add(new DirectionalLight().set(.8f,.8f,.8f,-1f,-.8f,-.2f));
		
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0f,0f,50f);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		
		camController = new CameraInputController(cam);
		
		Gdx.input.setInputProcessor(camController);
		
		ModelBuilder modelBuilder = new ModelBuilder();
		//model = modelBuilder.createSphere(5, 5, 5, 20, 20, 
			//	new Material(ColorAttribute.createDiffuse(Color.GREEN)), 
				//		Usage.Position | Usage.Normal, 
					//	0f, 360f, 0f, 360f);
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.GREEN)), 
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
	}

	@Override
	public void render () {
		camController.update();

		//Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		instance.transform.rotate(new Vector3(0,0,1), 1f);

		instance.transform.setToTranslation(new Vector3(10,0,0));
		
		
		modelBatch.begin(cam);
		modelBatch.render(instance, environment);
		modelBatch.end();
	}
	
	@Override
	public void dispose(){
		modelBatch.dispose();
		model.dispose();
	}
}

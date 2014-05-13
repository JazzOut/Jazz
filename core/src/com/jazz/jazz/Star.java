package com.jazz.jazz;

import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Star implements Poolable{

	public static final Pool<Star> starPool = new Pool<Star>() {
		@Override
		protected Star newObject() {
			return new Star();
		}
	};
	
	private ModelInstance modInst;
	static Model model = null;
	protected Vector2 direction;
	protected float z;
	
	
	public Star(){
		reset();
	}

	public void init(float x, float y, float z, Vector2 direction){
		if(model == null){
			model = new ModelBuilder().createSphere(2, 2, 2, 19, 19, new Material(), Usage.Normal | Usage.Position, 0, 360, 0, 360);
		}
		modInst = new ModelInstance(model);
		this.z = z;
		setPosition(x,y);
		this.direction = direction;
	}
	

	public void move(Vector2 dir){
		modInst.transform.translate(dir.x+direction.x, dir.y+direction.y, 0);
	}
	public void setPosition(Vector2 pos){
		setPosition(pos.x, pos.y);
	}
	
	public void setPosition(float x, float y){
		modInst.transform.setToTranslation(x, y, z);
	}
	
	public ModelInstance getModInst(){
		return modInst;
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		modInst = null;
	}
	
	
	
}

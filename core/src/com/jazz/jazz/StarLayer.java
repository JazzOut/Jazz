package com.jazz.jazz;

import java.util.Random;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class StarLayer {

	
	protected Array<Star> stars;
	protected Vector2 direction;
	float x, y, z;
	float w, h, d;
	
	public StarLayer(){
		
	}
	
	public void init(int starCount, float z, float d){
		init(starCount, -1000+150, -1000+100, z, 2000, 2000, d);
	}
	
	public void init(int starCount, float x, float y, float z, float w, float h, float d){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;
		this.d = d;
		stars = new Array<Star>();
		Star star;
		Random rnd = new Random();
		
		for(int i = 0; i<starCount; i++){
			star = Star.starPool.obtain();
			star.init(rnd.nextFloat()*w + x, rnd.nextFloat()*h + y, rnd.nextFloat()*d + z, new Vector2());
			stars.add(star);
		}
		
		direction = new Vector2(rnd.nextFloat()/(z/d), rnd.nextFloat()/(z/d));
	}
	
	public void render(ModelBatch batch, Environment env){
		for(Star s : stars){
			s.move(direction);
			s.getModInst().transform.getTranslation(JazzGame.threeD);
			if(JazzGame.threeD.x > x+w){
				s.move(new Vector2(-w, 0));
			}else if(JazzGame.threeD.x < x){
				s.move(new Vector2(w, 0));
			}
			
			if(JazzGame.threeD.y > y+w){
				s.move(new Vector2(0, -h));
			}else if(JazzGame.threeD.y < y){
				s.move(new Vector2(0, h));
			}
			
			batch.render(s.getModInst(), env);
		}
	}
	
	
	
	
	
	
}

package com.jazz.jazz;

//github.com/JazzOut/Jazz.git
import com.badlogic.gdx.Game;

public class JazzCore extends Game{

	JazzGame jazzGame;
	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		jazzGame = new JazzGame();
		setScreen(jazzGame);
	}

	
}

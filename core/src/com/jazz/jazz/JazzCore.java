package com.jazz.jazz;

//github.com/JazzOut/Jazz.git
import com.badlogic.gdx.Game;
import com.jazz.jazz.screens.MainMenu;

public class JazzCore extends Game{

	public static JazzGame jazzGame;
	public static MainMenu mainMenu;
	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		jazzGame = new JazzGame();
		mainMenu = new MainMenu();
		setScreen(mainMenu);
	}
}

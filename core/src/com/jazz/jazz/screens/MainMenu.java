package com.jazz.jazz.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.jazz.jazz.JazzCore;
 
public class MainMenu implements Screen {
       
        private Stage stage; //done
        private TextureAtlas atlas; //done
        private Skin skin; //done
        private Table table; //done
        private TextButton buttonPlay, buttonExit;
        private BitmapFont white, black, color; //done
        private Label heading;
       
        @Override
        public void render(float delta) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
               
                stage.act(delta);
                stage.draw();
 
        }
 
        @Override
        public void resize(int width, int height) {
        	//stage.getViewport().update(width, height, true);
        	stage.getViewport().update(width, height, false);
        }
 
        @Override
        public void show() {
        		Gdx.input.setCursorCatched(false);
                stage = new Stage();
               
                atlas = new TextureAtlas("ui/button.pack");
                skin = new Skin(atlas);
               
                table = new Table(skin);
                table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
               
                //creating fonts
                white = new BitmapFont(Gdx.files.internal("font/font.fnt"), false);
                black = new BitmapFont(Gdx.files.internal("font/font.fnt"), false);
                color = new BitmapFont(Gdx.files.internal("font/font.fnt"), false);
               
                //creating buttons
                TextButtonStyle textButtonStyle = new TextButtonStyle();
                textButtonStyle.up = skin.getDrawable("button.up");
                textButtonStyle.down = skin.getDrawable("button.down");
                textButtonStyle.pressedOffsetX = 1;
                textButtonStyle.pressedOffsetY = -1;
                textButtonStyle.font = black;
               
                buttonExit = new TextButton("EXIT", textButtonStyle);
                buttonExit.addListener(new ClickListener() {
                	@Override
                	public void clicked(InputEvent event, float x, float y) {
                		System.out.println("clicked");
                		Gdx.app.exit();
                	}
                });
                buttonExit.pad(15);
                
                buttonPlay = new TextButton("PLAY", textButtonStyle);
                buttonPlay.addListener(new ClickListener() {
                	@Override
                	public void clicked(InputEvent event, float x, float y) {
                		((Game) Gdx.app.getApplicationListener()).setScreen(JazzCore.jazzGame);
                	}
                });
                buttonPlay.pad(15);
                
                //creating heading
                //LabelStyle headingStyle = ; 
                
                heading = new Label("JazzCore", new LabelStyle(color, Color.CYAN));
                heading.setFontScale(1);
                
                //putting stuff together
                table.add(heading);
                table.getCell(heading).spaceBottom(100);
                table.row();
                table.add(buttonPlay);
                table.getCell(buttonPlay).spaceBottom(20);
                table.row();
                table.add(buttonExit);
                table.row();
                table.debug();
                stage.addActor(table);
                
                Gdx.input.setInputProcessor(stage);
        }
 
        @Override
        public void hide() {
               
 
        }
 
        @Override
        public void pause() {
               
 
        }
 
        @Override
        public void resume() {
 
        }
 
        @Override
        public void dispose() {
        	stage.dispose();
        	atlas.dispose();
        	skin.dispose();
        	white.dispose();
        	black.dispose();
        	
 
        }
 
}
package com.terribleplatformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.terribleplatformer.MainMenu;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class TerribleGame extends Game {
	SpriteBatch batch;
	Texture img;
	MainMenu menu;
	TextButtonStyle style;

	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		//menu = new MainMenu();
		this.setScreen(new MainMenu(this));
		
	}

	@Override
	public void render () {
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.end();
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

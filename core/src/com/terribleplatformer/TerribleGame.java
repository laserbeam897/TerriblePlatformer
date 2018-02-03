package com.terribleplatformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class TerribleGame extends Game {
	SpriteBatch batch;
	Texture img;


	
	@Override
	public void create () {
		this.setScreen(new MainMenu(this));
		
	}

	@Override
	public void render () {

		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

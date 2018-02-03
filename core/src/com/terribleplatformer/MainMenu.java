package com.terribleplatformer;

import com.terribleplatformer.TerribleGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.graphics.GL20;
import com.terribleplatformer.randomScreen;
import com.badlogic.gdx.Game;

public class MainMenu implements Screen{
    TextButton startGame;
    Skin UISkin;
    Stage stage;
    Table table;
    TerribleGame game;

    public MainMenu(TerribleGame game)
    {
        this.game = game;
        UISkin = new Skin();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();

        UISkin.add("white", new Texture(pixmap));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = UISkin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = UISkin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = UISkin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = UISkin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = new BitmapFont();
        UISkin.add("default", textButtonStyle);

        startGame = new TextButton("Start Game", textButtonStyle);

        table = new Table();
		table.setFillParent(true);
        table.add(startGame);
		stage.addActor(table);

    }
    @Override 
    public void dispose()
    {
        stage.dispose();
    }

    @Override
    public void hide(){ }
 
    @Override
    public void pause(){}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void resume(){}

    @Override
    public void show(){}
    
    @Override
    public void render(float delta)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(delta);
	    stage.draw();

        if (startGame.isPressed())
        {
                game.setScreen(new randomScreen());
        }
    }
}
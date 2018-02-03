package com.terribleplatformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class randomScreen implements InputProcessor, Screen {
    SpriteBatch batch;
    Texture img;
    ShapeRenderer shapeRenderer;
    int x = 600;
    int circlemovementX = 300;
    int circlemovementY = 300;
    int speed = 75;
    int circleRadius = 40;
    long starttime = System.currentTimeMillis();
    int interactiveX = 50;
    int interactiveY = 50;
    boolean isDragged = false;
    float velocity = 0;

    @Override public boolean keyDown (int keycode) {
        return false;
    }

    @Override public boolean keyUp (int keycode) {
        return false;
    }

    @Override public boolean keyTyped (char character) {
        return false;
    }

    @Override public boolean scrolled (int amount) {
        return false;
    }
    @Override public boolean mouseMoved (int screenX, int screenY) {return false;}
    @Override public boolean touchDragged (int screenX, int screenY, int pointer) {return false;}
    @Override public boolean touchUp (int screenX, int screenY, int pointer, int button) { isDragged = false; return false;}
    @Override public void resize (int width, int height) { return;}
    @Override
    public void randonScreen() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        Gdx.input.setInputProcessor(this);
    }

    @Override public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        double distance = Math.sqrt(Math.pow((screenX - interactiveX),2) + Math.pow(((Gdx.graphics.getHeight()- screenY) - interactiveY),2));
        System.out.println(screenY);
        System.out.println(distance);
        if (distance < circleRadius){
            isDragged = true;
            velocity = 0;
        }
        return true;
    }
    private void renderCircularParticle(){
        shapeRenderer.circle(circlemovementX, circlemovementY,circleRadius);
        circlemovementX = Math.round(400 + 50 * MathUtils.sinDeg((System.currentTimeMillis() - starttime)/1000f * 500.0f));
        circlemovementY = Math.round(200 + 50 * MathUtils.cosDeg((System.currentTimeMillis() - starttime)/1000f * 500.0f));
    }
    private void movingCircle(){
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(x, 200,circleRadius,8);
        x += speed * Gdx.graphics.getDeltaTime();
        if (x > Gdx.graphics.getWidth()+circleRadius){
            x = 0 - circleRadius;
        }
    }
    private void renderInteractiveCircle(){
        shapeRenderer.setColor(Color.FOREST);
        if (isDragged){
            interactiveX = Gdx.input.getX();
            interactiveY = Gdx.graphics.getHeight() - Gdx.input.getY();
        }else {
            if (interactiveY > Gdx.graphics.getHeight()){
                interactiveY = 0;
                System.out.println(interactiveY);
            }
            interactiveY -= velocity * Gdx.graphics.getDeltaTime();
            velocity += 50 * Gdx.graphics.getDeltaTime();
            //System.out.println(velocity);

        }
        shapeRenderer.circle(interactiveX, interactiveY, circleRadius);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        movingCircle();
        renderCircularParticle();
        renderInteractiveCircle();
        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}


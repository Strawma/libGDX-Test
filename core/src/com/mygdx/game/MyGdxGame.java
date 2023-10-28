package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("bucket.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

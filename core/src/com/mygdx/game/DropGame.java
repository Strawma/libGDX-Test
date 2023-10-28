package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;

public class DropGame extends ApplicationAdapter {

	private Sound dropSound;
	private Music rainMusic;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Bucket bucket;
	private Raindrops raindrops;

	// constants for width and height of game screen - used in desktop and html launchers
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	
	@Override
	public void create () {
		// loads assets - stored in assets folder
		dropSound = Gdx.audio.newSound(Gdx.files.internal("water_drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		// creates camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);

		// creates sprite batch
		batch = new SpriteBatch();

		// creates bucket rectangle
		bucket = new Bucket();

		// creates raindrops array
		raindrops = new Raindrops();

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		draw();
		update();
	}

	public void draw() {
		batch.begin();
		bucket.draw(batch);
		raindrops.draw(batch);
		batch.end();
	}

	public void update() {
		Vector3 touchPos = null;
		if (Gdx.input.isTouched()) {
			touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); // gets mouse position
			camera.unproject(touchPos); // converts mouse position to game coordinates
		}

		bucket.update(touchPos);
		raindrops.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

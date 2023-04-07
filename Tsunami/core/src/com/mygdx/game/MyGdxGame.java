package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	int height = 150, width = 300;

	TiledMap map;
	IsometricTiledMapRenderer renderer;

	@Override
	public void create () {
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("OceanLand.tmx");
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		camera.update();

		int mapWidth = map.getProperties().get("width", Integer.class);
		int mapHeight = map.getProperties().get("height", Integer.class);
		int tilePixelWidth = map.getProperties().get("tilewidth", Integer.class);
		int tilePixelHeight = map.getProperties().get("tileheight", Integer.class);
		float centerX = mapWidth * tilePixelWidth / 2f;
		float centerY = mapHeight * tilePixelHeight / 2f;

// center the camera on the center tile
		camera.position.set(centerX, centerY, 0f);
		camera.update();

		renderer = new IsometricTiledMapRenderer(map);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0,0,0.2f,1);
		camera.update();
		renderer.setView(camera);
		renderer.render();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		renderer.dispose();
	}
}

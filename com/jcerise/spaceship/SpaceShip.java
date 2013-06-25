package com.jcerise.spaceship;

import com.artemis.World;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.jcerise.systems.ExpiringSystem;
import com.jcerise.systems.MovementSystem;
import com.jcerise.systems.PlayerInputSystem;
import com.jcerise.systems.SpriteRenderSystem;

public class SpaceShip implements Screen {
	
	private OrthographicCamera camera;
	private Game game;
	private World world;
	
	private SpriteRenderSystem spriteRenderSystem;
	
	public SpaceShip(Game game) {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 900);
		
		this.game = game;
		
		world = new World();
		spriteRenderSystem = world.setSystem(new SpriteRenderSystem(camera), true);
		
		//Add the movement and player control systems
		world.setSystem(new MovementSystem());
		world.setSystem(new PlayerInputSystem(camera));
		world.setSystem(new ExpiringSystem());
		
		world.initialize();
		
		EntityFactory.createPlayer(world, 150, 150).addToWorld();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		world.setDelta(delta);
		world.process();
		spriteRenderSystem.process();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}

package com.jcerise.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jcerise.components.Position;
import com.jcerise.components.Sprite;

public class SpriteRenderSystem extends EntitySystem {
	
	@Mapper ComponentMapper<Position> pm;
	@Mapper ComponentMapper<Sprite> sm;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;

	@SuppressWarnings("unchecked")
	public SpriteRenderSystem(OrthographicCamera camera) {
		super(Aspect.getAspectForAll(Position.class, Sprite.class));
		this.camera = camera;
	}
	
	@Override
	protected void initialize() {
		batch = new SpriteBatch();
	}

	@Override
	protected boolean checkProcessing() {
		return true;
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		for (int i = 0; i < entities.size(); i ++) {
			process(entities.get(i));
		}
	}
	
	@Override
	protected void begin() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
	}
	
	protected void process(Entity e) {
		if (pm.has(e)) {
			Position position = pm.getSafe(e);
			Sprite sprite = sm.get(e);
			
			batch.setColor(sprite.r, sprite.g, sprite.b, sprite.a);
			float posx = position.x;
			float posy = position.y;
			
			batch.draw(sprite.sprite, posx, posy);
		}
	}
	
	@Override
	protected void end() {
		batch.end();
	}
}

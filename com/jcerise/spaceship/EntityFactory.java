package com.jcerise.spaceship;

import com.artemis.Entity;
import com.artemis.World;
import com.jcerise.components.Expires;
import com.jcerise.components.Player;
import com.jcerise.components.Position;
import com.jcerise.components.Sprite;
import com.jcerise.components.Velocity;

public class EntityFactory {
	
	public static Entity createPlayer(World world, float x, float y) {
		Entity e = world.createEntity();
		
		e.addComponent(new Position(x, y));
		e.addComponent(new Sprite("textures-original/fighter.png"));
		e.addComponent(new Velocity());
		e.addComponent(new Player());
		
		return e;
	}
	
	public static Entity createBullet(World world, float x, float y) {
		Entity e = world.createEntity();
		
		e.addComponent(new Position(x, y));
		e.addComponent(new Sprite("textures-original/bullet.png"));
		e.addComponent(new Velocity(0, 800));
		e.addComponent(new Expires(1f));
		
		return e;
	}

}

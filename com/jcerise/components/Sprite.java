package com.jcerise.components;

import com.artemis.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Sprite extends Component{
	
	public Texture sprite;
	public float r = 1;
	public float g = 1;
	public float b = 1;
	public float a = 1;
	public float scaleX = 1;
	public float scaleY = 1;
	public float rotation;
	
	public Sprite(String path) {
		sprite = new Texture(Gdx.files.internal(path));
	}
	
	public Sprite() {
		this("textures-original/fighter.png");
	}
	
}

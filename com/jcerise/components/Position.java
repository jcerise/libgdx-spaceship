package com.jcerise.components;

import com.artemis.Component;

public class Position extends Component{
	
	public float x, y;
	
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Position() {
		this(0, 0);
	}
}

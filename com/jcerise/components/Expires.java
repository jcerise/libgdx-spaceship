package com.jcerise.components;

import com.artemis.Component;

public class Expires extends Component {
	
	public float delay;
	
	public Expires(float delay) {
		this.delay = delay;
	}
	
	public Expires() {
		this(0);
	}

}

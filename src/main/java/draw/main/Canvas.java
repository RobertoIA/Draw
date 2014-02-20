package draw.main;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Canvas extends PApplet {
	public void setup() {
		background(255);
	}

	public void draw() {
		if (mousePressed) {
			fill(255, 0, 0);
			line(pmouseX, pmouseY, mouseX, mouseY);
		}
	}
}

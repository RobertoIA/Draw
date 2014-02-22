package draw.main;

import java.awt.Color;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Canvas extends PApplet {

	private Color color = new Color(0, 0, 0);
	private int width = 1;

	public void setup() {
		background(255);
	}

	public void draw() {
		if (mousePressed) {
			stroke(color.getRed(), color.getGreen(), color.getBlue());
			strokeWeight(width);
			line(pmouseX, pmouseY, mouseX, mouseY);
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void reset() {
		background(255);
	}
}

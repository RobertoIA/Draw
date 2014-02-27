package draw.main;

import java.awt.Color;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Canvas extends PApplet {

	private static enum Brush {
		NORMAL, ROMBUS, DOUBLE
	}

	private Color color = new Color(0, 0, 0);
	private int width = 1;
	private Brush brush = Brush.NORMAL;

	public void setup() {
		background(255);
	}

	public void draw() {
		if (mousePressed) {
			switch (brush) {
			case NORMAL:
				normalBrush();
				break;
			case ROMBUS:
				rombusBrush();
				break;
			case DOUBLE:
				doubleBrush();
				break;
			}
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

	public void setNormalBrush() {
		this.brush = Brush.NORMAL;
	}

	private void normalBrush() {
		stroke(color.getRed(), color.getGreen(), color.getBlue());
		strokeWeight(width);
		line(pmouseX, pmouseY, mouseX, mouseY);
	}

	public void setRombusBrush() {
		this.brush = Brush.ROMBUS;
	}

	private void rombusBrush() {
		stroke(color.getRed(), color.getGreen(), color.getBlue());
		strokeWeight(1);
		line(pmouseX - width, pmouseY - width, mouseX + width, mouseY
				+ width);
		line(pmouseX + width, pmouseY + width, mouseX - width, mouseY
				- width);
	}
	
	public void setDoubleBrush() {
		this.brush = Brush.DOUBLE;
	}
	
	private void doubleBrush() {
		stroke(color.getRed(), color.getGreen(), color.getBlue());
		strokeWeight(1);
		line(pmouseX - width, pmouseY + width, mouseX - width, mouseY
				+ width);
		line(pmouseX + width, pmouseY - width, mouseX + width, mouseY
				- width);
	}
}

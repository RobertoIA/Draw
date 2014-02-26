package draw.main;

import java.awt.Color;
import java.util.Random;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Canvas extends PApplet {

	private static enum Brush {
		NORMAL, FUZZY
	}

	private Color color = new Color(0, 0, 0);
	private int width = 1;
	private Brush brush = Brush.FUZZY;
	private Random random = new Random();

	public void setup() {
		background(255);
	}

	public void draw() {
		if (mousePressed) {
			switch (brush) {
			case NORMAL:
				normalBrush();
				break;
			case FUZZY:
				fuzzyBrush();
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

	public void setFuzzyBrush() {
		this.brush = Brush.FUZZY;
	}

	private void fuzzyBrush() {
		int offset = (int) ((random.nextFloat() / 2) * width);
		stroke(color.getRed(), color.getGreen(), color.getBlue());
		strokeWeight(width);
		line(pmouseX - offset, pmouseY - offset, mouseX + offset, mouseY
				+ offset);
	}
}

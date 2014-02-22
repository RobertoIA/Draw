package draw.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.core.PApplet;
import draw.main.Canvas;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class MainWindow {

	private JFrame frame;

	private PApplet canvas;
	private JPanel canvasPanel;
	private JPanel uiPanel;
	private JButton changeColor;
	private JButton reset;
	private JSlider widthSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		this.canvas.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new BorderLayout(0, 0));

		this.canvasPanel = new JPanel();
		this.frame.getContentPane().add(this.canvasPanel, BorderLayout.CENTER);
		this.canvasPanel.setLayout(new BorderLayout(0, 0));

		this.canvas = new Canvas();
		this.canvas.frameRate = 60.0f;
		this.canvasPanel.add(this.canvas, BorderLayout.CENTER);

		this.uiPanel = new JPanel();
		this.frame.getContentPane().add(this.uiPanel, BorderLayout.WEST);

		this.changeColor = new JButton("Color");
		this.changeColor.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.changeColor.addActionListener(new ChangeColorActionListener());
		this.uiPanel.setLayout(new BoxLayout(this.uiPanel, BoxLayout.Y_AXIS));
		this.uiPanel.add(this.changeColor);

		this.reset = new JButton("Reset");
		this.reset.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.reset.addActionListener(new ResetActionListener());
		this.uiPanel.add(this.reset);

		this.widthSlider = new JSlider();
		this.widthSlider.setOrientation(SwingConstants.VERTICAL);
		this.widthSlider.setToolTipText("Width");
		this.widthSlider.setPaintTicks(true);
		this.widthSlider.setSnapToTicks(true);
		this.widthSlider.setMajorTickSpacing(1);
		this.widthSlider.addChangeListener(new SliderChangeListener());
		this.widthSlider.setValue(1);
		this.widthSlider.setMaximum(10);
		this.widthSlider.setMinimum(1);
		this.uiPanel.add(this.widthSlider);
	}

	private class ChangeColorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Random random = new Random();
			int r = (int) (random.nextFloat() * 255);
			int g = (int) (random.nextFloat() * 255);
			int b = (int) (random.nextFloat() * 255);

			Color color = new Color(r, g, b);
			((Canvas) canvas).setColor(color);
		}
	}

	private class ResetActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			((Canvas) canvas).reset();
		}
	}

	private class SliderChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			((Canvas) canvas).setWidth(widthSlider.getValue());
		}
	}
}

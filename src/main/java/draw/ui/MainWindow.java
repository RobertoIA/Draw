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

public class MainWindow {

	private JFrame frame;

	private PApplet canvas;
	private JPanel canvasPanel;
	private JPanel uiPanel;
	private JButton changeColor;

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
		this.changeColor.addActionListener(new ChangeColorActionListener());
		this.uiPanel.add(this.changeColor);
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
}

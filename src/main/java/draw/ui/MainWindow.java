package draw.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.core.PApplet;
import draw.main.Canvas;

public class MainWindow {

	private JFrame frame;

	private PApplet canvas;
	private JPanel canvasPanel;

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
	}

}

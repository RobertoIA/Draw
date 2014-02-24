package draw.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import processing.core.PApplet;
import draw.main.Canvas;

public class MainWindow {

	private JFrame frame;

	private PApplet canvas;
	private JPanel canvasPanel;
	private JPanel uiPanel;
	private JButton reset;
	private JSlider widthSlider;
	private JSlider rSlider;
	private JSlider bSlider;
	private JSlider gSlider;
	private JTextField colorPreview;
	private JPanel colorsPanel;
	private JPanel controlsPanel;
	private JPanel containerPanel;

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
		this.frame.setBounds(100, 100, 615, 475);
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
		this.uiPanel.setLayout(new BorderLayout(0, 0));

		this.containerPanel = new JPanel();
		this.uiPanel.add(this.containerPanel, BorderLayout.NORTH);
		this.containerPanel.setLayout(new BorderLayout(0, 0));

		this.colorsPanel = new JPanel();
		this.containerPanel.add(this.colorsPanel, BorderLayout.NORTH);
		this.colorsPanel.setLayout(new BoxLayout(this.colorsPanel,
				BoxLayout.Y_AXIS));

		this.rSlider = new JSlider();
		this.colorsPanel.add(this.rSlider);
		this.rSlider.setValue(0);
		this.rSlider.setMaximum(255);

		this.gSlider = new JSlider();
		this.colorsPanel.add(this.gSlider);
		this.gSlider.setValue(0);
		this.gSlider.setMaximum(255);

		this.bSlider = new JSlider();
		this.colorsPanel.add(this.bSlider);
		this.bSlider.setValue(0);
		this.bSlider.setMaximum(255);

		this.colorPreview = new JTextField();
		this.colorsPanel.add(this.colorPreview);
		this.colorPreview.setBackground(Color.BLACK);
		this.colorPreview.setEnabled(false);
		this.colorPreview.setEditable(false);
		this.colorPreview.setColumns(10);

		this.controlsPanel = new JPanel();
		this.containerPanel.add(this.controlsPanel, BorderLayout.SOUTH);

		this.reset = new JButton("Reset");
		this.controlsPanel.add(this.reset);
		this.reset.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.reset.addActionListener(new ResetActionListener());

		this.widthSlider = new JSlider();
		this.controlsPanel.add(this.widthSlider);
		this.widthSlider.setToolTipText("Width");
		this.widthSlider.setMajorTickSpacing(1);
		this.widthSlider.addChangeListener(new SliderChangeListener());
		this.widthSlider.setValue(1);
		this.widthSlider.setMaximum(10);
		this.widthSlider.setMinimum(1);
		this.bSlider.addChangeListener(new ColorChangeListener());
		this.gSlider.addChangeListener(new ColorChangeListener());
		this.rSlider.addChangeListener(new ColorChangeListener());
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

	private class ColorChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			Color color = new Color(rSlider.getValue(), gSlider.getValue(),
					bSlider.getValue());
			((Canvas) canvas).setColor(color);
			colorPreview.setBackground(color);
		}
	}
}

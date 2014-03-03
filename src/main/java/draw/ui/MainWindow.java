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
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import processing.core.PApplet;
import draw.main.Canvas;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

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
	private JPanel rPanel;
	private JPanel gPanel;
	private JPanel bPanel;
	private JTextField rPreview;
	private JTextField gPreview;
	private JTextField bPreview;
	private JPanel panel;
	private JPanel brushPanel;
	private JRadioButton normalButton;
	private JRadioButton rombusButton;
	private final ButtonGroup brushGroup = new ButtonGroup();
	private JRadioButton doubleButton;
	private JRadioButton pointsButton;

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
		this.frame.setBounds(100, 100, 846, 508);
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

		this.rPanel = new JPanel();
		this.colorsPanel.add(this.rPanel);

		this.rPreview = new JTextField();
		this.rPreview.setBackground(Color.BLACK);
		this.rPanel.add(this.rPreview);
		this.rPreview.setColumns(2);

		this.rSlider = new JSlider();
		this.rPanel.add(this.rSlider);
		this.rSlider.setValue(0);
		this.rSlider.setMaximum(255);
		this.rSlider.addChangeListener(new ColorChangeListener());

		this.gPanel = new JPanel();
		this.colorsPanel.add(this.gPanel);

		this.gPreview = new JTextField();
		this.gPreview.setBackground(Color.BLACK);
		this.gPanel.add(this.gPreview);
		this.gPreview.setColumns(2);

		this.gSlider = new JSlider();
		this.gPanel.add(this.gSlider);
		this.gSlider.setValue(0);
		this.gSlider.setMaximum(255);
		this.gSlider.addChangeListener(new ColorChangeListener());

		this.bPanel = new JPanel();
		this.colorsPanel.add(this.bPanel);

		this.bPreview = new JTextField();
		this.bPreview.setBackground(Color.BLACK);
		this.bPanel.add(this.bPreview);
		this.bPreview.setColumns(2);

		this.bSlider = new JSlider();
		this.bPanel.add(this.bSlider);
		this.bSlider.setValue(0);
		this.bSlider.setMaximum(255);
		this.bSlider.addChangeListener(new ColorChangeListener());

		this.panel = new JPanel();
		this.colorsPanel.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.colorPreview = new JTextField();
		this.panel.add(this.colorPreview);
		this.colorPreview.setHorizontalAlignment(SwingConstants.LEFT);
		this.colorPreview.setBackground(Color.BLACK);
		this.colorPreview.setEnabled(false);
		this.colorPreview.setEditable(false);
		this.colorPreview.setColumns(10);

		this.brushPanel = new JPanel();
		this.colorsPanel.add(this.brushPanel);

		this.normalButton = new JRadioButton("Normal");
		this.normalButton.addActionListener(new BrushButtonActionListener());
		brushGroup.add(this.normalButton);
		this.normalButton.setSelected(true);
		this.brushPanel.add(this.normalButton);

		this.rombusButton = new JRadioButton("Rombus");
		this.rombusButton.addActionListener(new BrushButtonActionListener());
		brushGroup.add(this.rombusButton);
		this.brushPanel.add(this.rombusButton);

		this.doubleButton = new JRadioButton("Double");
		this.doubleButton.addActionListener(new BrushButtonActionListener());
		brushGroup.add(this.doubleButton);
		this.brushPanel.add(this.doubleButton);

		this.pointsButton = new JRadioButton("Points");
		this.pointsButton.addActionListener(new BrushButtonActionListener());
		brushGroup.add(this.pointsButton);
		this.brushPanel.add(this.pointsButton);

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

			rPreview.setBackground(new Color(rSlider.getValue(), 0, 0));
			gPreview.setBackground(new Color(0, gSlider.getValue(), 0));
			bPreview.setBackground(new Color(0, 0, bSlider.getValue()));
		}
	}

	private class BrushButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource().equals(normalButton)) {
				((Canvas) canvas).setNormalBrush();
			} else if (event.getSource().equals(rombusButton)) {
				((Canvas) canvas).setRombusBrush();
			} else if (event.getSource().equals(doubleButton)) {
				((Canvas) canvas).setDoubleBrush();
			} else if (event.getSource().equals(pointsButton)) {
				((Canvas) canvas).setPointsBrush();
			}
		}
	}

}

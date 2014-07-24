package DroidSync;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class DroidFrame
{
	private final int Height = 600;
	private final int Width = 480;

	// GUI variables
	public String version = "PC Pwns Console v1.15";
	public JFrame f;
	public Panel p;
	public TextArea textArea;
	public static TextField textField;

	// graphics output variables
	public Graphics BufferedGraphics;
	public Graphics ImageGraphics;
	public Graphics g;
	public BufferedImage image;
	public Canvas canvas;

	public DroidFrame()
	{
		// frame
		f = new JFrame(version);
		f.setSize(1024, 768);

		// textarea
		textArea = new TextArea(10, 80);
		textArea.setEditable(false);

		// textfield
		textField = new TextField();

		// canvas
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setSize(300, 300);

		// double buffering
		image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		BufferedGraphics = image.getGraphics();

		// panel;
		p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(textArea, BorderLayout.PAGE_END);
		p.add(canvas, BorderLayout.EAST);
		//p.add(textField, c);

		f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

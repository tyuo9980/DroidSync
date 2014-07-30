package DroidSync;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class DroidFrame  implements ActionListener
{
	private final int Height = 600;
	private final int Width = 480;

	// GUI variables
	public String version = "PC Pwns Console v1.15";
	public JFrame f;
	public Panel p;
	public TextArea textArea;
	public static TextField textField;
	public Label title;
	public JTable table;

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
		f.setSize(600, 400);

		// textarea
		textArea = new TextArea("The content is here:\n",5,50);
		textArea.setEditable(false);

		// textfield
		textField = new TextField();

		// canvas
		canvas = new Canvas();
		canvas.setBackground(Color.YELLOW);
		canvas.setSize(600, 400);

		// double buffering
		image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		BufferedGraphics = image.getGraphics();
		
		//title
		title = new Label("Hello!!",Label.CENTER);
		
		//table
		Vector<Vector> deviceList = new Vector<Vector>();
		
		for(int i=0;i<DroidSync.list.size();i++){
			Vector<String> device = new Vector<String>();
			device.addElement(DroidSync.list.elementAt(i).type);
			device.addElement(DroidSync.list.elementAt(i).name);
			deviceList.addElement(device);
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Type");
	    columnNames.addElement("Name");
	    JTable table = new JTable(deviceList, columnNames);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		// panel;
		p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(title, BorderLayout.PAGE_START);
		p.add(textArea, BorderLayout.EAST);
		p.add(scrollPane, BorderLayout.WEST);
		p.add(textField, BorderLayout.PAGE_END);
		textField.addActionListener(this);
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent evt) {
	    String text = textField.getText();
	    textArea.append(text + "\n");
	    textField.selectAll();
	}
}

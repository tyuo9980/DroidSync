package DroidSync;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	public JComboBox<String> dropdown;
	public Vector<String> deviceList;
	public JOptionPane addDeviceWindow;
	public JButton addDeviceButton;

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
		
		//button
		addDeviceButton = new JButton("Add Device");
		addDeviceButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	displayAddDevice();
            }
        }); 
		//String typeDevice = JOptionPane.showInputDialog(f,"Enter device's type: ","Add Device",JOptionPane.PLAIN_MESSAGE);
	//	String nameDevice = JOptionPane.showInputDialog(f,"Enter device's name: ","Add Device",JOptionPane.PLAIN_MESSAGE);
		//DroidSync.addDevice(typeDevice,nameDevice);
		//dropdown = new JComboBox(deviceList);
		dropdown = new JComboBox();
		//table
		deviceList = new Vector<String>();
		for(int i=0;i<DroidSync.list.size();i++){
			dropdown.addItem(DroidSync.list.elementAt(i).type+"-"+DroidSync.list.elementAt(i).name);
			//deviceList.add(DroidSync.list.elementAt(i).type+"-"+DroidSync.list.elementAt(i).name);
		}
		
		
		//add device window
		
		//JOptionPane.showMessageDialog(f,"Enter the name's device: ","Add Device",JOptionPane.PLAIN_MESSAGE);
		// panel;
		p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(title, BorderLayout.PAGE_START);
		p.add(textArea, BorderLayout.EAST);
		p.add(dropdown, BorderLayout.WEST);
		p.add(textField, BorderLayout.PAGE_END);
		p.add(addDeviceButton, BorderLayout.CENTER);
		textField.addActionListener(this);
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void displayAddDevice(){
		String typeDevice = JOptionPane.showInputDialog(f,"Enter device's type: ","Add Device",JOptionPane.PLAIN_MESSAGE);
		String nameDevice = JOptionPane.showInputDialog(f,"Enter device's name: ","Add Device",JOptionPane.PLAIN_MESSAGE);
		DroidSync.addDevice(typeDevice,nameDevice);
		dropdown.addItem(typeDevice+"-"+nameDevice);
	}
	public void actionPerformed(ActionEvent evt) {
	    String text = textField.getText();
	    textArea.append(text + "\n");
	    textField.selectAll();
	}
}

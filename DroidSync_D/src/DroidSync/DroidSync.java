package DroidSync;

import java.util.Vector;

public class DroidSync
{	
	public static Vector<Device> list;
	public static void addDevice(String type, String name){
		list.add(new Device(type,name));
	}
	public static void addDevice(Device d){
		list.add(d);
	}
	public static void main(String args[])
	{	
		list = new Vector<Device>();
		addDevice("Phone","Julie1");
		addDevice("Phone","Julie2");
		addDevice("Tablet","Julie3");
		addDevice("Tablet","Julie4");
		addDevice("Phone","Julie5");
		addDevice("Phone","Julie6");
		addDevice("Phone","Julie7");
		addDevice("Tablet","Julie8");
		addDevice("Tablet","Julie9");
		addDevice("Phone","Julie10");
		addDevice("Phone","Julie11");
		addDevice("Phone","Julie12");
		addDevice("Tablet","Julie13");
		addDevice("Tablet","Julie14");
		addDevice("Phone","Julie15");
		addDevice("Phone","Julie16");
		addDevice("Phone","Julie17");
		addDevice("Tablet","Julie18");
		addDevice("Tablet","Julie19");
		addDevice("Phone","Julie20");

		
		DroidFrame f = new DroidFrame();
	}
}

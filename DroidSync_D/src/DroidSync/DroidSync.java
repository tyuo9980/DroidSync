package DroidSync;

import java.util.Vector;

public class DroidSync
{	
	public static Vector<Device> list;
	public static void main(String args[])
	{	
		list = new Vector<Device>();
		list.add(new Device("Phone","Julie1"));
		list.add(new Device("Phone","Julie2"));
		list.add(new Device("Tablet","Julie3"));
		list.add(new Device("Tablet","Julie4"));
		list.add(new Device("Phone","Julie5"));
		list.add(new Device("Phone","Julie6"));
		list.add(new Device("Phone","Julie7"));
		list.add(new Device("Tablet","Julie8"));
		list.add(new Device("Tablet","Julie9"));
		list.add(new Device("Phone","Julie10"));
		list.add(new Device("Phone","Julie11"));
		list.add(new Device("Phone","Julie12"));
		list.add(new Device("Tablet","Julie13"));
		list.add(new Device("Tablet","Julie14"));
		list.add(new Device("Phone","Julie15"));
		list.add(new Device("Phone","Julie16"));
		list.add(new Device("Phone","Julie17"));
		list.add(new Device("Tablet","Julie18"));
		list.add(new Device("Tablet","Julie19"));
		list.add(new Device("Phone","Julie20"));
		
		DroidFrame f = new DroidFrame();
	}
}

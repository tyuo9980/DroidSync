package DroidSync;

import java.net.InetAddress;

public class DroidNet extends Thread
{
	String ip;
	int port = 1337;

	public void init()
	{
		try
		{
			ip = InetAddress.getLocalHost().toString();
		}
		catch (Exception e)
		{
			System.out.println("Could not get IP");
		}

		port = 1337;
	}

	public void run()
	{
		init();

		try
		{
			while (!Thread.currentThread().isInterrupted())
			{
				// ...
			}
		}
		catch (Exception e)
		{
			/* Allow thread to exit */
		}
	}
}

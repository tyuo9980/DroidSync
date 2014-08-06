package DroidSync;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DroidNet extends Thread
{
	String ip;
	int port;
	ServerSocket server;
	Socket socket;
	Scanner sc;
	ObjectInputStream in;
	ObjectOutputStream out;

	// client stuff ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void connectToServer(String ip) throws Exception
	{
		System.out.println("connecting...");
		socket = new Socket(InetAddress.getByName(ip), 1337);
		System.out.println("connected to " + socket.getInetAddress().getHostName());
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// host stuff ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void waitForConnection() throws Exception
	{
		System.out.println("waiting for connection...");
		socket = server.accept();
		System.out.println("connected to " + socket.getInetAddress().getHostName());
	}

	public void setupStreams() throws Exception
	{
		try
		{
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
			System.out.println("setup complete");
		}
		catch (Exception e)
		{
		}
	}

	public void closeStreams() throws Exception
	{
		out.close();
		in.close();
		socket.close();
		server.close();
	}

	public void receiveMessage()
	{
		String message = "";
		String temp = message;
		
		try
		{
			message = (String) in.readObject();

			if (temp != message)
			{
				System.out.println(message);
			}
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}

	public void sendMessage(String name, String s)
	{
		try
		{
			out.writeObject(name + ": " + s);
			out.flush();
			System.out.println(name + ": " + s);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	public void init()
	{
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

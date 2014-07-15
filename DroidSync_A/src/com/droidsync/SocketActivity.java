package com.droidsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class SocketActivity extends Activity {

	private TextView serverStatus;
	
	//Default IP
	public static String SERVERIP = "10.0.2.15";
	
	//DESIGNATE A PORT
	public static final int SERVERPORT = 8080;
	
	private Handler handler = new Handler();
	
	private ServerSocket serverSocket;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket);
		
		SERVERIP = getLocalIpAddress();
		
		Thread fst = new Thread(new ServerThread());
		fst.start();
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_socket,
					container, false);
			return rootView;
		}
	}

	public class ServerThread implements Runnable{
	public void run(){
		try {
			if (SERVERIP != null){
				handler.post(new Runnable(){
					public void run(){
						serverStatus.setText("Listening on IP: " + SERVERIP);
					}
				});
				serverSocket = new ServerSocket(SERVERPORT);
				while (true){
					//LISTEN FOR INCOMING CLIENTS
					Socket client = serverSocket.accept();
					handler.post(new Runnable(){
						public void run(){
							serverStatus.setText("Connected");
						}
					});
					try {
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						String line = null;
						while ((line = in.readLine()) != null){
							Log.d("ServerActivity", line);
							handler.post(new Runnable(){
								public void run(){
									//TODO: FRONTEND stuff here
								}
							});
						} 
					}
					catch(Exception e) {
						handler.post(new Runnable(){
							public void run(){
								serverStatus.setText("Connection interrupted");
							}
						});
						e.printStackTrace();
					}
				}
			}
				else {
					handler.post(new Runnable(){
						public void run(){
							serverStatus.setText("Couldn't detect Internet Connection");
						}	
					});
				}
			}
		catch(Exception e) {
			handler.post(new Runnable(){
				public void run(){
					serverStatus.setText("Error");
				}
			});
			e.printStackTrace();
		}
	}		
	}
	
	//GET PHONE'S IP ADDRESS
	private String getLocalIpAddress(){
		try{
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddress = intf.getInetAddresses(); enumIpAddress.hasMoreElements();){
					InetAddress inetAddress = enumIpAddress.nextElement();
					if(!inetAddress.isLoopbackAddress()){
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		}
		catch (SocketException ex){
			Log.e("ServerActivity", ex.toString());
		}
		return null;
	}
	
	protected void onStop(){
		super.onStop();
		try{
			serverSocket.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}

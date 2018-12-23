


import java.net.*;
import java.io.*;

public class UDPServer
{

	public static void main(String args[])
	{
		DatagramSocket socket=null;
		byte[] buffer=new byte[1024];
		try
		{
			// socket = new DatagramSocket(6789);
			while(true)
			{
				socket = new DatagramSocket(8888);
				DatagramPacket request = new DatagramPacket(buffer,buffer.length);
				socket.receive(request);

				System.out.println("message from client:"+ new String(request.getData()));
				DatagramPacket reply= new DatagramPacket(request.getData(),request.getLength(),request.getAddress(),request.getPort());
				socket.send(reply);
				System.out.println("message replied to client");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
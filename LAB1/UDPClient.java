
//Lab1
// Objective : write a client server program to read a file in client and send  to server using UPD socket
import java.net.*;
import java.io.*;
import java.io.FileInputStream.*;

public class UDPClient {

    public static void main(String[] args) throws Exception {
    	DatagramSocket socket = null;
        FileInputStream in = new FileInputStream("sujana.txt");
        byte[] buffer = new byte[1024];
        int c = in.read(buffer,0,5);
        System.out.print(new String(buffer));  

        while ((c = in.read()) != -1) {
            System.out.print((char)c); 
        } 

        socket = new DatagramSocket();
        InetAddress server_ip = InetAddress.getByName("192.168.1.27");
		int server_port = 8888; 
		DatagramPacket request = new DatagramPacket(buffer, buffer.length, server_ip,server_port);
		socket.send(request);
    }
}

  
  

  
  

  
  

  
  
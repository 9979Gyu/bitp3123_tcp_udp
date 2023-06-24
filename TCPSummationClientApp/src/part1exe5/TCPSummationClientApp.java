package part1exe5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * This is a controller class for the client-side application
 * 
 * This class demonstrate the usage of DataInputStream and DataOutputStream.
 * 
 * @author emalianakasmuri
 * @author yuqin
 *
 * Part 1 Exercise 5
 */

public class TCPSummationClientApp {

	public static void main(String[] args) {
		
		System.out.println("\n\tExecuting TCPSummationClientApp");
		
		Scanner scanner = new Scanner(System.in);
		
		// Sample of data
		int number1 = 0;
		int number2 = 0;
		int number3 = 0;
		
		try {
			
			System.out.print("\n\tEnter the first number : ");
			number1 = scanner.nextInt();
			
			System.out.print("\tEnter the second number : ");
			number2 = scanner.nextInt();
			
			System.out.print("\tEnter the third number : ");
			number3 = scanner.nextInt();
			
			// 1. Define server information
			int serverPortNo = 8087;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 2. Bind to the server, request for connection
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// 3. Send data to the server
			OutputStream outStream = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(outStream);
			dos.writeInt(number1);
			dos.writeInt(number2);
			dos.writeInt(number3);
			
			// 4. Process response from the server
			InputStream inStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(inStream);
			int sum = dis.readInt();
			int multiply = dis.readInt();
			
			// 5. Further processing - display the result
			System.out.println("\tSending to the server: " + number1 + ", " 
					+ number2 + ", " + number3);
			System.out.println("\tReceiving from server: \n\tSum = " + 
					sum + "\n\tMultiply = " + multiply);
			
			// Close all the closable
			dis.close();
			dos.close();
			socket.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		System.out.println("\tEnd of execution at TCPSummationClientApp");
		
	}

}

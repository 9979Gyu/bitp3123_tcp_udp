/**
 * 
 */
package part2exe2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author yuqin
 * 
 * Part 2 Exercise 2
 */
public class UDPCountCharacterClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create object
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\tUDPCountCharacterClientApp: Demostration of UDP "
				+ "Client-Side Application.");
		
		try {
			
			// 1. Define server port number and address
			int portNo = 8083;
			InetAddress ip = InetAddress.getLocalHost();
			
			// 2. Prepare and transform data into bytes
			System.out.print("\tEnter a sentence : ");
			String text = scanner.nextLine();
			byte buf[] = text.getBytes();
			
			// 3. Wrap data in datagram packet (constructor no 5)
			DatagramPacket outPacket =
					new DatagramPacket(buf, buf.length, ip, portNo);
			
			// 4. Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();
			
			// 5. Send datagram packet
			datagramSocket.send(outPacket);
			System.out.println("\n\tSending '" + text + "' (" +
			text.length() + ") out on network.");
			
			// 6. New buffer to extract the received data
			byte[] inData = new byte[65535];
			
			// 7. Packet to receive data
			DatagramPacket inPacket = new DatagramPacket(inData, inData.length);
			
			// 8. Receive data
			datagramSocket.receive(inPacket);
			
			// 9. Extract data
			inData = inPacket.getData();
			
			// 10. Further processing
			// Transform data into human readable text
			String length = new String(inData, 0, inPacket.getLength());
			
			// Display the data received from the server
			System.out.println("\tResult from the server is : " + length);
			
			datagramSocket.close();
			scanner.close();
			
		}
		catch(IOException ex) {
			
			ex.printStackTrace();
			
		}
		
		System.out.println("\n\tUDPCountCharacterClientApp: End of program.");

	}

}

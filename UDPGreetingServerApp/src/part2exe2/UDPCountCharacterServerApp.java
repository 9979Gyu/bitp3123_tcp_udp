/**
 * 
 */
package part2exe2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import serverside.SentenceProcessor;

/**
 * @author yuqin
 *
 */

/*
 * This class is use to count the number of 
 * vowels, consonants, and punctuation in
 * sentences.
 */
public class UDPCountCharacterServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("\tUDPCountCharacterServerApp: " +
		"Demonstration of UDP Server-Side Application.");
		
		// Permissible port for this application
		int portNo = 8083;
		
		try {
			
			// 1. Bind a DatagramSocket's object to a port number
			DatagramSocket datagramSocket = new DatagramSocket(portNo);
			
			// Continually listen for request
			while (true) {
				
				// 2. Variable to received data from the port
				// define the size of byte
				// 65535 is the maximum size for UDP packet
				byte[] receivedData = new byte[65535];
				
				// 3. Object represents packet from client
				DatagramPacket receivedPacket = 
						new DatagramPacket(receivedData, receivedData.length);
				
				// 4. Receive packet
				datagramSocket.receive(receivedPacket);
				
				// 5. Extract data from packet
				receivedData = receivedPacket.getData();
				
				// 6. Further processing
				SentenceProcessor sentenceProcessor =
						new SentenceProcessor(receivedData);
				
				String sentence = sentenceProcessor.getSentence();
				System.out.println("\n\tMessage received: " + sentence + ".\n");
				
				// More processing
				// Count characters
				int totalCharacters = sentenceProcessor.countCharacters();
				
				// Count vowels
				int totalVowels = sentenceProcessor.countVowels();
				
				// Count consonants
				int totalConsonants = sentenceProcessor.countConsonants();
				
				// Count punctuations
				int totalPunctuations = sentenceProcessor.countPunctuations();
				
				String result = "\n\tTotal Characters : " + totalCharacters +
						"\n\tTotal Vowels : " + totalVowels +
						"\n\tTotal Consonants : " + totalConsonants + 
						"\n\tTotal Punctuations : " + totalPunctuations;
				
				byte[] outData = result.getBytes();
				
				// 7. Get the client information
				InetAddress clientAddress = receivedPacket.getAddress();
				int clientPort = receivedPacket.getPort();
				int sizeOutData = outData.length;
				
				// 8. Wrap data into datagram packet
				DatagramPacket outPacket = new DatagramPacket(outData, 
						sizeOutData, clientAddress, clientPort);
				
				// 9. Reply to client
				datagramSocket.send(outPacket);
				System.out.println("\tMessage sent : " + result + "\n");
				
				
			}
		}
		catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("UDPClientSideApp: End of program.");
	}

}

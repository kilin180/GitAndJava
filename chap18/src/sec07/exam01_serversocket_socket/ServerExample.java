/* 
 * 		����																	Ŭ���̾�Ʈ
 * 	  �������� ����(��Ʈ��ȣ):���ε�             	 		 						 ����� ���Ѽ���(Ŭ���̾�Ʈ����) ����
 * severSocket = new ServerSocket();
 * socket.bind(new InetSocketAddress("localhost", 5001));
 * serverSocket.bind(new 
 * ����� ���� ��Ĺ : accept()  	
 * Socket socket = severSocket.accept();									connect()
 * 															socket.connect(new InetSocketAddress("localhost", 5001));
 * 
 * 
 * ��Ʈ��ȣ:http(80),ftp(21),telnet(..)
 * 
 * InetSocketAddress : ���� ���Ͽ� ���� ���� ����
 * ����.getRemoteSocketAddress() ���� ��ü ����
 *  -���ø޼ҵ�
 *  getHostName() : ip�ּ� ����
 *  localhost ip : 127.0.0.1
 */		

package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();		
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
//			serverSocket.bind(new InetSocketAddress("",5001));
			while(true) {
				System.out.println( "[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������] " + isa.getHostName());
				
				System.out.println( "[���� ��ٸ�1]");
				Socket socket1 = serverSocket.accept();
				
				isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������1] " + isa.getHostName());
				
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
	
	
}

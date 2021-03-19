/* 
 * 		서버																	클라이언트
 * 	  서버소켓 만듬(포트번호):바인딩             	 		 						 통신을 위한소켓(클라이언트소켓) 만듬
 * severSocket = new ServerSocket();
 * socket.bind(new InetSocketAddress("localhost", 5001));
 * serverSocket.bind(new 
 * 통신을 위한 소캣 : accept()  	
 * Socket socket = severSocket.accept();									connect()
 * 															socket.connect(new InetSocketAddress("localhost", 5001));
 * 
 * 
 * 포트번호:http(80),ftp(21),telnet(..)
 * 
 * InetSocketAddress : 연결 소켓에 대한 정보 저장
 * 소켓.getRemoteSocketAddress() 에서 객체 생성
 *  -관련메소드
 *  getHostName() : ip주소 얻음
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
				System.out.println( "[연결 기다림]");
				Socket socket = serverSocket.accept();
				
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] " + isa.getHostName());
				
				System.out.println( "[연결 기다림1]");
				Socket socket1 = serverSocket.accept();
				
				isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함1] " + isa.getHostName());
				
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
	
	
}

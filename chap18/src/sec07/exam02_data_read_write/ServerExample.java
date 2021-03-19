package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null; // ServerSocket의 참조변수 선언(변수명: serverSocket)
		try {
			//ServerSocket 생성 (한번만 하면 됨)
			serverSocket = new ServerSocket();		//ServerSocket객체 생성해 객체주소 서버소켓에 넘김
			serverSocket.bind(new InetSocketAddress("localhost", 5001)); //"localhost": (연결 허용 상대ip,포트번호)
			while(true) {
				System.out.println( "[연결 기다림]");
				Socket socket = serverSocket.accept();
				//client에서 connect요청 기다림, blocking(멈춘)상태
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//client의 정보 저장
				System.out.println("[연결 수락함] " + isa.getHostName());
				// 상대 ip주소 (호스트이름) vytl
				
				//대화시작(통신시작)
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream(); //데이터 수신 통로 설정
				bytes = new byte[100]; //메모리 설정
				int readByteCount = is.read(bytes); //수신한 데이터 (Byte단위)를 bytes[]에 넣음
				
				//수신된 bytes[]의 내용을 배열의 0번지 부터 수신된 Byte수 만큼 UTF-8로 변환하여 String message에 저장
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공]: " + message);//수신된 데이터 표시
				
				//데이터 송신 응답
				OutputStream os = socket.getOutputStream(); //송신용 스트림 객체 생성
				message = "Hello There?";
				bytes = message.getBytes("UTF-8"); //UTF-8 형식의 String 데이터를 Byte형식으로 변환
				os.write(bytes); // bytes[]에 저장된 값 송신
				os.flush(); //송신 버퍼에 남아있는 내용 전송후 비움
				System.out.println( "[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
}

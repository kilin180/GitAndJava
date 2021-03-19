package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null; // ServerSocket�� �������� ����(������: serverSocket)
		try {
			//ServerSocket ���� (�ѹ��� �ϸ� ��)
			serverSocket = new ServerSocket();		//ServerSocket��ü ������ ��ü�ּ� �������Ͽ� �ѱ�
			serverSocket.bind(new InetSocketAddress("localhost", 5001)); //"localhost": (���� ��� ���ip,��Ʈ��ȣ)
			while(true) {
				System.out.println( "[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				//client���� connect��û ��ٸ�, blocking(����)����
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				//client�� ���� ����
				System.out.println("[���� ������] " + isa.getHostName());
				// ��� ip�ּ� (ȣ��Ʈ�̸�) vytl
				
				//��ȭ����(��Ž���)
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream(); //������ ���� ��� ����
				bytes = new byte[100]; //�޸� ����
				int readByteCount = is.read(bytes); //������ ������ (Byte����)�� bytes[]�� ����
				
				//���ŵ� bytes[]�� ������ �迭�� 0���� ���� ���ŵ� Byte�� ��ŭ UTF-8�� ��ȯ�Ͽ� String message�� ����
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[������ �ޱ� ����]: " + message);//���ŵ� ������ ǥ��
				
				//������ �۽� ����
				OutputStream os = socket.getOutputStream(); //�۽ſ� ��Ʈ�� ��ü ����
				message = "Hello There?";
				bytes = message.getBytes("UTF-8"); //UTF-8 ������ String �����͸� Byte�������� ��ȯ
				os.write(bytes); // bytes[]�� ����� �� �۽�
				os.flush(); //�۽� ���ۿ� �����ִ� ���� ������ ���
				System.out.println( "[������ ������ ����]");
				
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

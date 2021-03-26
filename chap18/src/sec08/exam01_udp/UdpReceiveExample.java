package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveExample extends Thread {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[���� ���ھƾ�]");
				try {
					while(true) {
						DatagramPacket packet = new DatagramPacket(new byte[100], 100);
						datagramSocket.receive(packet);
						
						String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
						System.out.println("[���� ����: "  + packet.getSocketAddress() + "] " + data);
					}
				} catch (Exception e) {
					System.out.println("[���� ����]");
					System.out.println("utf-8롤 인코딩해서 보내줘 다깨진당");
				}
			}			
		};
		thread.start();
		
		Thread.sleep(10000);
		datagramSocket.close();
	}
}

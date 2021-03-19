/* InterAddress : 인터넷 어드레스에 대한 정보가 있는 클래스
 * 관련 메소드 :
 * getLocalHost() //자기 PC의 정보
 * getAllByName("www.naver.com"); //URL 정보
 * getHostAddress() //IP주소
 * */



package sec06.exam01_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내컴퓨터 IP주소: " + local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP주소: " + remote.getHostAddress());
			}
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}


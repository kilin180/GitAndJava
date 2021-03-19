package sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInExample2 {
	public static void main(String[] args) throws Exception {			
		InputStream is = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("이름: ");
		int nameBytes = is.read(datas); //read() 읽은 데이터 저장 될 매개변수 byte형 배열 사용, 리턴값은 읽은 개(byte수)
		String name = new String(datas, 0, nameBytes-2); // 엔터키 2Byte 뺌
		//엔터키 = CR(캐리지리턴==13: 줄의 처음으로 커서가 감 ) + LF (라인피드 == 10 : 다음줄로 커서옮김)
		
		System.out.print("하고 싶은말: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println(datas[commentBytes-2]); //13
		System.out.println(datas[commentBytes-1]); //10
		System.out.println("입력한 이름: " + name);	
		System.out.println("입력한 하고 싶은말: " + comment);	
	}
}


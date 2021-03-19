/* 스트림 의미 : 단일방향으로 연속적으로 흘러가는 것  단방향 이므로 입력과 출력이 따로 있다
 * 
 * 
 * 바이트 단위 입출려 ㄱ인터페이스 : InputStream OutputStream
 * 구현 객체이름 : PrintStream 제외하고 대부분 앞에 객체이름이 붙음
 * 예 ) FileInputStream , FileOutputStream
 *     Data"			 Data"
 *     Object"   	     Object"
 *     Buffered"	   	 Buffered"
 *     PrintStream
 *     
 *  문자 char(2Byte) 단위 입출력 인터페이스 : Reader, Writer
 *  구현객체이름 : 대부분 앞에 객체 이름 붙음
 *  FileReader , FileWriter
 *  InputStream 	OutputStreamWriter
 *  BufferedReader   BufferedWriter
 *  Print
 *  
 *  InputStream 메소드
 *  int read() :  int(4Byte) 하나를 받음 : 바이트 1Byte 부분만 Byte 변수로 사용 (앞자리 3Byte는 무시)
 *  int read(byte[] b) : 여러 바이트를 받아서 byte[]에 저장
 *  int read(byte[] b, int off , int len) : 일어진 byte[]의 몇번째 byte(off) 에서 시작해서 길이 len만큼 읽음
 */


package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		int readByte;
		while(true) {
			readByte = is.read();
			if(readByte == -1) break;
			System.out.println((char)readByte);
		}
		is.close();
	}

}

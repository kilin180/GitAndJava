/* ��Ʈ�� �ǹ� : ���Ϲ������� ���������� �귯���� ��  �ܹ��� �̹Ƿ� �Է°� ����� ���� �ִ�
 * 
 * 
 * ����Ʈ ���� ����� ���������̽� : InputStream OutputStream
 * ���� ��ü�̸� : PrintStream �����ϰ� ��κ� �տ� ��ü�̸��� ����
 * �� ) FileInputStream , FileOutputStream
 *     Data"			 Data"
 *     Object"   	     Object"
 *     Buffered"	   	 Buffered"
 *     PrintStream
 *     
 *  ���� char(2Byte) ���� ����� �������̽� : Reader, Writer
 *  ������ü�̸� : ��κ� �տ� ��ü �̸� ����
 *  FileReader , FileWriter
 *  InputStream 	OutputStreamWriter
 *  BufferedReader   BufferedWriter
 *  Print
 *  
 *  InputStream �޼ҵ�
 *  int read() :  int(4Byte) �ϳ��� ���� : ����Ʈ 1Byte �κи� Byte ������ ��� (���ڸ� 3Byte�� ����)
 *  int read(byte[] b) : ���� ����Ʈ�� �޾Ƽ� byte[]�� ����
 *  int read(byte[] b, int off , int len) : �Ͼ��� byte[]�� ���° byte(off) ���� �����ؼ� ���� len��ŭ ����
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

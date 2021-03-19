package sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInExample2 {
	public static void main(String[] args) throws Exception {			
		InputStream is = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("�̸�: ");
		int nameBytes = is.read(datas); //read() ���� ������ ���� �� �Ű����� byte�� �迭 ���, ���ϰ��� ���� ��(byte��)
		String name = new String(datas, 0, nameBytes-2); // ����Ű 2Byte ��
		//����Ű = CR(ĳ��������==13: ���� ó������ Ŀ���� �� ) + LF (�����ǵ� == 10 : �����ٷ� Ŀ���ű�)
		
		System.out.print("�ϰ� ������: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println(datas[commentBytes-2]); //13
		System.out.println(datas[commentBytes-1]); //10
		System.out.println("�Է��� �̸�: " + name);	
		System.out.println("�Է��� �ϰ� ������: " + comment);	
	}
}


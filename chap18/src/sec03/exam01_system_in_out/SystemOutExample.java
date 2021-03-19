package sec03.exam01_system_in_out;

import java.io.OutputStream;

public class SystemOutExample {
	public static void main(String[] args) throws Exception {
		OutputStream os = System.out;//����� ��ü�� OutputStream�� ���� ��ü�� ����
		for(byte b=48; b<58; b++) { // '0' ~ '9'
			os.write(b);
		}		
//		os.write(13);  //CR (Ŀ���� ó������ �� ) : �����쿡�� CR �Ǵ� LF�� �ϳ��� �ĵ� ������ ó�����ΰ�
		os.write(10);  //LF ������ ������
		
		for(byte b=97; b<123; b++) { // 'a' ~ 'z'
			os.write(b);
		}		
		
		os.write(10);		

		String hangul = "�����ٶ󸶹ٻ������īŸ����";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
		os.flush();
	}
}


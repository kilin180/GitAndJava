package sec03.exam01_system_in_out;

import java.io.OutputStream;

public class SystemOutExample {
	public static void main(String[] args) throws Exception {
		OutputStream os = System.out;//모니터 객체를 OutputStream의 구현 객체로 만듬
		for(byte b=48; b<58; b++) { // '0' ~ '9'
			os.write(b);
		}		
//		os.write(13);  //CR (커서가 처음으로 감 ) : 윈도우에서 CR 또는 LF중 하나만 쳐도 다음줄 처음으로감
		os.write(10);  //LF 다음줄 내려감
		
		for(byte b=97; b<123; b++) { // 'a' ~ 'z'
			os.write(b);
		}		
		
		os.write(10);		

		String hangul = "가나다라마바사아자차카타파하";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
		os.flush();
	}
}


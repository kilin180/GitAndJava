package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample3 {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		byte[] data = "ABC".getBytes();
		os.write(data, 1, 2);
		os.flush(); //출력 버퍼에 남은 데이터를 처리함 => 버퍼를 비움 , close()전 
		os.close();
	}

}

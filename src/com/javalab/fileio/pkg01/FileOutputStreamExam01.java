package com.javalab.fileio.pkg01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * - write() 메소드를 사용해서 1byte씩 write함.
 */

public class FileOutputStreamExam01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			File file = new File("c:/filetest/test1.txt");
			fos = new FileOutputStream(file);
			
			byte a = 65; // A
			byte b = 66; // B
			byte c = 67; // C
			
			fos.write(a); // 1byte 사용
			fos.write(b); // 1byte 사용
			fos.write(c); // 1byte 사용
			
			fos.flush(); // 아직 써지지 않은 내용 비움(파일에 씀)
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("파일의 자원을 닫다가 오류남 : " + e.getMessage());
				}
			}
		}
	}
}
package com.javalab.fileio.pkg01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileInputStream 예제
 * - read(byte[] b) : byte[] 배열을 통해서 한꺼번에 읽어들임. 성능이 개선됨.
 */

public class FileInputStreamExam02 {

	public static void main(String[] args) {
		// FileInputStream을 try 문 밖으로 뺌.
		FileInputStream fis = null;
		
		try {
			// 자바 프로그램 에서 사용할 파일 객체 생성
			// file객체의 생성자에 "파일이 위치한 경로와 파일명 전달"
			File file = new File("C:/filetest/123.txt"); // "C:/filetest/123.txt"
			fis = new FileInputStream(file); // 읽어들이는 빨대가 파일에 꽂힘
			
			// read()메소드에 파라미터로 전달됨
			byte[] data = new byte[100];
			
			// 반복해서 데이터 읽어들임
			while(true) {
				int num = fis.read(data); // 100byte를 한꺼번에 읽어들임. 읽은 갯수를 num에 저장
				if(num == -1) break; // 계속 읽어들이다가 -1(즉, 파일의 끝)이 오면 종료
				
				for (int i = 0; i < num; i++) {
					System.out.print((char)data[i]);
				}
			}
			
			// 자원 종료
			//is.close();
		} catch (FileNotFoundException e) { // 혹시 파일이 존재하지 않을 경우의 오류 대비
			e.printStackTrace();
		}catch (IOException e) { // 파일을 읽어들이다가 생길지 모르는 오류 대비(예외 처리)
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch (IOException e) {
					System.out.println("파일의 자원을 닫다가 오류남 : " + e.getMessage());
				}
			}
		}
	}
}
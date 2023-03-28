package com.javalab.fileio.pkg03;

import java.io.*;

/**
 * 문자 입출력 FileReader, BufferedReader 클래스
 * 문자를 2byte 씩
 */

public class BufferedReaderEx1 {

	public static void main(String[] args) {

		try {
			File file = new File("C:/filetest/123.txt"); // 절대경로 
			FileReader fr = new FileReader(file); // 파일을 읽어들임
			BufferedReader br = new BufferedReader(fr); // 메모리 로 사용, 성능향상
/*
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(i + ":" + line);
			}
*/
			int lineNo = 1;
			while(true) {
				String str = br.readLine(); // 한 행을 읽어들임
				if(str == null) break; // while문 빠져나감
				System.out.println(lineNo + "\t" + str);
				lineNo++;
			}

			br.close();
		} catch (IOException e) {

		}
	}
}
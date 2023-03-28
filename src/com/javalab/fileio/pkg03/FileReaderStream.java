package com.javalab.fileio.pkg03;

/**
 * FileReader + BufferedReader 사용
 * 읽어들인 데이터를 Stream<E> 스트림 저장해서 처리
 */

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileReaderStream {

	// jvm이 메인을 불르고 예외를 jvm에 던져준다
	public static void main(String[] args) throws IOException { 

		Path path = Paths.get("src/com/javalab/fileio/pkg03/linedata.txt");
		Stream<String> stream;

		// File 객체가 반환됨
		File file = path.toFile();
		// FileReader 객체 생성(빨대 꽂음)
		FileReader fileReader = new FileReader(file);
		// 메모리 버퍼를 통해서 읽어들이는 신무기 장착(FileReader필요함)
		BufferedReader br = new BufferedReader(fileReader);

		// BufferedReader의 lines() 메소드 이용해서 읽어들이고 Stream<String>에 저장
		stream = br.lines();

		// Stream반복
		stream.forEach(System.out :: println);
		// stream.forEach(s -> {System.out.println(s);});
		// stream.forEach(s -> System.out.println(s));

		// Stream반납
		stream.close();
	}
}
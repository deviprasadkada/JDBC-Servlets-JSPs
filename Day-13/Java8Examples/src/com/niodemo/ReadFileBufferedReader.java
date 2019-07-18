package com.niodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// lines() to have BufferedReader return the content as Stream

public class ReadFileBufferedReader{

	public static void main(String args[]) {

		String fileName = "src/lines.txt";
		List<String> list = new ArrayList<>();

		// try-with-resources	
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

	}

}
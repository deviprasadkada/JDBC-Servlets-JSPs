package com.niodemo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Scanner + try-with-resources

public class ReadFileScanner {

	public static void main(String args[]) {

		String fileName = "src/lines.txt";

		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
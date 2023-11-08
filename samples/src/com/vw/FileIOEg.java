package com.vw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOEg {

	public static void main(String[] args) {
		try {
//			FileWriter fw = new FileWriter("myfile.txt");
//			fw.write("Hello");
//			fw.close();


			BufferedReader br  = new BufferedReader(new FileReader("myFile.txt"));
			String line;
			while((line = br.readLine()) !=null) {
				System.out.println(line);
			}
			br.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

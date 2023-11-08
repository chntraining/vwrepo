package com.vw;

import java.io.*;

public class IOEg {

	public static void main(String[] args) {
		try {
			int x, y, z;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter X");
			x = Integer.parseInt(br.readLine());
			System.out.println("Enter y");
			y = Integer.parseInt(br.readLine());

			z = x + y;
			System.out.println(z);
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

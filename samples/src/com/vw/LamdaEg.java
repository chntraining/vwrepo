package com.vw;

interface Calculate {
	
	public void sub(int a,int b);
}

public class LamdaEg 
{
	public static void main(String[] args) {

		Calculate res = (a, b) -> {
			System.out.println(a - b);
		};
		res.sub(40, 20);
	}

}

package com.vw.pack;

import java.util.Arrays;

public class SeqnParStream {

	public static void main(String[] args) {
		
		int[] values = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(values);
		
		int sumseq =Arrays.stream(values)
			.map(n -> n +n )
			.sum();
		System.out.println("sumseq " + sumseq);
		
		int sumpar =Arrays.stream(values)
				.parallel()
				.map(n -> n +n )
				.sum();
		System.out.println("sumpar " + sumpar);

	}

}

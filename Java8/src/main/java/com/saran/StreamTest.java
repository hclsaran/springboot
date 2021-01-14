package com.saran;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StreamTest {

	
	public static void main(String[] args) {
		int[] numbers= {3,5,2,7,9,5};
		int min=numbers[0];
		for(int i=1;i<numbers.length;i++) {
			if(min>numbers[i]) {
				min=numbers[i];
			}
		}
		System.out.println("Minimum is "+min);
		System.out.println(IntStream.of(numbers).min().getAsInt());
		
		IntStream.of(numbers)
		.min()
		.ifPresent(System.out::println);
		
		IntStream.of(numbers).max();
		IntStream.of(numbers).average();
		IntStream.of(numbers).count();
		IntStream.of(numbers).sum();
		
		IntSummaryStatistics st=IntStream.of(numbers).summaryStatistics();
		st.getMin();
		st.getMax();
		st.getAverage();
		st.getCount();
		st.getSum();
		System.out.println("____________________________");
		int[] num= {5,2,3,8,4};
		int[] copy=Arrays.copyOf(num, num.length); //avoid mutating with orignal array
		Arrays.sort(copy);
		for(int temp:copy) {
			System.out.println(temp);
		}
		
	}
	
	   //with java8 Streams
	   
}



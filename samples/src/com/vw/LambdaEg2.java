package com.vw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaEg2 {

	public static void main(String[] args) {
		//Java 7 - way1
//		PrintingTask t1 = new PrintingTask();
//		t1.print();
		
		//Java 7 - way 2
//		Runnable r = new PrintThread();
//		Thread t = new Thread(r);
//		t.start();		 
//		
		//Java 7 - way3
//		Runnable r1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				PrintingTask t2 = new PrintingTask();
//				t2.print();
//				
//			}
//		};
//		Thread t3 = new Thread(r1);
//		t3.start();	
		
		//Java 8 - way 1
		Runnable r3 = () -> {
			PrintingTask t2 = new PrintingTask();
			t2.print();
			
		};
		Thread t4 = new Thread(r3);
		t4.start();
		
		//Java 8 - way 2
		Thread t5= new Thread(() -> {
			PrintingTask t2 = new PrintingTask();
			t2.print();
			
		});
		t5.start();
		
		//Java 8 - way 3
		new Thread(() -> {
			PrintingTask t2 = new PrintingTask();
			t2.print();
			
		}).start();
		
		//Java 8 - way 4
		new Thread(() -> {
			new PrintingTask().print();			
		}).start();
		
		//Java 8 - way 5
		new Thread(() -> new PrintingTask().print()).start();
		
		//Java 8 - way 6  - Method Reference
		new Thread(new PrintingTask()::print).start();
		
		User u1 = new User(11,"Ram","ram@gmail.com");
		User u2 = new User(13,"Shiva","shiva@gmail.com");
		User u3 = new User(12,"Asha","asha@gmail.com");
		
		List<User> userList = new ArrayList<User>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		System.out.println(userList);
		
		Iterator<User> ui = userList.iterator();
		while(ui.hasNext()) {
			System.out.println(ui.next());
		}
		
		userList.forEach(li -> System.out.println(li));
		
		Function<Integer,String> evenodd = (num)->{
			if(num%2==0) {
				return num + " is even.";
			}
			else {
				return num + " is odd.";
			}
		};
		System.out.println(evenodd.apply(50));
		
		Supplier<String> s=() -> {
			return "Priya";
		};
		System.out.println(s.get());
		
		BiPredicate<String, String>  res=(un,pw) ->un.equals(pw);
		System.out.println(res.test("Anu", "Anun"));
		
		
		if(res.test("Anu", "Anu")) {
			System.out.println("Welcome Anu" );
		}
		else
		{
			System.out.println("Welcome Guest");
		}
		
		
	}

}

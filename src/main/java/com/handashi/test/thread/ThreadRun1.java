package com.handashi.test.thread;

public class ThreadRun1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest1 t1 = new ThreadTest1();
		ThreadTest1 t2 = new ThreadTest1();
		
//		t1.setName("스레드1"); // 안됨.
//		t2.setName("스레드2");
		
		t1.run();
		t2.run();
	}

}

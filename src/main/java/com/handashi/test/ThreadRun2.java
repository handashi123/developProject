package com.handashi.test;

public class ThreadRun2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest2 tt2 = new ThreadTest2(100);
		ThreadTest2 tt21 = new ThreadTest2(500);
		
		Thread t1 = new Thread(tt2, "첫번째");
		Thread t2 = new Thread(tt21, "두번째");
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로세스 종료");
		
	}

}

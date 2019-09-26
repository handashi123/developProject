package com.handashi.test.thread;

public class ThreadTest2 implements Runnable {
	
	private int num = 10;
	private int sleep;
	
	public ThreadTest2(int sleep) {
		this.sleep = sleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//		for(int i = 0; i < 10; i++) {
//			
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + " 스레드의 " + i);
//			
//		}
		
		printName(sleep);
		
		roopMethod();
		
		System.out.println(Thread.currentThread().getName() + " 스레드 종료");
		
	}
	
	private void printName(int sleep) {
		while(num > 0) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " 스레드의 " + num);
			num--;
		}
	}
	
	private void roopMethod() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +"무한루프 중...");
		}
		
	}

}

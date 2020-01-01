package com.handashi.test.thread;

public class ThreadTest1 extends Thread{

	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
			for(int i = 0; i < 10; i++) {
				sleep(500);
				
				System.out.println(currentThread().getName() + "thread 실행 : " + i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

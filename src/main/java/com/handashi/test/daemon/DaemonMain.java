package com.handashi.test.daemon;

public class DaemonMain{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CommonCount commonCount = new CommonCount();
		commonCount.setCommonCount(10);
		
		DaemonThread de = new DaemonThread(commonCount);
		
		
		
		/*Thread t1 = new Thread(de);
		Thread t2 = new Thread(de);
		Thread t3 = new Thread(de);
		
		t1.setName("스레드0");
		t2.setName("스레드1");
		t3.setName("스레드2");
		
		t1.start();
		t2.start();
		t3.start();*/
		
		for (int i = 0; i < 5; i++) {

			Thread t = new Thread(de);

			t.setName("스레드 " + i);

//			t.setDaemon(true);
			t.start();

		}
		// 중간에 값 변경해서 테스트
		Thread.currentThread().sleep(2000);
		commonCount.setCommonCount(100);
		
		
		System.out.println("main 종료");
	}

}

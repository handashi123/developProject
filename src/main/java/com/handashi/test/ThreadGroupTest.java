package com.handashi.test;

public class ThreadGroupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup tGroup1 = new ThreadGroup("tGroup1");
		ThreadGroup tGroup1_1 = new ThreadGroup(tGroup1, "tGroup1_1");
		ThreadGroup tGroup2 = new ThreadGroup("tGroup2");
		
		new Thread(Thread.currentThread().getThreadGroup(), new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, "mainThread").start();
		
		new Thread(tGroup1, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("tGroup1");
			}
		}).start();
		
		new Thread(tGroup1_1, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("tGroup1_1");
			}
		}).start();
		
		new Thread(tGroup2, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("tGroup2");
			}
		}).start();
		
		
		
		main.list();
		
		
	}

}

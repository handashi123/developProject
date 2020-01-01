package com.handashi.test.daemon;

public class DaemonThread implements Runnable {
	
	private CommonCount commonCount;
	private boolean isRun = true; 
	
	public DaemonThread(CommonCount commonCount) {
		this.commonCount = commonCount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.currentThread().isInterrupted()) {
			
				minusCount();
			
			}				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(Thread.currentThread().getName() + " : interrupte 발생 : " + e.getMessage());
		}finally {
			System.out.println(Thread.currentThread().getName() + " : 종료...");
		}
		
				
	}
	
	private void minusCount() throws Exception{
		
		while(isRun) {
			
			synchronized(this) {
				System.out.println("================="+Thread.currentThread().getName()+": 공통 count : " + commonCount.getCommonCount());
				if(commonCount.getCommonCount() <= 0) {
//					isRun = false;
//					Thread.currentThread().interrupt();
				}else {
					commonCount.minusCount();
					System.out.println(Thread.currentThread().getName() + " : count : " + commonCount.getCommonCount());
				}								
				
			}

			Thread.sleep(1000);
		}
		
		
		
	}
}

package com.hhxx.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread{
	
	private CyclicBarrier barrier;
	
	private String name;
	
	private int count;
	
	public CyclicBarrierThread(String name,CyclicBarrier barrier) {
		this.name=name;
		this.barrier=barrier;
		this.count=0;
	}
	
	public void run() {
		try {
			for(int i=0;i<3;i++) {
				
				Thread.sleep(100);
				count++;
				System.out.println(count+"---"+name+"---"+Thread.currentThread().getName());
				
			}
			barrier.await();//等待其他线程
			System.out.println("继续执行");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出执行线程的名称
		//System.out.println("TaskName"+this.getTaskName()+"---ThreadName:"+Thread.currentThread().getName());
	}
}

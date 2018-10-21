package com.hhxx.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
	
	public static void main(String[] args) {
		
		CyclicBarrier cb=new CyclicBarrier(3,new Runnable() {
			public void run()
			{
				System.out.println("集合");
			}
		});
		CyclicBarrierThread	runTask; //= new CyclicBarrierThread(0+"",cb);
		for(int i=0;i<3;i++) {
			//runTask= new CyclicBarrierThread(0+"",cb);
		    //runTask=new CyclicBarrierThread(i+"",cb);
			new CyclicBarrierThread(0+"",cb).start();
			

		}

		
	}
	

}


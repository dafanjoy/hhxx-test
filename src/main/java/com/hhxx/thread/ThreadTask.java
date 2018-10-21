package com.hhxx.thread;
/**
 * Nthreads=CPU数量
 * Ucpu=目标CPU的使用率，0<=Ucpu<=1
 * W/C=任务等待时间与任务运行时间的比率
 * Nthreads = Ncpu*Ucpu*(1+W/C)
 */

public class ThreadTask implements Runnable{	
	private String taskName;
	
	private volatile int count=0;
	
    ThreadLocal<Integer> seqNum =new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
     };
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public ThreadTask() {

	}
	
	public void init(String s) {
		this.taskName=s;
	}
	
	public void run() {
		try {
			System.out.println(seqNum.hashCode()+"");
			for(int i=0;i<10;i++) {
				seqNum.set(i);
				count++;
				Thread.sleep(10);
				System.out.println(seqNum.get()+"---"+count+""+Thread.currentThread().getName());
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出执行线程的名称
		//System.out.println("TaskName"+this.getTaskName()+"---ThreadName:"+Thread.currentThread().getName());
	}
}

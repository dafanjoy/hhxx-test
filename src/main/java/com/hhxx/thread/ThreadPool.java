package com.hhxx.thread;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	private static ExecutorService pool;
	

    public static void main( String[] args ) throws InterruptedException
    {
        ThreadLocal<Integer> seqNum =new ThreadLocal<Integer>() {
            public Integer initialValue() {
                return 0;
            }
         };
    	//实现自定义接口
    	pool = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5),
				new ThreadFactory() {
    		public Thread newThread(Runnable r) {
    			System.out.println("线程"+r.hashCode()+"创建");
    			//线程命名
    			Thread th = new Thread(r,"threadPool"+r.hashCode());
    			return th;
    		}
    	}, new ThreadPoolExecutor.CallerRunsPolicy()) {
    
    		protected void beforeExecute(Thread t,Runnable r) {
    			//System.out.println("准备执行："+ ((ThreadTask)r).getTaskName());
    		}
    		
	        protected void afterExecute(Runnable r,Throwable t) {
	        	System.out.println("执行完毕："+((ThreadTask)r).getTaskName());
    		}
	        
            protected void terminated() {
            	System.out.println("线程池退出");
    		}
    	};
    	ThreadTask task;
    	for(int i=0;i<5;i++) {
    		task = new ThreadTask();
//    		if(i==5) {
//    			pool.shutdown();
//    		}
//    		seqNum.set(i);
//    		task.init(i+"");
    		pool.execute(task);
    		
    	}	
    	//安全关闭线程池
    	pool.shutdown();
    }
}





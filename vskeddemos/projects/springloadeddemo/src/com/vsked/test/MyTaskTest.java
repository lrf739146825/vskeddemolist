package com.vsked.test;

import com.vsked.task.MyTask;

public class MyTaskTest {
	
	public static void main(String[] args) {
		MyTask task1=new MyTask();
		Thread t1=new Thread(task1);
		t1.start();
	}

}

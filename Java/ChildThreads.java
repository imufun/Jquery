import java.util.*;
import java.lang.*;


// class ChildThreads implements Runnable
// {
	// Thread tl;
	// ChildThread(String names)
	// {
		// tl = new Thread(this, names);
		// tl.setDaemon(true);
		// tl.start();
	// }
	// public void run(){
	// try{
		// while(true){
			// System.out.println(“This thread is a daemon threads: “+tl.isDaemon());
			// System.out.println(tl.getName()+“: Hiya”);
			// Thread.sleep(1000);
		  // }
		// }
	// catch(InterruptedException e){
		// System.out.println(“Child thread is interrupted by excpetion”);
		// }
	// }
// }
// class DaemonThread
// {
	// public static void main(String args[])
	// {
	// ChildThread one = new ChildThreads(“Daemon Thread”);
	// }
// }

 class ChildThreads implements Runnable{
	
	
	  Thread tl;
	
	  ChildThreads(String names){
		  tl.setDaemon(true);
		  tl.start();
	  }
	
	  public void run(){
		  try{
			  while(true){
				  System.out.println("This is a daemon Thread." + tl.isDaemon());
				  System.out.println(tl.getName() + ": imran");
				 Thread.sleep(1000);
			  }
		 }catch(InterruptedException e){
			  System.out.println("Child thread is interrupted by excpetion");
		 }
	  }
 }
	 
	class DaemonThread{
		 public static void main(String args[]){					
			ChildThreads one = new  ChildThreads("Daemon Thread");		  
		}	 
	}	
 
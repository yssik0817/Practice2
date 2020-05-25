package source.Chapter13;

class SuperThreadPriority extends Thread{ 
	public SuperThreadPriority(String threadName){ 
		super(threadName); 
	} 
	public void run(){ 
		System.out.printf("스레드 이름 : %s %n", 
				Thread.currentThread().getName()); 
	} 
} 
public class PriorityChangeEx extends SuperThreadPriority{ 
	public PriorityChangeEx(String threadName){ 
		super(threadName);

	} 
	public static void main(String arg[]){ 
		Thread t1 = new SuperThreadPriority("첫번째 스레드"); 
		t1.setPriority(Thread.MIN_PRIORITY); 	//우선순위 마지막
		t1.start(); 
		Thread t2 = new SuperThreadPriority("두번째 스레드"); 
		t2.setPriority(Thread.MAX_PRIORITY); 	//우선순위 먼저
		t2.start(); 
	} 
} 

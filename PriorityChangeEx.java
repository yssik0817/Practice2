package source.Chapter13;

class SuperThreadPriority extends Thread{ 
	public SuperThreadPriority(String threadName){ 
		super(threadName); 
	} 
	public void run(){ 
		System.out.printf("������ �̸� : %s %n", 
				Thread.currentThread().getName()); 
	} 
} 
public class PriorityChangeEx extends SuperThreadPriority{ 
	public PriorityChangeEx(String threadName){ 
		super(threadName);

	} 
	public static void main(String arg[]){ 
		Thread t1 = new SuperThreadPriority("ù��° ������"); 
		t1.setPriority(Thread.MIN_PRIORITY); 	//�켱���� ������
		t1.start(); 
		Thread t2 = new SuperThreadPriority("�ι�° ������"); 
		t2.setPriority(Thread.MAX_PRIORITY); 	//�켱���� ����
		t2.start(); 
	} 
} 

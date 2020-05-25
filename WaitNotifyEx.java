package source.Chapter13;


public class WaitNotifyEx{ 
	public static void main(String[] args){ 
		ATM2 atm = new ATM2(); 
		Thread mother = new Thread(atm,"mother"); 
		Thread son = new Thread(atm,"son"); 
		mother.start(); 
		son.start(); 
	} 
} 


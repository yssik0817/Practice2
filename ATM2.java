package source.Chapter13;

public class ATM2 implements Runnable {
	private long depositeMoney=10000;
	
	public void run(){
		synchronized(this){
			for(int i=0;i<10; i++) {
				if(getDepositeMoney()<=0) break;
				withDraw(1000);
				if(getDepositeMoney()==2000 ||
						getDepositeMoney()==4000 ||
						getDepositeMoney()==6000 ||
						getDepositeMoney()==8000 ) {
					try {
						this.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					this.notify();
				}
			}
		}
	}
	public void withDraw(long howMuch) {
		if(getDepositeMoney()>0){
			depositeMoney -=howMuch;
			System.out.println(Thread.currentThread().getName()+", ");
			System.out.printf("잔액: %,d 원 %n",getDepositeMoney());
		} else {
			System.out.println(Thread.currentThread().getName()+", ");
			System.out.println("잔액이 부족합니다.");
			}
		}
public long getDepositeMoney() {
	return depositeMoney;
}
}
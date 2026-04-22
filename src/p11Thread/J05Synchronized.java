package p11Thread;

public class J05Synchronized {
  public static void main(String[] args) {
    Customer customer = new Customer();
    new Thread(customer,"c1").start();
    new Thread(customer,"c2").start();

  }
}

class Bank{
  private int balance = 1000;
  public int getBalance() {return balance;}

  synchronized public void withdraw(int money){
    if(balance >= money){
     try{Thread.sleep(400);}catch (Exception e){}
      balance -= money;
    }
  }
}

class Customer implements Runnable{
  Bank bank = new Bank();
  @Override
  public void run() {
    while (bank.getBalance() > 0) {
      int money = (int)(Math.random()*3 + 1)*100;
      bank.withdraw(money);
      System.out.println(Thread.currentThread().getName()+" "
      + money + " 인출 후 잔액: " + bank.getBalance());
    }
  }
}

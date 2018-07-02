package practicePackage.orderedCountingUsingTwoTheads;

import java.util.concurrent.Semaphore;

public class MainClass {
    static Semaphore mutex = new Semaphore(1);

    /*
    public static void main(String [] args){
        PrintTillN odd = new PrintTillN(1,8);
        PrintTillN even = new PrintTillN(2,8);
        odd.start();
        even.start();
    }
    */

    static class PrintTillN extends Thread{
        private long to;
        private long from;
        public PrintTillN(long from, long to){
            this.to = to;
            this.from = from;
        }
        public void run(){
            long temp = this.from;
            while (temp <= to){
                try {
                    mutex.acquire();
                    System.out.println(temp);
                    temp += 2;
                    mutex.release();
                    sleep(700);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

package practicePackage.orderedCountingUsingTwoTheads;

import java.util.Objects;
import java.util.Scanner;

public class MainClass2 {
    private static Long number;
    private static Long counter = (long)1;
    final private static Object lock = new Object();
    public static void main(String [] args) throws InterruptedException {
        myThread odd = new myThread(true);
        myThread even = new myThread(false);
        number = (new Scanner(System.in)).nextLong();
        even.start();
        odd.start();
        odd.join();
        even.join();
    }
    static class myThread extends Thread{
        boolean init;
        myThread(boolean initState){
            this.init = initState;
        }
        @Override
        public void run(){
            while (true) {
               synchronized (lock) {
                   if (init) {
                       System.out.println(counter++);
                       init = false;
                       lock.notify();
                   } else {
                       try {
                           lock.wait();
                           if(counter > number)
                               break;
                           System.out.println(counter++);
                           lock.notify();
                           if(counter > number)
                               break;
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
            System.out.println("out.");
        }
    }
}

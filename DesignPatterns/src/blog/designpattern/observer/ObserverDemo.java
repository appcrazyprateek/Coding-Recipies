package blog.designpattern.observer;

import java.util.Scanner;



public class ObserverDemo { public static void main(String[] args) throws InterruptedException {
    Subject subject = new Subject();

   // new HexaObserver(subject);
    new OctalObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");	
    subject.setState(15);
    System.out.println("Second state change: 10");	
    subject.setState(10);
    
    Thread t=new Thread();
    t.sleep(3000);
 }}
package jp.mixi.practice.java;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedModel {

  private int hoge;
  private AtomicInteger hogeAtomic;
  private final String PRINTOUT_STR = "--------\ninstanceName: %s\nhoge: %s\n--------\n";

  public SynchronizedModel() {
    this.hoge = 0;
    this.hogeAtomic = new AtomicInteger(0);
  }

  public synchronized void doSomething(String instanceName) {
    System.out.print(String.format(PRINTOUT_STR, instanceName, ++hoge));
    //System.out.print(String.format(PRINTOUT_STR, instanceName, hogeAtomic.incrementAndGet()));
  }
}
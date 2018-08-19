package practice;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

  private static SynchronizedModel model3;

  public static void main(String[] args) {
    System.out.println("Start practice program...");
    System.out.println("Main Started --- Thread Id : " + Thread.currentThread().getId());
    SomeModel model1 = new SomeModel();
//        // TODO: [課題1]以下のコメントアウトを外し、適切にコールバックオブジェクトを渡す
//        // TODO: [課題2]コールバックの onSuccess, onFailure で、標準出力にそれぞれのメソッド名を表示する
    model1.doSomethingRandom(new Callback() {
      @Override
      public void onSuccess() {
        System.out.println("onSuccess!");
      }

      @Override
      public void onFailure() {
        System.out.println("onFailure!");
      }
    });
//
//        // TODO: [課題3]以下のロジックが正しく動くように、AnotherModel の実装を完成させる
    AnotherModel model2 = new AnotherModel();
    int idx = 0;
    final String PRINTOUT_STR = "hogehoge[%s]";
    while (model2.canAddItem()) {
      model2.add(String.format(PRINTOUT_STR, idx++));
    }

    model3 = new SynchronizedModel();

    Runnable runnable1 = () -> {
      System.out.println("runnable1 Started --- Thread Id : " + Thread.currentThread().getId());
      for (int i = 0; i < 5; i++) {
        // TODO: [課題4]model3 の doSomething() を呼び出す
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
          //System.exit(9);
        }
        model3.doSomething("runnable1");
      }
    };

    Runnable runnable2 = () -> {
      System.out.println("runnable2 Started --- Thread Id : " + Thread.currentThread().getId());
      for (int i = 0; i < 5; i++) {
        // TODO: [課題5]model3 の doSomething() を呼び出す
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
          //System.exit(9);
        }
        model3.doSomething("runnable2");
      }
    };


    // TODO: runnable1 と runnable2 を別スレッドで起動する
    Thread thread1 = new Thread(runnable1);
    Thread thread2 = new Thread(runnable2);
    thread2.start();
    thread1.start();

    // TODO: ExecutorServiceを用いて同値なコードを実行する
    ScheduledExecutorService scheduledExecutorService =
        Executors.newScheduledThreadPool(2);

    Future future1 = scheduledExecutorService.submit(thread1);
    System.out.println("Result1 :" + future1.isDone());
    Future future2 = scheduledExecutorService.submit(thread2);
    System.out.println("Result2 :" + future2.isDone());

    while (!future1.isDone() || !future2.isDone()) {
      try {
        System.out.println("Waiting Until Multi Thread finished");
        Thread.sleep(1000);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
    }

    scheduledExecutorService.shutdown();
    System.out.println("Main finished --- Thread Id : " + Thread.currentThread().getId());


  }
}
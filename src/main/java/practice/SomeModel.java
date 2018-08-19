package practice;

public class SomeModel {
    public void doSomethingRandom(Callback callback) {
        double condition = Math.random() * 10;
        System.out.println("condition = " + condition);
        if (condition > 5) {
            callback.onSuccess();
        } else {
            callback.onFailure();
        }
    }
}
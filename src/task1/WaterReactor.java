package task1;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WaterReactor {

    static final Random rand = new Random();
    static final Lock lock = new ReentrantLock(true);
    static final Condition oxyWait = lock.newCondition();
    static final Condition hydroWait = lock.newCondition();

    static volatile int hydroCount = 0;
    static volatile int oxyCount = 0;

    public void releaseHydrogen() throws InterruptedException {

        for (int i = 0; ; i++) {
            lock.lock();
            try {
                while (hydroCount == 2) {
                    hydroWait.await();
                }
                hydroCount++;
                System.out.print("H");
                if (oxyCount == 0) {
                    oxyWait.signalAll();
                }
            } finally {
                lock.unlock();
            }
            randomSleep();
        }
    }

    public void releaseOxygen() throws InterruptedException {

        for (int i = 0; ; i++) {
            lock.lock();
            try {
                while (hydroCount < 2 && oxyCount < 2) {
                    oxyWait.await();
                }
                hydroCount = 0;
                System.out.print("O");
                System.out.print(", ");
                hydroWait.signalAll();
            } finally {
                lock.unlock();
            }
            randomSleep();
        }
    }

    public void randomSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException ignored) {
        }

    }
}
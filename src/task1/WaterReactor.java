package task1;

import java.util.concurrent.CyclicBarrier;

public class WaterReactor {
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new MoleculeRelease());

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Hydrogen(Math.random() / 100 + 5)).start();
        Thread.sleep(500L);
        new Thread(new Oxygen(Math.random() / 100 + 5)).start();
        Thread.sleep(500L);
    }

}

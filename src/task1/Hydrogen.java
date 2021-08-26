package task1;

public class Hydrogen implements Runnable{
    private int hCount = 0;
    public final String h = "H";
    public double duration;

    public Hydrogen(double duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("Atom of H added");
        i++;
        if (i == 2) {
            BARRIER.await();
        }
    }
}

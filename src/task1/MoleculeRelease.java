package task1;

public class MoleculeRelease implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Molecule of H2O generated: ");
        } catch (InterruptedException e) {
        }
    }
}


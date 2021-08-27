package task1;

public class ReleaseMolecule {

    public static void main(String[] args) {

        WaterReactor molecules = new WaterReactor();

        try {

            Thread h = new Thread(() -> {
                try {
                    molecules.releaseHydrogen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread o = new Thread(() -> {
                try {
                    molecules.releaseOxygen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            h.start();
            o.start();

        } catch (Exception ignored) {
        }
    }
}

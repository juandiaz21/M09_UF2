import java.util.Random;

public class Fumador implements Runnable {
    private final Estanc estanc;
    private final int id;
    private int fumades = 0;
    private final Random random = new Random();

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    private void comprarTabac() {
        synchronized (estanc) {
            while (!estanc.venTabac()) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fumador " + id + " comprant Tabac");
            estanc.notifyAll();
        }
    }

    private void comprarPaper() {
        synchronized (estanc) {
            while (!estanc.venPaper()) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fumador " + id + " comprant Paper");
            estanc.notifyAll();
        }
    }

    private void comprarLlumi() {
        synchronized (estanc) {
            while (!estanc.venLlumi()) {
                try {
                    estanc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Fumador " + id + " comprant Llumí");
            estanc.notifyAll();
        }
    }

    private void fumar() {
        try {
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + random.nextInt(500)); // Fumar entre 0,5 y 1s
            fumades++;
            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (fumades < 3) {
            comprarTabac();
            comprarPaper();
            comprarLlumi();
            fumar();
        }
    }
}

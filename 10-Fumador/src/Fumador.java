import java.util.Random;

public class Fumador implements Runnable {
    private final Estanc estanc;
    private final int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int fumades = 0;
    private final Random random = new Random();

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    private void comprarTabac() {
        synchronized (estanc) {
            while (tabac == null) {
                if (estanc.venTabac()) {
                    tabac = new Tabac();  
                    System.out.println("Fumador " + id + " comprant Tabac");
                } else {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            estanc.notifyAll();
        }
    }

    private void comprarPaper() {
        synchronized (estanc) {
            while (paper == null) {
                if (estanc.venPaper()) {
                    paper = new Paper();  
                    System.out.println("Fumador " + id + " comprant Paper");
                } else {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            estanc.notifyAll();
        }
    }

    private void comprarLlumi() {
        synchronized (estanc) {
            while (llumi == null) {
                if (estanc.venLlumi()) {
                    llumi = new Llumi(); 
                    System.out.println("Fumador " + id + " comprant Llumí");
                } else {
                    try {
                        estanc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            estanc.notifyAll();
        }
    }

    private void fumar() {
        try {
            if (tabac != null && paper != null && llumi != null) {
                System.out.println("Fumador " + id + " fumant");
                Thread.sleep(500 + random.nextInt(500)); 
                fumades++;
                System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");

                tabac = null;
                paper = null;
                llumi = null;
            }
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

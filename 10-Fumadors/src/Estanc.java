import java.util.Random;

public class Estanc {
    private int tabac = 0;
    private int paper = 0;
    private int llumi = 0;
    private boolean tancat = false;
    private final Random random = new Random();

    public synchronized void nouSubministrament() {
        if (tancat) return;

        int producte = random.nextInt(3);
        switch (producte) {
            case 0:
                addTabac();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addLlumi();
                break;
        }
        notifyAll();
    }

    public synchronized void addTabac() {
        tabac++;
        System.out.println("Afegint Tabac");
    }

    public synchronized void addPaper() {
        paper++;
        System.out.println("Afegint Paper");
    }

    public synchronized void addLlumi() {
        llumi++;
        System.out.println("Afegint Llumí");
    }

    public synchronized boolean venTabac() {
        if (tabac > 0) {
            tabac--;
            return true;
        }
        return false;
    }

    public synchronized boolean venPaper() {
        if (paper > 0) {
            paper--;
            return true;
        }
        return false;
    }

    public synchronized boolean venLlumi() {
        if (llumi > 0) {
            llumi--;
            return true;
        }
        return false;
    }

    public synchronized void tancarEstanc() {
        tancat = true;
        notifyAll();
        System.out.println("Estanc tancat");
    }

    public void executar() {
        System.out.println("Estanc obert");
        while (!tancat) {
            try {
                Thread.sleep(500 + random.nextInt(1000)); // Espera entre 0,5 y 1,5s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nouSubministrament();
        }
    }
}

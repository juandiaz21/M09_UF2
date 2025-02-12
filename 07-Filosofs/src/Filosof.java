import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana = 0;
    private final Random random = new Random();

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof: fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); 
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (esquerra.agafar(id, false)) {
                if (dreta.agafar(id, true)) {
                    System.out.println("Filosof: fil" + id + " menja");
                    Thread.sleep(random.nextInt(1000) + 1000); 
                    System.out.println("Filosof: fil" + id + " ha acabat de menjar");
                    dreta.deixar();
                    esquerra.deixar();
                    gana = 0;
                    return;
                } else {
                    esquerra.deixar();
                    gana++;
                    System.out.println("Filosof: fil" + id + " deixa l'esquerra(" + esquerra.getId() + ") i espera (dreta ocupada)");
                    System.out.println("Filosof: fil" + id + " gana=" + gana);
                }
            } else {
                gana++;
                System.out.println("Filosof: fil" + id + " no pot agafar l'esquerra(" + esquerra.getId() + "), espera");
                System.out.println("Filosof: fil" + id + " gana=" + gana);
            }
            Thread.sleep(random.nextInt(500) + 500); 
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                menjar();
                pensar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

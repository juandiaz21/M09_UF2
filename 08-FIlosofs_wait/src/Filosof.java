import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private int gana = 0;
    private final Random random = new Random();

    public Filosof(int id, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.id = id;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000);
    }

    private void agafarForquillaEsquerra() throws InterruptedException {
        forquillaEsquerra.agafar(id);
    }

    private void agafarForquillaDreta() throws InterruptedException {
        forquillaDreta.agafar(id);
    }

    private void deixarForquilles() {
        forquillaEsquerra.deixar(id);
        forquillaDreta.deixar(id);
    }

    private boolean agafarForquilles() throws InterruptedException {
        agafarForquillaEsquerra();
        
        if (forquillaDreta.getPropietari() != -1) {  
            System.out.println("Filòsof: fil" + id + " deixa l'esquerra (" + forquillaEsquerra.getId() + ") i espera (dreta ocupada)");
            forquillaEsquerra.deixar(id);
            gana++;
            System.out.println("Filòsof: fil" + id + " gana=" + gana);
            Thread.sleep(random.nextInt(500) + 500);
            return false;
        }

        agafarForquillaDreta();
        return true;
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (agafarForquilles()) {
                System.out.println("Filòsof: fil" + id + " menja");
                Thread.sleep(random.nextInt(1000) + 1000);
                System.out.println("Filòsof: fil" + id + " ha acabat de menjar");
                deixarForquilles();
                gana = 0;
                return;
            }
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

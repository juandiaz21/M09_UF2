import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private long iniciGana;
    private long fiGana;
    private long gana;
    private final Random random = new Random();

    public Filosof(int id, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.id = id;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); 
    }

    private void menjar() throws InterruptedException {
        agafarForquilles();
        fiGana = System.currentTimeMillis();
        gana = calcularGana();
        System.out.println("Fil" + id + " menja amb gana " + gana + " segons");
        Thread.sleep(random.nextInt(1000) + 1000); 
        resetGana();
        deixarForquilles();
    }

    private void agafarForquilles() throws InterruptedException {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    private void agafarForquillaEsquerra() throws InterruptedException {
        forquillaEsquerra.agafar();
        System.out.println("Fil" + id + " agafa forquilla forquillaEsquerra (" + forquillaEsquerra.getId() + ")");
    }

    private void agafarForquillaDreta() throws InterruptedException {
        while (!forquillaDreta.intentarAgafar()) {
            forquillaEsquerra.deixar();
            System.out.println("Fil" + id + " deixa forquilla forquillaEsquerra (" + forquillaEsquerra.getId() + ")");
            Thread.sleep(random.nextInt(500) + 500);
            agafarForquillaEsquerra();
        }
        System.out.println("Fil" + id + " agafa forquilla forquillaDreta (" + forquillaDreta.getId() + ")");
        System.out.println("Fil" + id + " té forquilles esq(" + forquillaEsquerra.getId() + ") forquillaDreta(" + forquillaDreta.getId() + ")");
    }

    private void deixarForquilles() {
        deixarForquillaDreta();
        deixarForquillaEsquerra();
    }

    private void deixarForquillaDreta() {
        forquillaDreta.deixar();
        System.out.println("Fil" + id + " deixa forquilla forquillaDreta (" + forquillaDreta.getId() + ")");
    }

    private void deixarForquillaEsquerra() {
        forquillaEsquerra.deixar();
        System.out.println("Fil" + id + " deixa forquilla forquillaEsquerra (" + forquillaEsquerra.getId() + ")");
    }

    private long calcularGana() {
        return (fiGana - iniciGana) / 1000;
    }

    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                iniciGana = System.currentTimeMillis(); 
                menjar(); 
                pensar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
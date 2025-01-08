import java.util.Random;

public class DormAleatori extends Thread{
    private long creationTime;
    //private String nom;
    
    public DormAleatori(String nom) {
        super(nom); 
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int intervalRandom = random.nextInt(1000); 
            long tempsTotal = System.currentTimeMillis() - creationTime;
            System.out.print(getName() + "("+ i + ") a dormir " + intervalRandom + "ms total " + tempsTotal + "ms\n");
            try {
                Thread.sleep(intervalRandom);
            } catch (InterruptedException e) {
                System.err.println(getName() + "interrumpido.");
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori juan = new DormAleatori("Juan");
        DormAleatori pep = new DormAleatori("Pep");
        juan.start();
        pep.start();
        //para que salga despues del primer intervalo...
        try {
            Thread.sleep(10); 
        } catch (InterruptedException e) {
            System.err.println("El main fue interrumpido.");
        }

        System.out.println("-- Fi de main -----------");
    }
}


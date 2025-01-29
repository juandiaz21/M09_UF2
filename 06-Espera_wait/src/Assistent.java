import java.util.Random;

public class Assistent extends Thread{
    Esdeveniment esdeveniment;
    private String nom;
    private final Random random = new Random();


    public Assistent(String nom, Esdeveniment esdeveniment){
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nom + " ha estat interromput.");
        }
    }

    public String getNom(){
        return nom;
    }
}

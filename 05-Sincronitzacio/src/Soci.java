import java.util.Random;

public class Soci implements Runnable{
    private Compte compte;
    private float aportacio = 10.0f;
    private int esperaMax = 100;
    private Random rnd;
    private int maxAnys = 10;

    
    public Soci() {
        this.compte = Compte.getInstance();
        this.rnd = new Random();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        
        for (int i = 0; i<maxAnys; i++){
            for (int j = 1; j<=12 ; j++){
                synchronized(compte){
                    if (j%2 == 0){
                        compte.setSaldo(aportacio);
                    }else{
                        compte.setSaldo(-aportacio);
                    }
                }
                try{
                    Thread.sleep(rnd.nextInt(esperaMax));
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } 
    }
}
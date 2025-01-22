public class Associacio {
    private static final int numSocis = 1000;
    private Soci[] socis;


    public Associacio() {
        this.socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        Thread[] fils = new Thread[numSocis];
        for (int i = 0; i < numSocis; i++) {
            fils[i] = new Thread(socis[i], "Soci-" + i);
            fils[i].start();
        }
    
        esperaPeriodeSocis(fils);
    }

    public void esperaPeriodeSocis(Thread[] fils) {
        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void mostraBalancComptes() {
        System.out.println("Saldo: " + Compte.getInstance().getSaldo());
    }
    
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.mostraBalancComptes();
    }

}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Barber extends Thread {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                try {
                    client.tallarseElCabell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                synchronized (barberia.getCondBarber()) {
                    try {
                        System.out.println("Barber " + nom + " dormint");
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class BarberiaMandrosa {
    public static void main(String[] args) throws InterruptedException {
        Barberia barberia = Barberia.getInstance(3);
        Barber barber = new Barber("Pepe", barberia);
        barber.start();

        // Simulació d'entrada de clients
        for (int i = 1; i <= 10; i++) {
            Client client = new Client(i);
            barberia.entrarClient(client);
            Thread.sleep(500);  // Un client cada 0.5 segons
        }

        // Espera 10 segons abans d'introduir més clients
        Thread.sleep(10000);

        for (int i = 11; i <= 20; i++) {
            Client client = new Client(i);
            barberia.entrarClient(client);
            Thread.sleep(500);  // Un client cada 0.5 segons
        }
    }
}


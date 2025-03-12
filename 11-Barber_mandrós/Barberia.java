import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private Queue<Client> salaEspera;
    private final int numCadires;
    private final Object condBarber;
    private static Barberia instancia;

    private Barberia(int numCadires) {
        this.salaEspera = new LinkedList<>();
        this.numCadires = numCadires;
        this.condBarber = new Object();
    }

    public static Barberia getInstance(int numCadires) {
        if (instancia == null) {
            instancia = new Barberia(numCadires);
        }
        return instancia;
    }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < numCadires) {
            salaEspera.add(client);
            synchronized (condBarber) {
                condBarber.notify();
            }
            System.out.println("Client " + client.getNom() + " en espera");
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }

    public Client seguentClient() {
        return salaEspera.poll();
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public boolean salaEsperaVacia() {
        return salaEspera.isEmpty();
    }

    public void executar() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Client client = new Client(i);
            entrarClient(client);
            Thread.sleep(500);
        }

        Thread.sleep(10000);

        for (int i = 11; i <= 20; i++) {
            Client client = new Client(i);
            entrarClient(client);
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Barberia barberia = Barberia.getInstance(3);

        Barber barber = new Barber("Juan:)", barberia);
        barber.start();

        barberia.executar();
    }
}

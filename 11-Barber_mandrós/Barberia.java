public class Barberia {
    private Queue<Client> salaEspera;
    private final int numCadires;
    private final Object condBarber;
    private static Barberia instancia;

    public static Barberia getInstance(int numCadires) {
        if (instancia == null) {
            instancia = new Barberia(numCadires);
        }
        return instancia;
    }

    public Barberia(int numCadires) {
        this.salaEspera = new LinkedList<>();
        this.numCadires = numCadires;
        this.condBarber = new Object();
    }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < numCadires) {
            salaEspera.add(client);
            synchronized (condBarber) {
                condBarber.notify();  // Desperta al barber
            }
            System.out.println("Client " + client.getNom() + " en espera");
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }

    public Client seguentClient() {
        return salaEspera.poll();  // Treu el primer client de la cua
    }

    public Object getCondBarber() {
        return condBarber;
    }
}

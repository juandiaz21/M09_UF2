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
                    if (barberia.salaEsperaVacia()) {
                        System.out.println("Ningú en espera");
                    }
                    System.out.println("Barber " + nom + " dormint");
                    try {
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

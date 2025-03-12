public class Client {
    private String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public void tallarseElCabell() throws InterruptedException {
        System.out.println("Tallant cabell a " + this.nom);
        Thread.sleep(900 + new Random().nextInt(100));  // Temps aleatori entre 0.9s i 1.0s
    }

    public String getNom() {
        return this.nom;
    }
}

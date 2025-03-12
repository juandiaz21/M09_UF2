public class Client {
    private String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseElCabell() throws InterruptedException {
        System.out.println("Tallant cabell a " + nom);
        Thread.sleep(900 + (int)(Math.random() * 100));  
    }
}

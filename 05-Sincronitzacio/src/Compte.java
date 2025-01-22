public class Compte {

    private float saldo;
    private static Compte id;

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float entrada) {
        this.saldo = saldo - entrada;
    }

    public static synchronized Compte getInstance() {
        if (id == null) {
            id = new Compte();
        }
        return id;
    }
}

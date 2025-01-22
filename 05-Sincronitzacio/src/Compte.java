public class Compte {

    private float saldo;
    private static Compte id;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float entrada) {
        this.saldo = saldo - entrada;
    }

    public static Compte getInstance() {
        if (id == null) {
            id = new Compte();
        }
        return id;
    }

}

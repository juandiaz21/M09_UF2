public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Thread filJuan = new Fil("Juan");
        Thread filPepe = new Fil("Pepe");

        filPepe.start();
        filJuan.start();
    }
}
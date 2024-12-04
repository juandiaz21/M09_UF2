public class Principal {
    public static void main(String[] args) {
        // Creación de los hilos
        Thread filJuan = new Fil("Juan");
        Thread filPepe = new Fil("Pepe");

        filJuan.start();
        filPepe.start();
    }
}

import java.util.Scanner;

public class Coet {

    // variable de classe
    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        System.out.println("Passant a potència " + p);
        for (int i = 0; i < 4; i++) {
            motors[i].setPotencia(p);
        }

        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(motors[i]);
            threads[i].start();
        }
        
        boolean threadsRunning = true;
        while (threadsRunning) {
            threadsRunning = false;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    threadsRunning = true;
                }
            }
        }
    }

    public void arrancar() {
        for (int i = 0; i < 4; i++) {
            motors[i].setPotencia(motors[i].getPotenciaObjectiu());
        }
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Coet cohete = new Coet();
        while (true) {
            System.out.print("Introdueix la potencia objectiu: ");
            int potencia = lector.nextInt();
            cohete.passaAPotencia(potencia);
            if (potencia == 0) {
                break;
            }
        }
        lector.close();
    }
}
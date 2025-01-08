public class Coet {
    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0) {
            System.out.println("La potència no pot ser negativa.");
            return;
        }

        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public static void main(String[] args) {
        //
    }
}
import java.util.Random;

class Motor extends Thread {
    private int potenciaActual;
    private int potenciaObjectiu;
    private int id;
    private Random random;

    public Motor(int id) {
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.id = id;
        this.random = new Random();
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        while (true) {
            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.println("Motor " + id + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                System.out.println("Motor " + id + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
            } else if (potenciaObjectiu == 0 && potenciaActual == 0) {
                System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                break;
            }

            try {
                Thread.sleep(random.nextInt(2000)); // Temps aleatori entre 0 i 2 segons
            } catch (InterruptedException e) {
                System.out.println("Motor " + id + " interromput.");
            }
        }
    }
}
import java.util.Random;
public class Motor implements Runnable {
    // variables de classe
    private int id;
    private int potenciaActual;
    private int potenciaObjectiu;

    public Motor(int id) {
        this.id = id;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
    }

    public int getPotenciaObjectiu() {
        return this.potenciaObjectiu;
    }

    public void setPotencia(int potencia) {
        this.potenciaObjectiu = potencia;
    }

    @Override
    public void run() {
        if (this.potenciaActual != this.potenciaObjectiu) {
            String operacio = (this.potenciaObjectiu > this.potenciaActual) ? "Incre." : "Decre.";
            while (this.potenciaActual != this.potenciaObjectiu) {
                try {
                    Thread.sleep(new Random().nextInt(2001)); // Aleatori entre 0 y 2s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.potenciaObjectiu > this.potenciaActual) {
                    this.potenciaActual++;
                } else {
                    this.potenciaActual--;
                }
                if (this.potenciaActual == this.potenciaObjectiu) {
                    System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n", this.id, this.potenciaObjectiu, this.potenciaActual);
                    break;
                }
                System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n", this.id, operacio, this.potenciaObjectiu, this.potenciaActual);
            }
        }
    }
}
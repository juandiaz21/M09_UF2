public class Fil extends Thread {
    private final String nombre;
    public Fil(String nom) {
        nombre = nom; //asignamos nombre
    }

    @Override //vamos a modificar metodos de clase segun el funcionamiento que queramos 
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i); //itera
            try {
                Thread.sleep((i+1)); //pausa para los dos para que itere uno y otro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fil " + nombre); //final
    }
}

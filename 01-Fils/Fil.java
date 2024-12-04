public class Fil extends Thread {
    private final String nombre;
    public Fil(String nom) {
        nombre = nom; //asignamos nombre
    }
    @Override //vamos a modificar metodos de clase 
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i); //itera
            try {
                Thread.sleep((int) (Math.random() * 200)); //pausa 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fil " + nombre); //final
    }
}

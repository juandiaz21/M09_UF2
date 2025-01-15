public class Administracio {
    private static final int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public void execucio() {
        for (Treballador treballador : poblacio_activa) {
            treballador.start();
        }

        for (Treballador treballador : poblacio_activa) {
            try {
                treballador.join(); 
            } catch (InterruptedException e) {
                System.err.println(treballador.getName() + " ha estat interromput durant el join.");
            }
        }
        for (Treballador treballador : poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.execucio();
    }
}

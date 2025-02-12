public class Taula {
    private final Filosof[] comensals;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        comensals = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        
        for (int i = 0; i < numFilosofs; i++) {
            comensals[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            System.out.println("Comensal: fil" + i + " esq " + forquilles[i].getId() + " dret " + forquilles[(i + 1) % forquilles.length].getId());
        }
        System.out.println("------------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : comensals) {
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}

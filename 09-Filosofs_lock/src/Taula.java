public class Taula {
    private final Filosof[] comensals;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        this.forquilles = new Forquilla[numFilosofs];
        this.comensals = new Filosof[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            comensals[i] = new Filosof(i, esquerra, dreta);
        }
    }

    public void showTaula() {
        for (Filosof filosof : comensals) {
            System.out.println("Comensal:Fil" + filosof.getId() + " esq:" + filosof.getForquillaEsquerra().getId() + " dret:" + filosof.getForquillaDreta().getId());
        }
        System.out.println("-----------------------------");
    }

    public void cridarATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
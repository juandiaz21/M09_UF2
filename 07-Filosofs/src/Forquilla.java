
public class Forquilla {
    private final int id;
    private boolean enUs = false;

    public Forquilla(int id) {
        this.id = id;
    }

    public synchronized boolean agafar(int filosofId, boolean esDreta) {
        if (!enUs) {
            enUs = true;
            System.out.println("Filosof: fil" + filosofId + " agafa la forquilla " + (esDreta ? "dreta" : "esquerra") + " " + id);
            return true;
        }
        return false;
    }

    public synchronized void deixar() {
        enUs = false;
    }

    public int getId() {
        return id;
    }
}
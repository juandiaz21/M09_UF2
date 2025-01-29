import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private final List<Assistent> assistents = new ArrayList<>();
    private int placesDisponibles; 

    public Esdeveniment(int placesMax) {
        this.placesDisponibles = placesMax;
    }

    public synchronized void ferReserva(Assistent assistent) throws InterruptedException {
        while (placesDisponibles==0) {
            wait(); 
        }
        assistents.add(assistent);
        placesDisponibles--;
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + (placesDisponibles));
        notifyAll(); 
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.remove(assistent)) {
            placesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + (placesDisponibles));
            notifyAll(); 
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + (placesDisponibles));
        }
    }
}

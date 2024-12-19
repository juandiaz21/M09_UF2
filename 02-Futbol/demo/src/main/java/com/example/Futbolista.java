package com.example;

public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    public int ngols;    
    public int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            this.ntirades++;
            if (Math.random() < PROBABILITAT) {
                this.ngols++;
            }
        }
    }

    public int getGoals() {
        return ngols;
    }

    public static void main(String[] args) {
        String[] nombres = {
            "Barcia", "Vinicius", "Tristan", "M. Silva", "Fran", 
            "Bebeto", "Villares", "Barbero", "Yeremay", "L. Perez", "Mella"
        };

        Futbolista[] futbolistas = crearFutbolistas(nombres);

        realizarPenaltis(futbolistas);
    }

    public static Futbolista[] crearFutbolistas(String[] nombres) {
        Futbolista[] futbolistas = new Futbolista[Futbolista.NUM_JUGADORS];
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            futbolistas[i] = new Futbolista(nombres[i]);
        }
        return futbolistas;
    }

    public static void realizarPenaltis(Futbolista[] futbolistas) {
        System.out.println("Inici dels xuts --------------------");

        for (Futbolista futbolista : futbolistas) {
            futbolista.start();
        }

        for (Futbolista futbolista : futbolistas) {
            try {
                futbolista.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");
        for (Futbolista futbolista : futbolistas) {
            System.out.printf("%-10s -> %d gols\n", 
                futbolista.getName(), futbolista.getGoals());
        }
    }
}

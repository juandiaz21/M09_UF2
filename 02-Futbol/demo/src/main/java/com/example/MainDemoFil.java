package com.example;

public class MainDemoFil {
    public static void main(String[] args) {

        // Capt hilo actual
        Thread currentThread = Thread.currentThread();

        // Obtener datos  hilo
        long id = currentThread.getId();          
        int prioritat = currentThread.getPriority(); 
        String nom = currentThread.getName();     
        String grupo = currentThread.getThreadGroup().getName(); 

        //Mostrar por pantalla
        System.out.println("MainDemoFil.main:");
        System.out.printf("Prioritat -> %d, Nom -> %s%n", prioritat, nom);
        System.out.printf("toString() -> Thread[#%d,%s,%d,%s]%n", id, nom, prioritat, grupo);
    }
}

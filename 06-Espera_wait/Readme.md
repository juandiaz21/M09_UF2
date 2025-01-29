# Preguntes Teòriques

## 1. Per què s'atura l'execució al cap d'un temps?

Hi ha un moment on ja no queden més plaçes i a la ruleta 50-50 de si fan reserva o cancel·len estan tots en wait(), llavors cap fil fa un notifyAll().

## 2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% (cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos.

- Si fos 70-30 (a favor de reservar):

````java
if (random.nextInt(100)<70) {
    esdeveniment.ferReserva(this);
} else {
    esdeveniment.cancelaReserva(this);
}
````

La sortida es:

```
Assistent 0 ha fet una reserva. Places disponibles: 4
Assistent 9 ha fet una reserva. Places disponibles: 3
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 6 ha fet una reserva. Places disponibles: 2
Assistent 5 ha fet una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 1 ha fet una reserva. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
```


- En cas de que fos 30-70 (a favor de cancel·lar):

````java
if (random.nextInt(100)<30) {
    esdeveniment.ferReserva(this);
} else {
    esdeveniment.cancelaReserva(this);
}
````

La sortida es:

```
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent 8 ha fet una reserva. Places disponibles: 4
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent 6 ha fet una reserva. Places disponibles: 3
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent 1 ha fet una reserva. Places disponibles: 2
Assistent 9 ha fet una reserva. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 9 ha cancel·lat una reserva. Places disponibles: 1
Assistent 2 ha fet una reserva. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 8 ha cancel·lat una reserva. Places disponibles: 1
Assistent 6 ha fet una reserva. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 6 ha cancel·lat una reserva. Places disponibles: 1
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 1 ha cancel·lat una reserva. Places disponibles: 1
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent 3 ha fet una reserva. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent 0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
```


- Com es veu, la sortida es considerablament mes curta quan hi ha un 70% de possibilitats de que l'assistent intenti fer una reserva, el motiu es l'explicat al punt 1.

## 3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?

- Permet saber quins assistents ja han reservat. Es més fàcil de gestionar el programa gràcies a la llista.

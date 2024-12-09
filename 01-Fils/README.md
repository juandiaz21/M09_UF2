# Activitat 1 UF2 M09 : Fils 

## Comportament 1: Alternança entre Juan i Pepe

Volem que els fils "Juan" i "Pepe" es vagin intercalant de forma equitativa mitjançant fils de Java.

### Codi amb el que fem que els fils es comportin així:

```java
Thread filJuan = new Fil("Juan");
Thread filPepe = new Fil("Pepe");

filJuan.start();
filPepe.start();
```

### Sortida esperada

Així és la sortida del codi al executar-se:

```
Juan 1
Pepe 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Juan 8
Pepe 8
Juan 9
Pepe 9
Termina el fil Pepe
Termina el fil Juan
```

## Comportament 2: Prioritat Pepe

Volem que amb els fils "Juan" i "Pepe" creats, primer s'executi majorment Pepe i després Juan en totes les execucions que facis.

### Codi amb el que fem que els fils es comportin així:

```java
Thread filJuan = new Fil("Juan");
Thread filPepe = new Fil("Pepe");

filPepe.setPriority(Thread.MAX_PRIORITY);
filJuan.setPriority(Thread.MIN_PRIORITY);

filPepe.start();
filJuan.start();
```

### Sortida esperada

Així és la sortida del codi al executar-se:

```
Pepe 1
Pepe 2
Pepe 3
Juan 1
Pepe 4
Juan 2
Pepe 5
Juan 3
Pepe 6
Juan 4
Pepe 7
Juan 5
Pepe 8
Juan 6
Pepe 9
Juan 7
Juan 8
Juan 9
Termina el fil Pepe
Termina el fil Juan
```

## Comportament 3: Ordre estricte

Volem que s’executin en ordre estricte altern entre cada fil.

### Codi amb el que fem que els fils es comportin així:

```java
Thread filJuan = new Fil("Juan");
Thread filPepe = new Fil("Pepe");

filPepe.start();
filJuan.start();
```

```java
for (int i = 1; i <= 9; i++) {
    System.out.println(nombre + " " + i); 
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

### Sortida esperada

Així és la sortida del codi al executar-se:

```
Pepe 1
Juan 1
Juan 2
Pepe 2
Juan 3
Pepe 3
Juan 4
Pepe 4
Juan 5
Pepe 5
Juan 6
Pepe 6
Juan 7
Pepe 7
Juan 8
Pepe 8
Juan 9
Pepe 9
Termina el fil Juan
Termina el fil Pepe
```


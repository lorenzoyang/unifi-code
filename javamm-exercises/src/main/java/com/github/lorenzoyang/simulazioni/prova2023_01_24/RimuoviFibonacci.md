```java

int rimuoviFibonacci(int n) {
    if (n / 100 == 0) return n; // se n e' un numero di due cifre o meno, allora n e' il risultato

    int risultato = 0;
    int n1, n2, n3;
    int esponente = 0;

    // finche' n ha piu' di 2 cifre
    while (n / 100 > 0) {
        n1 = n % 10;
        n2 = (n / 10) % 10;
        n3 = (n / 100) % 10;

        if (n1 + n2 == n3) {
            n /= 1000; // in relazione di fibonacci, salto le ultime 3 cifre
        } else {
            risultato += n1 * (int) Math.pow(10, esponente++); // altrimenti aggiungo l'ultima cifra
            n /= 10; // e la rimuovo
        }
    }

    risultato += n * (int) Math.pow(10, esponente); // aggiungo le cifre rimanenti
    return risultato;
}

// Estensione OPZIONALE dell’Esercizio
int rimuoviFibonacciEsteso(int n) {
    int risultato = rimuoviFibonacci(n);
    while (risultato != n) {
        n = risultato;
        risultato = rimuoviFibonacci(n);
    }
    return risultato;
}

```
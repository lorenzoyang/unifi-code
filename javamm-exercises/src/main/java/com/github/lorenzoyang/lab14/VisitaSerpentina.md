```java
int[] visitaSerpentina(int[][] m, int riga, int colonna) {
    // il numero di righe e' pari
    int lunghezzaArray = m.length * m[0].length;
    int[] cammino = new int[lunghezzaArray];

    int indice = 0, i = riga, j = colonna;

    // Se true mi devo spostare da sinistra verso destra.
    // Se false mi devo spostare da destra verso sinistra.
    boolean versoDestra = true;

    while (indice < lunghezzaArray) {

        cammino[indice++] = m[i][j];

        // Se devo spostarmi a destra e non sono sull'ultima colonna,
        // mi sposto sulla colonna successiva a destra.
        if ((versoDestra) && (j < m[0].length - 1)) j++;
            // Se devo spostarmi a sinistra e non sono sulla prima colonna,
            // mi sposto sulla colonna successiva a sinistra.
        else if ((!versoDestra) && (j > 0)) j--;
            // Se sono arrivato sulla prima o ultima colonna,
            // mi sposto sulla riga successiva (modulo numero righe)
            // e nego la direzione del prossimo spostamento.
        else {
            i = (i + 1) % m.length;
            versoDestra = !versoDestra;
        }
    }
    return cammino;
}
```
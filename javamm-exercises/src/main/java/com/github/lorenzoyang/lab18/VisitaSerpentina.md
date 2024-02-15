```java
int[] visitaSerpentina(int[][] m) {
    int[] risultato = new int[m[0].length];
    int colonna = 0, riga = 0, direzione = 1;

    while (colonna < m[0].length) {
        risultato[colonna] = m[riga][colonna];
        if (riga == 0) {
            direzione = 1;
        } else if (riga == m.length - 1) {
            direzione = -1;
        }
        riga += direzione;
        colonna++;
    }
    return risultato;
}
```

```java

```
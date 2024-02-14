```java
    boolean testBilanciamento(int[] a) {
        if (a.length == 0 || a.length % 2 != 0) return false;
        if (a.length == 2) return a[0] == a[1];
        return testBilanciamento(a, 1, a[0] + a[a.length - 1]);
    }

    boolean testBilanciamento(int[] a, int indice, int somma) {
        if (indice == a.length / 2) return true;
        return (a[indice] + a[a.length - 1 - indice] == somma) && testBilanciamento(a, indice + 1, somma);
    }
```
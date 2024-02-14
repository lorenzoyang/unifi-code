```java

    int[][] ruotaRomboMatrice(int[][] t, int k) {
        int c = t.length / 2, temp_destra = t[c][c + k];
        for (int i = 0; i < k; i++) {
            t[c + i][c + k - i] = t[c + i + 1][c + k - i - 1]; // destra
        }
        for (int i = 0; i < k; i++) {
            t[c + k - i][c - i] = t[c + k - i - 1][c - i - 1]; // sotto
        }
        for (int i = 0; i < k; i++) {
            t[c - i][c - k + i] = t[c - i - 1][c - k + i + 1]; // sinistra
        }
        for (int i = 0; i < k; i++) {
            t[c - k + i][c + i] = t[c - k + i + 1][c + i + 1]; // sopra
        }
        t[c - 1][c + k - 1] = temp_destra;
        return t;
    }

    int[][] ruotaRomboMatriceNposizioni(int[][] t, int k, int n) {
        n = n > 0 ? n % (4 * k) : (n % (4 * k)) + 4 * k;
        for (int i = 0; i < n; i++) ruotaRomboMatrice(t, k);
        return t;
    }

```
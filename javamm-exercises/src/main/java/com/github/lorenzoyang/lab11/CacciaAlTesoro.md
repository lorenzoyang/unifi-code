```java
    boolean cacciaAlTesoro(char[][] m) {
        return cacciaAlTesoro(m, 0, 0);
    }

    boolean cacciaAlTesoro(char[][] m, int r, int c) {
        if (m[r][c] == 'T' || m[r][c] == '0') return false;
        if (m[r][c] == 'X') return true;

        char cella = m[r][c];
        m[r][c] = '0';

        int alto = (r - 1 + m.length) % m.length;
        int basso = (r + 1) % m.length;
        int sinistra = (c - 1 + m[r].length) % m[r].length;
        int destra = (c + 1) % m[r].length;

        switch (cella) {
            case 'A':
                return cacciaAlTesoro(m, alto, c);
            case 'B':
                return cacciaAlTesoro(m, basso, c);
            case 'S':
                return cacciaAlTesoro(m, r, sinistra);
            case 'D':
                return cacciaAlTesoro(m, r, destra);
            case '?':
                return cacciaAlTesoro(m, alto, c) ||
                        cacciaAlTesoro(m, basso, c) ||
                        cacciaAlTesoro(m, r, sinistra) ||
                        cacciaAlTesoro(m, r, destra);
            default:
                return false;
        }
    }
```
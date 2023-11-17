package com.github.lorenzoyang.lab11;

class CacciaAlTesoro {
    // #inizio: javamm

    boolean cacciaAlTesoro(char[][] m) {
        return cacciaAlTesoro(m, 0, 0);
    }

    // metodo privato usato da cacciaAlTesoro(char[][] m)
    boolean cacciaAlTesoro(char[][] m, int r, int c) {
        if (m[r][c] == 'T') return false;
        if (m[r][c] == 'X') return true;
        if (m[r][c] == '0') return false;

        char cella = m[r][c];
        m[r][c] = '0';

        switch (cella) {
            case 'A':
                return cacciaAlTesoro(m, (r - 1 + m.length) % m.length, c);
            case 'B':
                return cacciaAlTesoro(m, (r + 1) % m.length, c);
            case 'S':
                return cacciaAlTesoro(m, r, (c - 1 + m[r].length) % m[r].length);
            case 'D':
                return cacciaAlTesoro(m, r, (c + 1) % m[r].length);
            case '?':
                return cacciaAlTesoro(m, (r - 1 + m.length) % m.length, c) ||
                        cacciaAlTesoro(m, (r + 1) % m.length, c) ||
                        cacciaAlTesoro(m, r, (c - 1 + m[r].length) % m[r].length) ||
                        cacciaAlTesoro(m, r, (c + 1) % m[r].length);
            default:
                return false;
        }
    }

    // #fine: javamm
}

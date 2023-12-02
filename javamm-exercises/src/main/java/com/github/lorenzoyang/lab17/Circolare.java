package com.github.lorenzoyang.lab17;

class Circolare {
    // #inizio: javamm

    boolean circolare(char[][] m) {
        return circolare(m, 0, 0, 0);
    }

    boolean circolare(char[][] m, int r, int c, int n) {
        char cella = m[r][c];

        if (r == 0 && c == 0 && n == m.length * m[0].length) return true;
        if (cella == '0') return false;

        m[r][c] = '0';
        n++; // il numero di celle visitate

        switch (cella) {
            case 'A':
                return circolare(m, (r - 1 + m.length) % m.length, c, n);
            case 'B':
                return circolare(m, (r + 1) % m.length, c, n);
            case 'S':
                return circolare(m, r, (c - 1 + m[r].length) % m[r].length, n);
            case 'D':
                return circolare(m, r, (c + 1) % m[r].length, n);
            default:
                return false;
        }
    }

    // #fine: javamm
}

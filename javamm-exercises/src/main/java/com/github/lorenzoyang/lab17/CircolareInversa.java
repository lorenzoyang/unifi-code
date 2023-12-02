package com.github.lorenzoyang.lab17;

class CircolareInversa {
    // #inizio: javamm

    boolean circolareInversa(char[][] m) {
        return circolareInversa(m, 0, 0, 0);
    }

    boolean circolareInversa(char[][] m, int r, int c, int n) {
        char cella = m[r][c];

        if (r == 0 && c == 0 && n == m.length * m[0].length) return true;
        if (cella == '0') return false;

        m[r][c] = '0';
        n++; // il numero di celle visitate

        switch (cella) {
            case 'A':
                return circolareInversa(m, (r + 1) % m.length, c, n);
            case 'B':
                return circolareInversa(m, (r - 1 + m.length) % m.length, c, n);
            case 'S':
                return circolareInversa(m, r, (c + 1) % m[r].length, n);
            case 'D':
                return circolareInversa(m, r, (c - 1 + m[r].length) % m[r].length, n);
            default:
                return false;
        }
    }

    // #fine: javamm
}

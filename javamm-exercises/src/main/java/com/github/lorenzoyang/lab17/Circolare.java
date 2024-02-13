package com.github.lorenzoyang.lab17;

class Circolare {
    // #solution:begin

    // consegna obbligatoria
    boolean circolare(char[][] m) {
        return circolare(m, 0, 0, 0, false);
    }

    // consegna facoltativa
    boolean circolareInversa(char[][] m) {
        return circolare(m, 0, 0, 0, true);
    }

    // funzione privata ausiliaria: implementazione ricorsiva della "consegna obbligatoria" circolare
    boolean circolare(char[][] m, int r, int c, int n, boolean inversa) {
        char cella = m[r][c];

        if (r == 0 && c == 0 && n == m.length * m[0].length) return true;
        if (cella == '0') return false;

        m[r][c] = '0';
        n++; // il numero di celle visitate

        int prossimaRiga = r, prossimaColonna = c;
        switch (cella) {
            case 'A':
                prossimaRiga = inversa ? (r + 1) % m.length : (r - 1 + m.length) % m.length;
                break;
            case 'B':
                prossimaRiga = inversa ? (r - 1 + m.length) % m.length : (r + 1) % m.length;
                break;
            case 'S':
                prossimaColonna = inversa ? (c + 1) % m[r].length : (c - 1 + m[r].length) % m[r].length;
                break;
            case 'D':
                prossimaColonna = inversa ? (c - 1 + m[r].length) % m[r].length : (c + 1) % m[r].length;
                break;
            default:
                return false;
        }
        return circolare(m, prossimaRiga, prossimaColonna, n, inversa);
    }

    // #solution:end
}

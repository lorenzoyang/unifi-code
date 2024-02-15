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

    boolean circolare(char[][] m, int r, int c, int n, boolean inversa) {
        char cella = m[r][c];
        // se ritorno all'inizio dopo aver visitato tutti gli elementi
        if (r == 0 && c == 0 && n == m.length * m[0].length) return true;

        if (cella == '0') return false;
        m[r][c] = '0';

        switch (cella) {
            case 'A':
                r = inversa ? (r + 1) % m.length : (r - 1 + m.length) % m.length;
                break;
            case 'B':
                r = inversa ? (r - 1 + m.length) % m.length : (r + 1) % m.length;
                break;
            case 'S':
                c = inversa ? (c + 1) % m[r].length : (c - 1 + m[r].length) % m[r].length;
                break;
            case 'D':
                c = inversa ? (c - 1 + m[r].length) % m[r].length : (c + 1) % m[r].length;
                break;
            default:
                return false;
        }
        return circolare(m, r, c, n + 1, inversa);
    }
    // #solution:end

    // #alternativesolution:begin
    // #comment: implementato in modo iterativo senza l'uso della ricorsione
    // Unico metodo, utilizzato anche per il controllo della matrice inversa (se inversa è true)
    boolean $1_circolare(char[][] M, boolean inversa) {
        int conta = 0, r = 0, c = 0;

        // Esco dal ciclo quando ho visitato tutti gli elementi della
        // matrice, oppure quando ritorno a visitare un elemento già
        // visitato in precedenza.
        while ((conta < M.length * M[0].length) && (M[r][c] != ' ')) {
            char app = M[r][c];
            M[r][c] = ' '; // "Annullo" l'elemento, per segnalare
            // che l'ho visitato.

            // Caso consegna STANDARD (inversa è false):
            if (!inversa) {
                switch (app) {
                    case 'B':
                        r = (r + 1) % M.length;
                        break;
                    case 'A':
                        r = (M.length + r - 1) % M.length;
                        break;
                    case 'D':
                        c = (c + 1) % M[0].length;
                        break;
                    case 'S':
                        c = (M[0].length + c - 1) % M[0].length;
                        break;
                }
            } else {
                // Caso consegna EXTRA (inversa è true):
                // rispetto al case precedente inverto i case A e B,
                // ed inverto i case S e D. In questo modo NON occorre
                // creare la matrice inversa, né modificare M. Si modificano
                // solo le regole di visita della matrice.
                switch (app) {
                    case 'A':
                        r = (r + 1) % M.length;
                        break;
                    case 'B':
                        r = (M.length + r - 1) % M.length;
                        break;
                    case 'S':
                        c = (c + 1) % M[0].length;
                        break;
                    case 'D':
                        c = (M[0].length + c - 1) % M[0].length;
                        break;
                }
            }
            conta++;
        }

        // Ritorno true se ho visitato tutti gli elementi e
        // se la cella finale è quella di indice (0,0).
        return (conta == M.length * M[0].length) && (r == 0) && (c == 0);
    }

    boolean $1_circolare(char[][] M) {
        return ($1_circolare(M, false));
    }

    boolean $1_circolareInversa(char[][] M) {
        return ($1_circolare(M, true));

    }
    // #alternativesolution:end
}

package com.github.lorenzoyang.lab20;

class TrovaParolaDiagonale {
    // #solution:begin

    boolean trovaParolaDiagonale(char[][] g, char[] p) {
        // Scorro solo le diagonali che hanno spazio sufficiente per contenere p
        for (int r = 0; r <= g.length - p.length; r++) {
            for (int c = 0; c <= g[0].length - p.length; c++) {
                // da Alto-Sinistra verso Basso-Destra
                // da Basso-Destra verso Alto-Sinistra
                if (trovaParolaDiagonale(g, p, r, c, true)) return true;
                // da Basso-Sinistra verso Alto-Destra
                // da Alto-Destra verso Basso-Sinistra
                if (trovaParolaDiagonale(g, p, g.length - 1 - r, c, false)) return true;
            }
        }
        return false;
    }

    boolean trovaParolaDiagonale(char[][] g, char[] p, int r, int c, boolean diagonale) {
        int i = 0;
        // g potrebbe ancora contenere p letto da destra a sinistra
        // g potrebbe ancora contenere p letto da sinistra a destra
        boolean trovabileDaDestra = true, trovabileDaSinistra = true;
        while (i < p.length && (trovabileDaDestra || trovabileDaSinistra)) {
            // Verifico se p letto da sinistra a destra è presente in g a partire dalla cella (r,c)
            if (g[r][c] != p[i]) trovabileDaSinistra = false;
            // Verifico se p letto da destra a sinistra è presente in g a partire dalla cella (r,c)
            if (g[r][c] != p[p.length - 1 - i]) trovabileDaDestra = false;
            // Se diagonale==true incremento l'indice riga poiché mi sto spostando
            // nella direzione da Alto-Sinistra verso Basso-Destra.
            // Se diagonale==false decremento l'indice riga poiché mi sto spostando
            // nella direzione da Basso-Sinistra verso Alto-Destra.
            r = diagonale ? r + 1 : r - 1;
            c++;
            i++;
        }
        return trovabileDaDestra || trovabileDaSinistra;
    }

    // #solution:end
}

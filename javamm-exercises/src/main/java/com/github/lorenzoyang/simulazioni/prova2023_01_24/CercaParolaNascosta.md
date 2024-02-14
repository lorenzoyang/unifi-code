```java
char[] cercaParolaNascosta(char[][] testo) {
    char[] parolaNascosta = new char[testo.length]; // Array delle lettere nascoste
    int contaCaratteriNonValidi = 0; // Conto quanti caratteri sono uguali a ' ' (non validi)

    for (int i = 0; i < testo.length; i++) {
        parolaNascosta[i] = cercaLetteraNascosta(testo[i]);
        if (parolaNascosta[i] == ' ') contaCaratteriNonValidi++;
    }
    // Elimino i caratteri non validi (' ') dall'array di output.
    return comprimi(parolaNascosta, contaCaratteriNonValidi);
}

// la funzione privata ausiliaria:
// Si restituisce un array che corrisponde alla parola nascosta
// da cui vengono rimossi i caratteri non validi (corrispondenti al carattere ' ').
// Se non esiste alcuna lettera nascosta nella matrice, allora si restituisce
// l'array con il solo elemento {' '} (come da specifica dell'esercizio).
char[] comprimi(char[] parolaNascosta, int caratteriNonValidi) {
    // Se la matrice non contiene alcuna lettera nascosta, restituisco un array contenente
    // un solo carattere uguale a ' ' (come da specifica esercizio).
    if (caratteriNonValidi == parolaNascosta.length) return new char[]{' '};

    char[] parolaNascostaCompressa = new char[parolaNascosta.length - caratteriNonValidi];
    int indice = 0;
    // Copio nell'array di output sono i caratteri validi (quelli diversi dal carattere ' ').
    for (int i = 0; i < parolaNascosta.length; i++) {
        if (parolaNascosta[i] != ' ') parolaNascostaCompressa[indice++] = parolaNascosta[i];
    }
    return parolaNascostaCompressa;
}

// la funzione privata ausiliaria:
// Trovo la lettera nascosta in una riga della matrice di partenza.
// Se non esiste, restituisce il carattere ' ' per rappresentare un carattere non valido.
char cercaLetteraNascosta(char[] parola) {
    // L'array delle frequenze composto da 26 elementi, ovvero da:
    // frequenzeLettere[0] <-- conta quante volte il carattere 'A' compare nella riga;
    // ...
    // frequenzeLettere[25] <-- conta quante volte il carattere 'Z' compare nella riga.
    int[] frequenzeLettere = new int['Z' - 'A' + 1];

    int indiceFreqMax = -1;
    int freqMax = 0;

    // Scorro la parola da destra verso sinistra; in questo modo l'ultimo indice di frequenza
    // massima trovato e' anche quello che sicuramente compare per primo nella riga
    // (scorrendola da sinistra a destra - come da specifica dell'esercizio).
    for (int i = parola.length - 1; i >= 0; i--) {
        // Incremento la frequenza di occorrenza del carattere parola[i]. Sottraendo la codifica
        // di 'A' (convertito in intero) alla codifica del carattere parola[i] (convertito in intero)
        // si ha che:
        // Se parola[i] = 'A', devo incrementare frequenzaLettere[0];
        // ...
        // Se parola[i] = 'Z', devo incrementare frequenzaLettere[25].
        int freq = ++frequenzeLettere[parola[i] - 'A'];

        // Controllo se il carattere in esame e' quello che per il momento
        // appare un numero maggiore di volte nella riga (frequenza massima).
        if (freq >= freqMax) {
            freqMax = freq; // Aggiorno il valore di frequenza massima
            indiceFreqMax = i; // Aggiorno l'indice a cui compare il carattere con frequenza massima
        }
    }

    // Se i caratteri sono tutti diversi fra loro, restituisco il carattere ' ' (lettera nascosta
    // non esistente), altrimenti restituisco il carattere della riga con maggior frequenza.
    return ((freqMax == 1) ? ' ' : parola[indiceFreqMax]);
}
```
```java
boolean bilanciato(int n) {
    int numCifre = contaCifre(n);
    int left = (int) ((n / Math.pow(10, numCifre - 1))); // la prima cifra
    int right = (int) ((n % Math.pow(10, 1))); // l'ultima cifra
    if (numCifre == 2) return left == right;

    int somma = left + right;
    for (int i = 1; i < numCifre / 2; i++) { // i = 1 perchè la prima cifra è già stata controllata
        left = (int) ((n / Math.pow(10, numCifre - i - 1)) % 10); // 4
        right = (int) ((n / Math.pow(10, i)) % 10); // 1
        if (left + right != somma) return false;
    }
    return true;
}

int contaCifre(int n) {
    int nCifre = 0;
    while (n > 0) {
        n /= 10;
        nCifre++;
    }
    return nCifre;
}
```
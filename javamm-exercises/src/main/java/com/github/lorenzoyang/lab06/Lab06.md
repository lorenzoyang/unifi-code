```java
int integerSquareRoot(int n) {
    int i = 0;
    while (i * i <= n) {
        i++;
    }
    return i - 1;
}

int firstLastDigitSum(int n) {
    if (n >= 10) {
        int lastDigit = n % 10;
        while (n >= 10) {
            n /= 10;
        }
        return lastDigit + n;
    }
    return -1;
}

int invertNumber(int n) {
    if (n % 10 > 0) {
        int result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
    return -1;
}

int harmonicSum(int x) {
    double result = 0;
    int i = 1;
    while (result < x) {
        result += harmonicFunction(i);
        i++;
    }
    return i - 1;
}

// funzione di supporto
double harmonicFunction(int k) {
    double result = 0;
    int i = 1;
    while (i <= k) {
        result += (1.0 / i);
        i++;
    }
    return result;
}

long duplicateDigit(int n) {
    long risultato = 0;

    int fattore = 1;

    while (n > 0) {
        int cifra = n % 10;

        risultato += (long) fattore * cifra + (long) fattore * cifra * 10;
        fattore *= 100;

        n /= 10;
    }
    return risultato;
}
```
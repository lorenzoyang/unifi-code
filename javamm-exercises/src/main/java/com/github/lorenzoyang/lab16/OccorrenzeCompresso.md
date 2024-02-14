```java

int[] occorrenzeCompresso(int[] a) {
    int[] occorrenze = new int[max(a) + 1];
    for (int i = 0; i < a.length; i++) {
        occorrenze[a[i]]++;
    }

    int count = 0;
    for (int i = 0; i < occorrenze.length; i++) {
        if (occorrenze[i] != 0) {
            count++;
        }
    }

    int[] occorrenzeCompresso = new int[count];
    for (int i = 0, j = 0; i < occorrenze.length; i++) {
        if (occorrenze[i] != 0) {
            occorrenzeCompresso[j++] = occorrenze[i];
        }
    }

    return occorrenzeCompresso;
}

// funzione privata ausiliaria
int max(int[] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
        max = Math.max(max, a[i]);
    }
    return max;
}

```
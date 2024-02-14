```java
    int interoNascosto(int a, int b, int c) {
        double nascosto = 0;
        int count = 0;
        while (a > 0) {
            int cifraA = a % 10, cifraB = b % 10, cifraC = c % 10;
            if (cifraA == cifraB || cifraA == cifraC) {
                nascosto += Math.pow(10, count) * (cifraA);
                count++;
            } else if (cifraB == cifraC) {
                nascosto += Math.pow(10, count++) * (cifraB);
            }
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return (int) nascosto;
    }
```
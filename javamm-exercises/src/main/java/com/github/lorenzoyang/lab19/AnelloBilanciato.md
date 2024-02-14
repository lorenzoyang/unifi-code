```java
boolean anelloBilanciato(int[][] t, int k) {
    int centro = t.length / 2;
    for (int i = centro - k, j = 0; i <= centro + k; i++, j++) {
        if (t[centro - k][i] + t[centro + k][centro + k - j] != t[centro][centro]) return false;
        if (t[i][centro - k] + t[centro + k - j][centro + k] != t[centro][centro]) return false;
    }
    return true;
}
```
package com.github.lorenzoyang.lab04;

class Lab04 {
    // #inizio: javamm
    
    boolean isSum(int a, int b, int c) {
        return (a == b + c) || (b == a + c) || (c == a + b);
    }

    boolean lastDigit(int a, int b, int c) {
        return (a % 10 == b % 10) || (b % 10 == c % 10) || (a % 10 == c % 10);
    }

    boolean order(int a, int b, int c, boolean noA) {
        return noA ? (b < c) : (a < b && b < c);
    }

    boolean range(int n, int l, int r, boolean o) {
        return o ? (n < l || n > r) : (n >= l && n <= r);
    }

    boolean six(int a, int b) {
        return a == 6 || b == 6 || (a + b) == 6 || (a - b) == 6 || (b - a) == 6;
    }

    // #fine: javamm
}

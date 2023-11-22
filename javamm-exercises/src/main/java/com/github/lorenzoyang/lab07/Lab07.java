package com.github.lorenzoyang.lab07;

class Lab07 {
    // #inizio: javamm

    int scalarProduct(int[] a, int[] b) {
        if (a.length > 0 && b.length > 0 && a.length == b.length) {
            int result = 0;
            for (int i = 0; i < a.length; i++) {
                result += a[i] * b[i];
            }
            return result;
        }
        return 0;
    }

    int[] arraySum(int[] a, int[] b) {
        if (a.length > 0 && b.length > 0 && a.length == b.length) {
            int[] result = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                result[i] = a[i] + b[i];
            }
            return result;
        }
        return new int[0];
    }

    long decimal(int[] a) {
        long result = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int potenza = 1;
            for (int j = 0; j < a.length - 1 - i; j++) {
                potenza *= 2;
            }
            result += (long) a[i] * potenza;
        }
        return result;
    }

    char[] upperCase(char[] a) {
        char[] result = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 'a' && a[i] <= 'z') {
                result[i] = (char) (a[i] - 32);
            } else {
                result[i] = a[i];
            }
        }
        return result;
    }

    boolean palindrome(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] != a[a.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // #fine: javamm
}

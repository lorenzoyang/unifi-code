package com.github.lorenzoyang.lab12;

class LunghezzaMaxSeq {
    // #solution:begin
    int lunghezzaMaxSeq(char[] a, char c) {
        return lunghezzaMaxSeq(a, c, 0, 0);
    }

    // funzione di supporto
    int lunghezzaMaxSeq(char[] a, char c, int pos, int count) {
        if (pos == a.length) return count;
        int max = lunghezzaMaxSeq(a, c, ++pos, a[pos - 1] == c ? count + 1 : 0);
        return max > count ? max : count;
    }
    // #solution:end

    // #alternativesolution:begin
    // #comment: soluzione del prof
    int $1_lunghezzaMaxSeq(char[] a, char c) {
        return $1_lunghezzaMaxSeq(a, c, 0, 0, 0);
    }

    int $1_lunghezzaMaxSeq(char[] a, char c, int index, int count, int max) {
        if (index == a.length) return max;

        if (a[index] == c) {
            count++;
        } else {
            count = 0;
        }
        if (count > max) {
            max = count;
        }
        return $1_lunghezzaMaxSeq(a, c, index + 1, count, max);
    }
    // #alternativesolution:end
}

package com.github.lorenzoyang.javammexercises;

import com.github.lorenzoyang.simulazioni.prova2023_01_30.RimuoviCifre;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

public class RimuoviCifreBenchMark {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MINUTES)
    public void benchmark() {
        var rimuoviCifre = new RimuoviCifre();
        rimuoviCifre.rimuoviCifre(22345, (short) 2);
    }
}

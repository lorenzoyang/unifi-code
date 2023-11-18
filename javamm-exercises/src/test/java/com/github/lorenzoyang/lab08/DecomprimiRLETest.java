package com.github.lorenzoyang.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecomprimiRLETest {
    private final DecomprimiRLE decomprimiRLE = new DecomprimiRLE();

    @Test
    public void testDecomprimiRLE() {
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                decomprimiRLE.decomprimiRLE(new int[]{0, 3, 1, 2, 0, 5, 1, 3, 0, 1}));

        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, decomprimiRLE.decomprimiRLE(new int[]{1, 10}));

        assertArrayEquals(new int[]{1, 0, 1, 0, 1, 0, 1, 0},
                decomprimiRLE.decomprimiRLE(new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}));
    }
}

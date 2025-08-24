package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class HexadecimalTest {
    @Test
    void happy() {
        int hexValue = 0x73;
        Hexadecimal hex = new Hexadecimal(hexValue);
        assertEquals(hexValue, hex.raw());
        assertEquals("hex", hex.primor());
        assertPrintLn("hex > [0x73]", () -> hex.prettyPrint(""));

    }

    @Test
    void happyFF() {
        int hexValue = 0xFF;
        Hexadecimal hex = new Hexadecimal(hexValue);
        assertEquals("hex", hex.primor());
        assertEquals(hexValue, hex.raw());
        assertPrintLn("hex > [0xFF]", () -> hex.prettyPrint(""));
    }
}

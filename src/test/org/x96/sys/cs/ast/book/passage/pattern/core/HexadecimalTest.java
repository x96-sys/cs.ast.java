package org.x96.sys.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class HexadecimalTest {
    @Test
    void happy() {
        int hexValue = 0x73;
        Hexadecimal hex = new Hexadecimal(hexValue);
        assertEquals(hexValue, hex.raw());
        assertEquals("hex", hex.label());
        assertPrintLn("hex > [0x73]", () -> hex.prettyPrint(""));
    }

    @Test
    void happyFF() {
        int hexValue = 0xFF;
        Hexadecimal hex = new Hexadecimal(hexValue);
        assertEquals("hex", hex.label());
        assertEquals(hexValue, hex.raw());
        assertPrintLn("hex > [0xFF]", () -> hex.prettyPrint(""));
    }
}

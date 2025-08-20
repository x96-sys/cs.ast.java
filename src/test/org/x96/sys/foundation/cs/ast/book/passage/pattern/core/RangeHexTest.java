package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class RangeHexTest {

    @Test
    void happy() {
        RangeHex rangeHex = new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2));
        assertEquals("range-hex", rangeHex.primor());
        assertPrintLn("""
                range-hex
                    min hex > [0x1]
                    max hex > [0x2]""", () -> rangeHex.prettyPrint(""));
    }
}

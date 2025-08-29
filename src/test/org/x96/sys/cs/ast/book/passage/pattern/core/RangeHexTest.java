package org.x96.sys.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class RangeHexTest {

    @Test
    void happy() {
        RangeHex rangeHex = new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2));
        assertEquals("range-hex", rangeHex.label());
        assertPrintLn(
                """
                range-hex
                    min hex > [0x1]
                    max hex > [0x2]\
                """,
                () -> rangeHex.prettyPrint(""));
    }
}

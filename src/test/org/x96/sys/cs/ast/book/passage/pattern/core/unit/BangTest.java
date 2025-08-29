package org.x96.sys.cs.ast.book.passage.pattern.core.unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class BangTest {
    @Test
    void happy() {
        String raw = "!";
        Bang i = new Bang(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], i.raw());
        assertEquals("bang", i.label());
        assertPrintLn("bang > !", () -> i.prettyPrint(""));
    }
}

package org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class ZeroOrOneTest {
    @Test
    void happy() {
        String raw = "?";
        ZeroOrOne o = new ZeroOrOne(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], o.b());
        assertEquals("zero_or_one", o.label());
        assertPrintLn("zero_or_one > ?", () -> o.prettyPrint(""));
    }
}

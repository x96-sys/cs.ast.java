package org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class ZeroOrMoreTest {
    @Test
    void happy() {
        String raw = "*";
        ZeroOrMore o = new ZeroOrMore(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], o.b());
        assertEquals("zero_or_more", o.label());
        assertPrintLn("zero_or_more > *", () -> o.prettyPrint(""));
    }
}

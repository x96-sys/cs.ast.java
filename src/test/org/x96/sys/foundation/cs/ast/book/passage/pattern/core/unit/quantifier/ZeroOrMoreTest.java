package org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class ZeroOrMoreTest {
    @Test
    void happy() {
        String raw = "*";
        ZeroOrMore o = new ZeroOrMore(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], o.b());
        assertEquals("zero_or_more", o.primor());
        assertPrintLn("zero_or_more > *", () -> o.prettyPrint(""));
    }
}
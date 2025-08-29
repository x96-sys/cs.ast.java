package org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class OneOrMoreTest {
    @Test
    void happy() {
        String raw = "+";
        OneOrMore o = new OneOrMore(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], o.b());
        assertEquals("one_or_more", o.label());
        assertPrintLn("one_or_more > +", () -> o.prettyPrint(""));
    }
}

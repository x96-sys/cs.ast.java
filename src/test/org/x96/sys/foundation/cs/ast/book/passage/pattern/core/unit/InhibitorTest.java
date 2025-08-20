package org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class InhibitorTest {
    @Test
    void happy() {
        String raw = "!";
        Inhibitor i = new Inhibitor(raw.getBytes()[0]);
        assertEquals(raw.getBytes()[0], i.raw());
        assertEquals("inhibitor", i.primor());
        assertPrintLn("inhibitor > !", () -> i.prettyPrint(""));
    }
}
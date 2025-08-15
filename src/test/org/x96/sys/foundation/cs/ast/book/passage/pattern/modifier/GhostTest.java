package org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class GhostTest {
    @Test
    void happy() {
        String raw = "_";
        Ghost g = new Ghost(raw.getBytes()[0]);
        assertEquals("ghost", g.primor());
        assertPrintLn("ghost > _", () -> g.prettyPrint(""));
    }
}
package org.x96.sys.cs.ast.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class GhostTest {
    @Test
    void happy() {
        String raw = "_";
        Ghost g = new Ghost(raw.getBytes()[0]);
        assertEquals("ghost", g.label());
        assertPrintLn("ghost > _", () -> g.prettyPrint(""));
    }
}

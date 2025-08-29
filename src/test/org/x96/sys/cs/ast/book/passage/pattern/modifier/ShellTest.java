package org.x96.sys.cs.ast.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class ShellTest {
    @Test
    void happy() {
        String raw = "@";
        Shell g = new Shell(raw.getBytes()[0]);
        assertEquals("shell", g.label());
        assertPrintLn("shell > @", () -> g.prettyPrint(""));
    }
}

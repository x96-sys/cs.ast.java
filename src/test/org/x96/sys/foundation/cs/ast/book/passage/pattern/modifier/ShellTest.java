package org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class ShellTest {
    @Test
    void happy() {
        String raw = "@";
        Shell g = new Shell(raw.getBytes()[0]);
        assertEquals("shell", g.primor());
        assertPrintLn("shell > @", () -> g.prettyPrint(""));
    }
}
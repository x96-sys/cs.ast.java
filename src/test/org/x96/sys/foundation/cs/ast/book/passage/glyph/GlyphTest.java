package org.x96.sys.foundation.cs.ast.book.passage.glyph;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class GlyphTest {

    @Test
    void happy() {
        String raw = "cs";
        Glyph g = new Glyph(raw.getBytes());
        assertArrayEquals(raw.getBytes(), g.raw());
        assertEquals("cs", new String(g.raw()));
        assertEquals("glyph", g.primor());
        assertPrintLn("glyph > cs", () -> g.prettyPrint(""));
    }
}

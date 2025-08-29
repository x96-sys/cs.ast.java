package org.x96.sys.cs.ast.book.passage.glyph;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class GlyphTest {

    @Test
    void happy() {
        String raw = "cs";
        Glyph g = new Glyph(raw.getBytes());
        assertArrayEquals(raw.getBytes(), g.raw());
        assertEquals("cs", new String(g.raw()));
        assertEquals("glyph", g.label());
        assertPrintLn("glyph > cs", () -> g.prettyPrint(""));
    }
}

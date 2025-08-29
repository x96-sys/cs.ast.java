package org.x96.sys.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

class WordTest {
    @Test
    void happy() {
        String raw = "cs";
        Word w = new Word(raw.getBytes());
        assertArrayEquals(raw.getBytes(), w.raw());
        assertEquals("word", w.label());
        assertPrintLn("word > 'cs'", () -> w.prettyPrint(""));
    }
}

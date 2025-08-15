package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class WordTest {
    @Test
    void happy() {
        String raw = "cs";
        Word w = new Word(raw.getBytes());
        assertArrayEquals(raw.getBytes(), w.raw());
        assertEquals("word", w.primor());
        assertPrintLn("word > 'cs'", () -> w.prettyPrint(""));
    }
}

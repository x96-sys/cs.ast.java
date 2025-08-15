package org.x96.sys.foundation.cs.ast.book.passage;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Modifier;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class PassageTest {

    @Test
    void happy() {
        Core[] c = new Core[]{new Word("cs".getBytes())};
        Passage passage = new Passage(new Glyph("book".getBytes()), Optional.empty(), new Lineage(c));
        assertEquals("passage", passage.primor());
        assertPrintLn("""
                passage
                    glyph > book
                    lineage
                        word > 'cs'\
                """, () -> passage.prettyPrint(""));

    }

    @Test
    void happyGhost() {
        Core[] c = new Core[]{new Word("cs".getBytes())};
        Passage passage = new Passage(new Glyph("book".getBytes()), Optional.of(new Ghost("_".getBytes()[0])), new Lineage(c));
        assertEquals("passage", passage.primor());
        assertPrintLn("""
                passage
                    ghost > _
                    glyph > book
                    lineage
                        word > 'cs'\
                """, () -> passage.prettyPrint(""));

    }
}
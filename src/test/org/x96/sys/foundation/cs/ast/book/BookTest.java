package org.x96.sys.foundation.cs.ast.book;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class BookTest {
    @Test
    void happy() {

        Book book = new Book(new Passage[]{
                new Passage(new Glyph("book".getBytes()), Optional.empty(), new Lineage(new Core[]{new Word("cs".getBytes())}))
        });

        assertEquals("book", book.primor());

        assertPrintLn("""
                book
                    passage
                        glyph > book
                        lineage
                            word > 'cs'\
                """, () -> book.prettyPrint(""));
    }
}

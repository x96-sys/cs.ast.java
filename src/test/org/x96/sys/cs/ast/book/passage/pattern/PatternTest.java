package org.x96.sys.cs.ast.book.passage.pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.cs.ast.book.passage.pattern.core.Word;

import java.util.Optional;

class PatternTest {

    @Test
    void happy() {
        Core[] c = new Core[] {new Word("cs".getBytes())};
        assertInstanceOf(Pattern.class, new Lineage(c));
        assertInstanceOf(Pattern.class, new Casing(c, Optional.empty()));
    }
}

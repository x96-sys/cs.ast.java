package org.x96.sys.foundation.cs.ast.book.passage.pattern;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PatternTest {

    @Test
    void happy() {
        Core[] c = new Core[]{new Word("cs".getBytes())};
        assertInstanceOf(Pattern.class, new Lineage(c));
        assertInstanceOf(Pattern.class, new Casing(c, Optional.empty()));
    }
}
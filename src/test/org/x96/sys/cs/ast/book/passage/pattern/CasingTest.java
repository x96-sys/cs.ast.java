package org.x96.sys.cs.ast.book.passage.pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;

import java.util.Optional;

class CasingTest {
    @Test
    void happy() {
        Core[] c = new Core[] {new Word("cs".getBytes())};
        Casing casing = new Casing(c, Optional.of(new ZeroOrOne("?".getBytes()[0])));
        assertEquals("casing", casing.label());
        assertPrintLn(
                """
                casing [?] [zero_or_one]
                    word > 'cs'\
                """,
                () -> casing.prettyPrint(""));
    }
}

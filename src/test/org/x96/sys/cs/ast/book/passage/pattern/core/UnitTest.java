package org.x96.sys.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;

import java.util.Optional;

class UnitTest {
    @Test
    void happy() {
        Unit unit = new Unit(Optional.empty(), new Glyph("cs".getBytes()), Optional.empty());
        assertEquals("unit", unit.label());
        assertFalse(unit.bang().isPresent());
        assertFalse(unit.quantifier().isPresent());
        assertPrintLn(
                """
                unit
                    glyph > cs\
                """,
                () -> unit.prettyPrint(""));
    }

    @Test
    void happyInhibitor() {
        Bang i = new Bang((byte) '!');
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.empty());
        assertEquals("unit", unit.label());
        assertTrue(unit.bang().isPresent());
        assertFalse(unit.quantifier().isPresent());
        assertPrintLn(
                """
                unit
                    bang > !
                    glyph > cs\
                """,
                () -> unit.prettyPrint(""));
    }

    @Test
    void happyInhibitorQuantifier() {
        Bang i = new Bang((byte) '!');
        Quantifier q = new ZeroOrOne("?".getBytes()[0]);
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.of(q));
        assertEquals("unit", unit.label());
        assertTrue(unit.bang().isPresent());
        assertTrue(unit.quantifier().isPresent());
        assertPrintLn(
                """
                unit
                    bang > !
                    glyph > cs
                    zero_or_one > ?\
                """,
                () -> unit.prettyPrint(""));
    }
}

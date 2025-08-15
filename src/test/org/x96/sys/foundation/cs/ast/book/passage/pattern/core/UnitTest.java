package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class UnitTest {
    @Test
    void happy() {
        Unit unit = new Unit(Optional.empty(), new Glyph("cs".getBytes()), Optional.empty());
        assertEquals("unit", unit.primor());
        assertFalse(unit.inhibitor().isPresent());
        assertFalse(unit.quantifier().isPresent());
        assertPrintLn("""
                unit
                    glyph > cs""", () -> unit.prettyPrint(""));
    }

    @Test
    void happyInhibitor() {
        Inhibitor i = new Inhibitor('!');
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.empty());
        assertEquals("unit", unit.primor());
        assertTrue(unit.inhibitor().isPresent());
        assertFalse(unit.quantifier().isPresent());
        assertPrintLn("""
                unit
                    inhibitor > !
                    glyph > cs""", () -> unit.prettyPrint(""));
    }

    @Test
    void happyInhibitorQuantifier() {
        Inhibitor i = new Inhibitor('!');
        Quantifier q = new ZeroOrOne("?".getBytes()[0]);
        Unit unit = new Unit(Optional.of(i), new Glyph("cs".getBytes()), Optional.of(q));
        assertEquals("unit", unit.primor());
        assertTrue(unit.inhibitor().isPresent());
        assertTrue(unit.quantifier().isPresent());
        assertPrintLn("""
                unit
                    inhibitor > !
                    glyph > cs
                    zero_or_one > ?""", () -> unit.prettyPrint(""));
    }
}

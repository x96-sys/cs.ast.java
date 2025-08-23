package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class SegmentTest {
    @Test
    void happy() {
        Segment s = new Segment(new Axis[] {
                new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2)),
                new Word("cs".getBytes()),
        }, Optional.empty());
        assertEquals("segment", s.primor());
        assertPrintLn("""
                segment
                    range-hex
                        min hex > [0x1]
                        max hex > [0x2]
                    word > 'cs'\
                """, () -> s.prettyPrint(""));
    }

    @Test
    void happyRecursive() {
        Segment s = new Segment(new Axis[] {
                new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2)),
                new Word("cs".getBytes()),
                new Segment(new Axis[] {
                        new RangeHex(new Hexadecimal(0x11), new Hexadecimal(0x22)),
                        new Word("sc".getBytes())
                }, Optional.empty())
        }, Optional.empty());
        assertEquals("segment", s.primor());
        assertPrintLn("""
                segment
                    range-hex
                        min hex > [0x1]
                        max hex > [0x2]
                    word > 'cs'
                    segment
                        range-hex
                            min hex > [0x11]
                            max hex > [0x22]
                        word > 'sc'\
                """, () -> s.prettyPrint(""));
    }

    @Test
    void happyRecursiveQuantifier() {
        Segment s = new Segment(new Axis[] {
                new RangeHex(new Hexadecimal(0x1), new Hexadecimal(0x2)),
                new Word("cs".getBytes()),
                new Segment(new Axis[] {
                        new RangeHex(new Hexadecimal(0x11), new Hexadecimal(0x22)),
                        new Word("sc".getBytes())
                }, Optional.empty())
        }, Optional.of(new ZeroOrMore("*".getBytes()[0])));
        assertEquals("segment", s.primor());
        assertPrintLn("""
                segment
                    zero_or_more > *
                    range-hex
                        min hex > [0x1]
                        max hex > [0x2]
                    word > 'cs'
                    segment
                        range-hex
                            min hex > [0x11]
                            max hex > [0x22]
                        word > 'sc'\
                """, () -> s.prettyPrint(""));
    }
}

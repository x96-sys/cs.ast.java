package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.io.TestUtils.assertPrintLn;

class ChoicesTest {
    @Test
    void happy() {
        Choices choices = new Choices(new Core[]{
                new Word("cs".getBytes()),
                new Word("sc".getBytes())
        }, Optional.empty());
        assertEquals("choices", choices.primor());
        assertPrintLn("""
                choices
                    word > 'cs'
                    word > 'sc'\
                """, () -> choices.prettyPrint(""));
    }

    @Test
    void happyQuantifierOneOrMore() {
        Choices choices = new Choices(new Core[]{
                new Word("cs".getBytes()),
                new Word("sc".getBytes())
        }, Optional.of(new OneOrMore("+".getBytes()[0])));
        assertEquals("choices", choices.primor());
        assertPrintLn("""
                choices [+] [one_or_more]
                    word > 'cs'
                    word > 'sc'\
                """, () -> choices.prettyPrint(""));
    }

    @Test
    void happyQuantifierOneOrMore2() {
        Choices choices = new Choices(new Core[]{
                new Word("cs".getBytes()),
                new Word("sc".getBytes())
        }, Optional.of(new ZeroOrMore("*".getBytes()[0])));
        assertEquals("choices", choices.primor());
        assertPrintLn("""
                choices [*] [zero_or_more]
                    word > 'cs'
                    word > 'sc'\
                """, () -> choices.prettyPrint(""));
    }
}
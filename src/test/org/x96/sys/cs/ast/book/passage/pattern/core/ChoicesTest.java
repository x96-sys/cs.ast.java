package org.x96.sys.cs.ast.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.io.TestUtils.assertPrintLn;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;

import java.util.Optional;

class ChoicesTest {
    @Test
    void happy() {
        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.empty());
        assertEquals("choices", choices.label());
        assertPrintLn(
                """
                choices
                    word > 'cs'
                    word > 'sc'\
                """,
                () -> choices.prettyPrint(""));
    }

    @Test
    void happyQuantifierOneOrMore() {
        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.of(new OneOrMore("+".getBytes()[0])));
        assertEquals("choices", choices.label());
        assertPrintLn(
                """
                choices [+] [one_or_more]
                    word > 'cs'
                    word > 'sc'\
                """,
                () -> choices.prettyPrint(""));
    }

    @Test
    void happyQuantifierOneOrMore2() {
        Choices choices =
                new Choices(
                        new Core[] {new Word("cs".getBytes()), new Word("sc".getBytes())},
                        Optional.of(new ZeroOrMore("*".getBytes()[0])));
        assertEquals("choices", choices.label());
        assertPrintLn(
                """
                choices [*] [zero_or_more]
                    word > 'cs'
                    word > 'sc'\
                """,
                () -> choices.prettyPrint(""));
    }
}

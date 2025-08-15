package org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier;

import org.x96.sys.foundation.cs.ast.CS;

public sealed interface Quantifier extends CS permits ZeroOrOne, ZeroOrMore, OneOrMore {
    byte b();

    public default String decor() {
        switch (this) {
            case OneOrMore oneOrMore -> {
                return "+";
            }
            case ZeroOrMore zeroOrMore -> {
                return "*";
            }
            case ZeroOrOne zeroOrOne -> {
                return "?";
            }
        }
    }

    public default void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, primor(), new String(new byte[] { b() }));
    }
}

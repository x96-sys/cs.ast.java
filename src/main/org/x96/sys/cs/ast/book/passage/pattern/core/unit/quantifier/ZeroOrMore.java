package org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier;

import org.x96.sys.cs.ast.CS;

public record ZeroOrMore(byte b) implements Quantifier, CS {
    @Override
    public String label() {
        return "zero_or_more";
    }
}

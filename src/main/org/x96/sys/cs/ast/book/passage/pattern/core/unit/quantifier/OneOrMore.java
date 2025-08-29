package org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier;

import org.x96.sys.cs.ast.CS;

public record OneOrMore(byte b) implements Quantifier, CS {
    @Override
    public String label() {
        return "one_or_more";
    }
}

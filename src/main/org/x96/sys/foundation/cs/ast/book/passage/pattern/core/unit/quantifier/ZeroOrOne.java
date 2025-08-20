package org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier;

import org.x96.sys.foundation.cs.ast.CS;

public record ZeroOrOne(byte b) implements Quantifier, CS {
    @Override
    public String primor() {
        return "zero_or_one";
    }
}

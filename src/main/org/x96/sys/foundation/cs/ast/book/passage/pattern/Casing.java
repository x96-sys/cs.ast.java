package org.x96.sys.foundation.cs.ast.book.passage.pattern;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.List;
import java.util.Optional;

public record Casing(Core[] cores, Optional<Quantifier> quantifier) implements Pattern {
    @Override
    public String primor() {
        return "casing";
    }

    @Override
    public void prettyPrint(String indent) {
        String qtf = quantifier.map(q -> " [" + q.decor() + "] ["  + q.primor() + "]").orElse("");
        System.out.printf("%s%s%s%n", indent, primor(), qtf);
        for (Core core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

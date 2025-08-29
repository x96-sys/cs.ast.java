package org.x96.sys.cs.ast.book.passage.pattern;

import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.Optional;

public record Casing(Core[] cores, Optional<Quantifier> quantifier) implements Pattern {
    @Override
    public String label() {
        return "casing";
    }

    @Override
    public void prettyPrint(String indent) {
        String qtf = quantifier.map(q -> " [" + q.decor() + "] [" + q.label() + "]").orElse("");
        System.out.printf("%s%s%s%n", indent, label(), qtf);
        for (Core core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

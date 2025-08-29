package org.x96.sys.cs.ast.book.passage.pattern.core;

import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.Optional;

public record Choices(Core[] cores, Optional<Quantifier> quantifier) implements Core, Axis {
    @Override
    public String label() {
        return "choices";
    }

    @Override
    public void prettyPrint(String indent) {
        String qtf = quantifier.map(q -> " [" + q.decor() + "] [" + q.label() + "]").orElse("");
        System.out.println(indent + label() + qtf);
        for (var core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

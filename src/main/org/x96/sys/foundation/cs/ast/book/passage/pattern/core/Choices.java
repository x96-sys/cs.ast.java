package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.List;
import java.util.Optional;

public record Choices(Core[] cores, Optional<Quantifier> quantifier) implements Core, Axis {
    @Override
    public String primor() {
        return "choices";
    }

    @Override
    public void prettyPrint(String indent) {
        String qtf = quantifier.map(q -> " [" + q.decor() + "] ["  + q.primor() + "]").orElse("");
        System.out.println(indent + primor() + qtf);
        for (var core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

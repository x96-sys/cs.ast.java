package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import java.util.Optional;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

public record Segment(Axis[] axes, Optional<Quantifier> quantifier) implements Core, Axis {
    @Override
    public String primor() {
        return "segment";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, primor());
        quantifier.ifPresent(q -> q.prettyPrint(indent + " ".repeat(4)));
        for (Axis axe : axes) {
            axe.prettyPrint(indent + " ".repeat(4));
        }
    }
}

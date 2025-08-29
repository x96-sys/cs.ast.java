package org.x96.sys.cs.ast.book.passage.pattern.core;

import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.Optional;

public record Segment(Axis[] axes, Optional<Quantifier> quantifier) implements Core, Axis {
    @Override
    public String label() {
        return "segment";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        quantifier.ifPresent(q -> q.prettyPrint(indent + " ".repeat(4)));
        for (Axis axe : axes) {
            axe.prettyPrint(indent + " ".repeat(4));
        }
    }
}

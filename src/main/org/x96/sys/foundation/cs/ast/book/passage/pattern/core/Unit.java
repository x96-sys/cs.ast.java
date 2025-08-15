package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.Optional;

public record Unit(Optional<Inhibitor> inhibitor, Glyph glyph, Optional<Quantifier> quantifier)
        implements Core, Axis {
    @Override
    public String primor() {
        return "unit";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.println(indent + primor());
        inhibitor.ifPresent(i -> i.prettyPrint(indent + " ".repeat(4)));
        glyph.prettyPrint(indent + " ".repeat(4));
        quantifier.ifPresent(q -> q.prettyPrint(indent + " ".repeat(4)));
    }
}

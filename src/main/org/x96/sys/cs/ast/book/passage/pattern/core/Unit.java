package org.x96.sys.cs.ast.book.passage.pattern.core;

import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;

import java.util.Optional;

public record Unit(Optional<Bang> bang, Glyph glyph, Optional<Quantifier> quantifier)
        implements Core, Axis {
    @Override
    public String label() {
        return "unit";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.println(indent + label());
        bang.ifPresent(i -> i.prettyPrint(indent + " ".repeat(4)));
        glyph.prettyPrint(indent + " ".repeat(4));
        quantifier.ifPresent(q -> q.prettyPrint(indent + " ".repeat(4)));
    }
}

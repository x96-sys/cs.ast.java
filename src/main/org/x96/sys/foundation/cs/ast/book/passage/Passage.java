package org.x96.sys.foundation.cs.ast.book.passage;

import org.x96.sys.foundation.cs.ast.CS;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Pattern;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Modifier;

import java.util.Optional;

public record Passage(Glyph glyph, Optional<Modifier> modifier, Pattern pattern) implements CS {
    @Override
    public String primor() {
        return "passage";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.println(indent + primor());
        modifier.ifPresent(m -> m.prettyPrint(indent + " ".repeat(4)));
        glyph.prettyPrint(indent + " ".repeat(4));
        pattern.prettyPrint(indent + " ".repeat(4));
    }
}

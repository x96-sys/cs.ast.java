package org.x96.sys.foundation.cs.ast.book.passage.glyph;

import org.x96.sys.foundation.cs.ast.CS;

public record Glyph(byte[] raw) implements CS {
    @Override
    public String primor() {
        return "glyph";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, primor(), new String(raw));
    }
}

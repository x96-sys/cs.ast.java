package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

public record Word(byte[] raw) implements Core, Axis {
    @Override
    public String primor() {
        return "word";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > '%s'%n", indent, primor(), new String(raw));
    }
}

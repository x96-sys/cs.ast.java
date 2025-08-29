package org.x96.sys.cs.ast.book.passage.pattern.core;

public record Word(byte[] raw) implements Core, Axis {
    @Override
    public String label() {
        return "word";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > '%s'%n", indent, label(), new String(raw));
    }
}

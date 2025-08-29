package org.x96.sys.cs.ast.book.passage.pattern.core;

public record RangeHex(Hexadecimal min, Hexadecimal max) implements Axis {
    @Override
    public String label() {
        return "range-hex";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        min.prettyPrint(indent + " ".repeat(4) + "min ");
        max.prettyPrint(indent + " ".repeat(4) + "max ");
    }
}

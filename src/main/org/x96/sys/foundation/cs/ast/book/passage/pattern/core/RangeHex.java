package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

public record RangeHex(Hexadecimal min, Hexadecimal max) implements Axis {
    @Override
    public String primor() {
        return "range-hex";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, primor());
        min.prettyPrint(indent + " ".repeat(4) +  "min ");
        max.prettyPrint(indent + " ".repeat(4) +  "max ");
    }
}

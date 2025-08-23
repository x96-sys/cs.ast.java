package org.x96.sys.foundation.cs.ast.book.passage.pattern.core;

public record Hexadecimal(byte raw) implements Core {
    @Override
    public String primor() {
        return "hex";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > [0x%X]%n", indent, primor(), raw);
    }
}

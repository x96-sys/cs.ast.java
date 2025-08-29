package org.x96.sys.cs.ast.book.passage.pattern.core;

public record Hexadecimal(int raw) implements Core {
    @Override
    public String label() {
        return "hex";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > [0x%X]%n", indent, label(), raw);
    }
}

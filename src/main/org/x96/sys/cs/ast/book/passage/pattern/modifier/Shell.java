package org.x96.sys.cs.ast.book.passage.pattern.modifier;

public record Shell(byte raw) implements Modifier {

    @Override
    public String label() {
        return "shell";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), (char) raw);
    }
}

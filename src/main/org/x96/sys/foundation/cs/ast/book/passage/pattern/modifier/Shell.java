package org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier;

public record Shell(int raw) implements Modifier {

    @Override
    public String primor() {
        return "shell";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, primor(), (char) raw);
    }
}

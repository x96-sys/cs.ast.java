package org.x96.sys.cs.ast.book.passage.pattern.core.unit;

import org.x96.sys.cs.ast.CS;

public record Bang(byte raw) implements CS {

    @Override
    public String label() {
        return "bang";
    }

    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, label(), (char) (raw));
    }
}

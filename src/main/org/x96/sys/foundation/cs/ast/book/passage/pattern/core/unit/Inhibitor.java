package org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit;

import org.x96.sys.foundation.cs.ast.CS;

public record Inhibitor(int raw) implements CS {

    @Override
    public String primor() {
        return "inhibitor";
    }

    public void prettyPrint(String indent) {
        System.out.printf("%s%s > %s%n", indent, primor(), (char) (raw));
    }
}

package org.x96.sys.cs.ast.book;

import org.x96.sys.cs.ast.CS;
import org.x96.sys.cs.ast.book.passage.Passage;

public record Book(Passage[] passages) implements CS {
    @Override
    public String label() {
        return "book";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        for (Passage passage : passages) {
            passage.prettyPrint(indent + " ".repeat(4));
        }
    }
}

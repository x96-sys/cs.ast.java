package org.x96.sys.foundation.cs.ast.book;

import org.x96.sys.foundation.cs.ast.CS;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;

import java.util.List;

public record Book(Passage[] passages) implements CS {
    @Override
    public String primor() {
        return "book";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, primor());
        for (Passage passage : passages) {
            passage.prettyPrint(indent + " ".repeat(4));
        }
    }
}

package org.x96.sys.cs.ast.book.passage.pattern;

import org.x96.sys.cs.ast.book.passage.pattern.core.Core;

public record Lineage(Core[] cores) implements Pattern {

    @Override
    public String label() {
        return "lineage";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, label());
        for (Core core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

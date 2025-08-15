package org.x96.sys.foundation.cs.ast.book.passage.pattern;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;

public record Lineage(Core[] cores) implements Pattern {

    @Override
    public String primor() {
        return "lineage";
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.printf("%s%s%n", indent, primor());
        for (Core core : cores) {
            core.prettyPrint(indent + " ".repeat(4));
        }
    }
}

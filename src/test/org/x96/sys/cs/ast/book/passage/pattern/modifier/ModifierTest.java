package org.x96.sys.cs.ast.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModifierTest {
    @Test
    void happy() {
        assertInstanceOf(Modifier.class, new Shell("@".getBytes()[0]));
        assertInstanceOf(Modifier.class, new Ghost("_".getBytes()[0]));
    }
}

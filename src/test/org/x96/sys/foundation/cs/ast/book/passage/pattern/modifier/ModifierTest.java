package org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifierTest {
    @Test
    void happy() {
        assertInstanceOf(Modifier.class, new Shell("@".getBytes()[0]));
        assertInstanceOf(Modifier.class, new Ghost("_".getBytes()[0]));
    }
}
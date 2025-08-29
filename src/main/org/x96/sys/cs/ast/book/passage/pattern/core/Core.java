package org.x96.sys.cs.ast.book.passage.pattern.core;

import org.x96.sys.cs.ast.CS;

public sealed interface Core extends CS permits Hexadecimal, Word, Unit, Choices, Segment {}

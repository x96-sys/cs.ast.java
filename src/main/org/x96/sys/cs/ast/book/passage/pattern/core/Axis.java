package org.x96.sys.cs.ast.book.passage.pattern.core;

import org.x96.sys.cs.ast.CS;

public sealed interface Axis extends CS permits RangeHex, Segment, Unit, Choices, Word {}

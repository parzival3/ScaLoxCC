package io.github.parzival3.scaloxcc.util

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._

def prettyPrint(expression: Expr): String =
  expression match
    case Binary(l, t, r) => s"(${t} ${prettyPrint(l)}  ${prettyPrint(r)})"
    case Unary(t, e) => s"(${t} ${prettyPrint(e)})"
    case Grouping(e) => s"(group ${prettyPrint(e)})"
    case Literal(v) => s"$v"


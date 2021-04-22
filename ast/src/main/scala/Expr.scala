package io.github.parzival3.scaloxcc.ast

sealed trait Expr
case class Unary(token: TokenInstance, expr: Expr) extends Expr
case class Binary(left: Expr, token: TokenInstance, right: Expr) extends Expr
case class Call(name: TokenInstance, arguments: java.util.List[TokenInstances]) extends Expr
case class Grouping(expr: Expr) extends Expr
case class Literal(value: AnyVal) extends Expr
case class Assign(value: TokenInstance, expr: Expr) extends Expr
case class Variable(name: TokenInstance) extends Expr
case class Logical(left: Expr, token: TokenInstance, right: Expr) extends Expr
case class Set(obj: Expr, name: TokenInstance, value: Expr) extends Expr
case class Get(obj: Expr, name: TokenInstance) extends Expr

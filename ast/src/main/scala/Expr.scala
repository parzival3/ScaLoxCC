package io.github.parzival3.scaloxcc.ast

sealed trait Expr
case class Unary(token: TokenInstance, expr: Expr) extends Expr
case class Binary(left: Expr, token: TokenInstance, right: Expr) extends Expr
case class Call(name: TokenInstance, paren: TokenType, arguments: java.util.List[Expr]) extends Expr
case class Grouping(expr: Expr) extends Expr
case class Literal(value: AnyVal) extends Expr
case class Assign(value: TokenInstance, expr: Expr) extends Expr
case class Variable(name: TokenInstance) extends Expr
case class Logical(left: Expr, token: TokenInstance, right: Expr) extends Expr

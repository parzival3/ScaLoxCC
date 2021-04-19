package io.github.parzival3.scaloxcc.ast

sealed trait Expr
case class Unary(token: TokenType, expr: Expr) extends Expr
case class Binary(left: Expr, token: TokenType, right: Expr) extends Expr
case class Call(name: TokenType, paren: TokenType, arguments: java.util.List[Expr]) extends Expr
case class Grouping(expr: Expr) extends Expr
case class Literal(value: AnyVal) extends Expr
case class Assign(value: TokenType, expr: Expr) extends Expr
case class Variable(name: TokenType) extends Expr
case class Logical(left: Expr, token: TokenType, right: Expr) extends Expr

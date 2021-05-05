package io.github.parzival3.scaloxcc.ast

sealed trait Stmt
case class Block(statements: java.util.List[Stmt]) extends Stmt
case class LoxClass(name: TokenInstance, superclass: Option[Variable], methods: java.util.List[Stmt]) extends Stmt
case class Print(expr: Expr) extends Stmt
case class Expression(expr: Expr) extends Stmt
case class Var(name: TokenInstance, expr: Expr) extends Stmt
case class If(expr: Expr, ifBranch: Stmt, elseBranch: Option[Stmt]) extends Stmt
case class While(expr: Expr, stmt:  Stmt) extends Stmt
case class Function(name: TokenInstance, params: java.util.List[TokenInstance], body: java.util.List[Stmt]) extends Stmt
case class Return(name: TokenInstance, expr: Expr) extends Stmt

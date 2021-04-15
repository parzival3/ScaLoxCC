sealed trait Expr
case class Unary(token: TokenType, expr: Expr) extends Expr
case class Binary(left: Expr, token: TokenType, right: Expr) extends Expr
case class Grouping(expr: Expr) extends Expr
case class Literal(value: AnyVal) extends Expr
case class Variable(name: TokenType)

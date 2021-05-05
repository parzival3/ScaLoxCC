package io.github.parzival3.scaloxcc.util
// import scala.collection.JavaConversions._
import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import scala.collection.JavaConverters._

def prettyPrint(statement: Stmt): String =
     statement match
     case Block(statements) => s"[Block ${statements.asScala.map(prettyPrint(_))}]"
     case LoxClass(name, superclass, methods) => s"[Class $name ${if(superclass.nonEmpty) prettyPrint(superclass.get)}, ${methods.asScala.map(prettyPrint(_))}]"
     case Print(expr) => s"[Print ${prettyPrint(expr)}]"
     case Expression(expr) => s"[Expression ${prettyPrint(expr)}]"
     case Var(name, expr) => s"[Var name = $name, value = ${prettyPrint(expr)} ]"
     case If(expr, ifBranch, elseBranch) => s"[If ${prettyPrint(expr)}, ${prettyPrint(ifBranch)}, ${if(elseBranch.nonEmpty) prettyPrint(elseBranch.get)}]"
     case While(expr, stmt) => s"[While ${prettyPrint(expr)}, ${prettyPrint(stmt)}]"
     case Function(name, params, body) => s"[Function $name params = ${params.asScala.map(print(_))}, body = ${body.asScala.map(prettyPrint(_))} ]"
     case Return(name, expr) => s"[Return $name ${prettyPrint(expr)}]"

def prettyPrint(expression: Expr): String =
   expression match
     case Binary(l, t, r) => s"(${t} ${prettyPrint(l)}  ${prettyPrint(r)})"
     case Unary(t, e) => s"(${t} ${prettyPrint(e)})"
     case Grouping(e) => s"(group ${prettyPrint(e)})"
     case Literal(v) => s"$v"
     case Assign(t, e) => s"($t ${prettyPrint(e)})"
     case Variable(name) => s"($name)"
     case Logical(left, token, right) => s"($token ${prettyPrint(left)} ${prettyPrint(right)}})"
     case Set(obj, name, value) => s"($obj.$name = ${prettyPrint(value)})"
     case Get(obj, name) => s"(${prettyPrint(obj)}, $name)"
     case This(name) => s"($name)"
     case Super(keyword, method) => s"($keyword, $method)"
     case Call(callee, arguments) => s"(${prettyPrint(callee)} ${arguments.asScala.map(prettyPrint(_))}) "

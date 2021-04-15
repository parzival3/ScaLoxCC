import org.junit.Test
import org.junit.Assert._

class Test1 {
  @Test def t1(): Unit = {
    val test_expression =  "8 * 3 * (2 + 2345234.22) * (\"true\") * (----!!!!3)"
    val tree: Expr =  new SyntaxChecker(new java.io.StringReader(test_expression)).expression()
    println(prettyPrint(tree))
  }

  @Test def statement(): Unit = {
    val test_statement =  "print 3;"
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_statement)).program()
    println(tree)
  }
}

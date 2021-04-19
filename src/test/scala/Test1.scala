package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.util._
import io.github.parzival3.scaloxcc.javacc._
import org.junit.Test
import org.junit.Assert._

class Test1 {
  @Test def t1(): Unit = {
    val test_expression =  "8 * 3 * (2 + 2345234.22) * (\"true\") * (----!!!!3)"
    val tree: Expr =  new SyntaxChecker(new java.io.StringReader(test_expression)).expression()
    println(prettyPrint(tree))
  }

  @Test def printStatement(): Unit = {
    val test_statement =  "print 3;"
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_statement)).program()
    println(tree)
  }

  @Test def assignemntStatement(): Unit = {
    val test_statement =  "var echo = 3;"
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_statement)).program()
    println(tree)
  }

  @Test def assignemntStatement2(): Unit = {
    val test_statement =  "var echo = 3; var test = 4;"
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_statement)).program()
    println(tree)
  }


  @Test def ifBranch(): Unit = {
    val test_statement =  "if (hello == 4) hello = 5; else hello = 7;"
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_statement)).program()
    println(tree)
  }

  @Test def blockStatement(): Unit = {
    val test_block_statement =  """var a = "outer";
                                    {
                                      var a = "inner";
                                      print a;
                                    }

                                    print a;
                                    """
    val tree: java.util.List[Stmt] =  new SyntaxChecker(new java.io.StringReader(test_block_statement)).program()
    println(tree)
  }
}

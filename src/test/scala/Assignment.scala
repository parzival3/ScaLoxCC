package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Assignment extends AnyFunSuite with should.Matchers {

  val passing = List (
   "associativity",
   "global",
   "local",
   "syntax",
   "undefined"
  )

  val failing = List (
    "grouping",
   "infix_operator",
    "prefix_operator",
    "to_this"
  )

  passing map ( t =>

    test(s"Test correct parser $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"assignment/$t.lox").getLines
        assert(!SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty())
    }
  )

  failing map ( t =>
    test(s"Test parser assignment $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"assignment/$t.lox").getLines
        assertThrows[ParseException] {
          !SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty()
        }
    }
  )

}

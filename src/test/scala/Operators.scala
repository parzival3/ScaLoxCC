package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Operator extends AnyFunSuite with should.Matchers {

  val name = this.toString().toLowerCase()

  val passing = List (
    "add",
    "add_bool_nil",
    "add_bool_num",
    "add_bool_string",
    "add_nil_nil",
    "add_num_nil",
    "add_string_nil",
    "comparison",
    "divide",
    "divide_nonnum_num",
    "divide_num_nonnum",
    "equals",
    "greater_nonnum_num",
    "greater_num_nonnum",
    "greater_or_equal_nonnum_num",
    "greater_or_equal_num_nonnum",
    "less_nonnum_num",
    "less_num_nonnum",
    "less_or_equal_nonnum_num",
    "less_or_equal_num_nonnum",
    "multiply",
    "multiply_nonnum_num",
    "multiply_num_nonnum",
    "negate",
    "negate_nonnum",
    "not",
    "not_equals",
    "subtract",
    "subtract_nonnum_num",
    "subtract_num_nonnum",
  )

  val failing = List (
    "equals_method",
    "equals_class",
    "not_class",
  )

  val ignored = List (
  )

  passing map ( t =>

    test(s"Test correct parser $name : $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(!SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty())
    }
  )

  failing map ( t =>
    test(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assertThrows[ParseException] {
          !SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty()
        }
    }
  )

  ignored map ( t =>
    ignore(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(!SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty())
    }
  )

}

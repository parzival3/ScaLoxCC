package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Function extends AnyFunSuite with should.Matchers {

  val name = this.toString().toLowerCase()

  val passing = List (
    "empty_body",
    "extra_arguments",
  )

  val failing = List (
    "body_must_be_block",
  )

  val ignored = List (
    "local_mutual_recursion",
    "local_recursion",
    "missing_arguments",
    "missing_comma_in_parameters",
    "mutual_recursion",
    "nested_call_with_arguments",
    "parameters",
    "print",
    "recursion",
    "too_many_arguments",
    "too_many_parameters",
  )

  passing map ( t =>

    test(s"Test correct parser $name : $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program()
    }
  )

  failing map ( t =>
    test(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assertThrows[ParseException] {
          SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty()
        }
    }
  )

  ignored map ( t =>
    ignore(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(SyntaxChecker(new java.io.StringReader(programFile.mkString("\n"))).program().isEmpty())
    }
  )

}

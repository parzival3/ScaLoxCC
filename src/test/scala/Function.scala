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
    "parameters",
    "extra_arguments",
    "missing_arguments",
    "print",
    "too_many_arguments",
    "too_many_parameters",
    "nested_call_with_arguments",
    "mutual_recursion",
    "recursion",
    "local_mutual_recursion",
    "local_recursion",
  )

  val failing = List (
    "body_must_be_block",
    "missing_comma_in_parameters",
  )

  val ignored = List (
  )

  passing map ( t =>

    test(s"Test correct parser $name : $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit()
    }
  )

  failing map ( t =>
    test(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assertThrows[ParseException] {
          Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().isEmpty()
        }
    }
  )

  ignored map ( t =>
    ignore(s"Test ignored parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().isEmpty())
    }
  )

}

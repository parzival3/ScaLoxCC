package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Super extends AnyFunSuite with should.Matchers {

  val name = this.toString().toLowerCase()

  val passing = List (
    "bound_method",
    "call_other_method",
    "call_same_method",
    "closure",
    "constructor",
    "extra_arguments",
    "indirectly_inherited",
    "missing_arguments",
    "no_superclass_bind",
    "no_superclass_call",
    "no_superclass_method",
    "reassign_superclass",
    "super_at_top_level",
    "super_in_closure_in_inherited_method",
    "super_in_inherited_method",
    "super_in_top_level_function",
  )

  val failing = List (
    "super_without_name",
    "super_without_dot",
    "parenthesized",
  )

  val ignored = List (
    "this_in_superclass_method",
  )


  passing map ( t =>

    test(s"Test correct parser $name : $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(!Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().isEmpty())
    }
  )

  failing map ( t =>
    test(s"Test fail parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assertThrows[ParseException] {
          !Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().isEmpty()
        }
    }
  )

  ignored map ( t =>
    ignore(s"Test ignored parser assignment $name : $t ") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"$name/$t.lox").getLines
        assert(!Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().isEmpty())
    }
  )
}

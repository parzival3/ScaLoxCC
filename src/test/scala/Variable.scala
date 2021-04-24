package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Variable extends AnyFunSuite with should.Matchers {

  val name = this.toString().toLowerCase()

  val passing = List (
    "collide_with_parameter",
    "duplicate_local",
    "duplicate_parameter",
    "early_bound",
    "in_middle_of_block",
    "in_nested_block",
    "local_from_method",
    "redeclare_global",
    "redefine_global",
    "scope_reuse_in_different_blocks",
    "shadow_and_local",
    "shadow_global",
    "shadow_local",
    "undefined_global",
    "undefined_local",
    "uninitialized",
    "unreached_undefined",
    "use_global_in_initializer",
    "use_local_in_initializer",
  )

  val failing = List (
    "use_nil_as_var",
    "use_false_as_var",
    "use_this_as_var",
  )

  val ignored = List (
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

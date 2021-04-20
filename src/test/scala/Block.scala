package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source

class Block extends AnyFunSuite with should.Matchers {

  val name = this.toString().toLowerCase()

  val passing = List (
  )

  val failing = List ()

  val ignored = List (
    "empty.lox",
    "scope.lox",
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

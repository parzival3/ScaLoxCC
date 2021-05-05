package io.github.parzival3.scaloxcc.test

import io.github.parzival3.scaloxcc.ast._
import io.github.parzival3.scaloxcc.util._
import io.github.parzival3.scaloxcc.javacc._
import org.scalatest._
import flatspec._
import matchers._
import org.scalatest.funsuite.AnyFunSuite
import scala.io.Source
import scala.collection.JavaConverters._

class DebugTest extends AnyFunSuite with should.Matchers {


  val passing = List (
   "associativity",
  )

  passing map ( t =>

    test(s"Test correct parser  : $t") {
        val stream = new java.io.ByteArrayOutputStream()
        val programFile : Iterator[String] = Source.fromResource(s"assignment/$t.lox").getLines
        Parser(new java.io.StringReader(programFile.mkString("\n"))).compilationUnit().asScala.map(prettyPrint).map(println)
    }
  )


}

package io.github.parzival3.scaloxcc.ast

case class TokenInstance(tType: TokenType, lexeme: String, literal: Option[AnyRef])

object TokenInstance:

    def fromLexeme(lexeme: String): TokenType =
        TokenType.values.find(_.lexeme == lexeme)

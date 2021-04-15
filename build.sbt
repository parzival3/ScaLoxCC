val scala3Version = "3.0.0-RC2"
val projectVersion = "0.1.0"


lazy val ast = project.settings (
    version := projectVersion,
    scalaVersion := scala3Version,
)

lazy val javacc = project.dependsOn(ast).aggregate(ast).enablePlugins(JavaCCPlugin).settings (
    version := projectVersion,
    scalaVersion := scala3Version,
)

lazy val loxparser = project.dependsOn(javacc, ast).aggregate(ast, javacc)
  .in(file("."))
  .settings (
    name := "loxparser",
    version := projectVersion,
    scalaVersion := scala3Version,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
)

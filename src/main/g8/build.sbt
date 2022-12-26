// give the user a nice default project!
ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "3.2.1"

lazy val sharedSettings = Seq(
  scalacOptions ++= Seq(
    "-release",
    "$jvmVersion$",     // jvm version
    "-deprecation",     // emit warning and location for usages of deprecated APIs
    "-explain",         // explain errors in more detail
    "-explain-types",   // explain type errors in more detail
    "-feature",         // emit warning and location for usages of features that should be imported explicitly
    "-indent",          // allow significant indentation.
    "-new-syntax",      // require `then` and `do` in control expressions.
    "-print-lines",     // show source code line numbers.
    "-unchecked",       // enable additional warnings where generated code depends on assumptions
    "-Ykind-projector", // allow `*` as wildcard to be compatible with kind projector
    "-Xfatal-warnings", // fail the compilation if there are any warnings
    "-Xmigration"       // warn about constructs whose behavior may have changed since version
  ),
  testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
)

lazy val root = (project in file("."))
  .settings(
    name := "$name$"
  )

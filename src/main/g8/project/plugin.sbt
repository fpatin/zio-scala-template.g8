// https://github.com/spray/sbt-revolver https://github.com/spray/sbt-revolver/tags
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")
$if(useSQLDatabase.truthy) $
// https://github.com/flyway/flyway-sbt https://search.maven.org/search?q=g:io.github.davidmweber%20AND%20a:flyway-sbt&core=gav
  addSbtPlugin("io.github.davidmweber" % "flyway-sbt" % "7.4.0")
$endif$
// https://github.com/sbt/sbt-native-packager https://github.com/sbt/sbt-native-packager/releases
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.11")
// https://github.com/scalacenter/sbt-scalafix https://github.com/scalacenter/sbt-scalafix/releases
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.10.4")
// https://scalameta.org/scalafmt/ https://github.com/scalameta/sbt-scalafmt/releases
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")
// https://github.com/sbt/sbt-release https://github.com/sbt/sbt-release/releases
addSbtPlugin("com.github.sbt" % "sbt-release" % "1.1.0")
addDependencyTreePlugin

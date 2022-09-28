import sbt._

object Versions {
  $if(useGraphQL.truthy) $
  val caliban = "2.0.1" // https://ghostdogpr.github.io/caliban/ https://github.com/ghostdogpr/caliban/releases
  $endif$
  $if(useSQLDatabase.truthy) $
  val flyway   = "9.3.1" // https://flywaydb.org/ https://github.com/flyway/flyway/releases
  val zioQuill = "4.4.1" // https://github.com/zio/zio-protoquill https://github.com/zio/zio-protoquill/tags
  $endif$
  $if(useSQLDatabase.truthy) $
  val postgres = "42.3.7" // https://search.maven.org/artifact/org.postgresql/postgresql
  $endif$
  val sttp                 = "3.8.0"      // https://sttp.softwaremill.com/en/latest/ https://github.com/softwaremill/sttp/releases
  val tapir                = "1.1.1"      // https://tapir.softwaremill.com/en/latest/index.html https://github.com/softwaremill/tapir/releases
  val zio                  = "2.2.0"      // https://zio.dev/ https://github.com/zio/zio/releases
  val zioPrelude           = "1.0.0-RC15" // https://zio.github.io/zio-prelude/ https://github.com/zio/zio-prelude/releases
  val zioConfig            = "2.0.9"      // https://zio.github.io/zio-config/ https://github.com/zio/zio-config/releases
  val zioJson              = "0.3.0"      // https://github.com/zio/zio-json https://github.com/zio/zio-json/releases
  val zioLogging           = "2.1.1"      // https://zio.github.io/zio-logging/ https://github.com/zio/zio-logging/releases
  val logback              = "1.4.1"      // http://logback.qos.ch/ https://logback.qos.ch/download.html
  val zioMetricsConnectors = "2.0.0"      // https://github.com/zio/zio-metrics-connectors
  val zioTestContainers    = "0.8.0"      // https://github.com/scottweaver/testcontainers-for-zio https://github.com/scottweaver/testcontainers-for-zio/releases
}

object Dependencies {

  $if(useGraphQL.truthy) $
  lazy val caliban: Seq[ModuleID] = Seq(
    "com.github.ghostdogpr" %% "caliban"          % Versions.caliban,
    "com.github.ghostdogpr" %% "caliban-zio-http" % Versions.caliban,
    "com.github.ghostdogpr" %% "caliban-tapir"    % Versions.caliban
  )
  $endif$
  $if(useGraphQL.truthy && useSQLDatabase.truthy) $
  lazy val zioQuillCaliban: Seq[ModuleID] = Seq(
    "io.getquill" %% "quill-caliban" % Versions.zioQuill
  )
  $endif$
  $if(useSQLDatabase.truthy) $
  lazy val flyway: Seq[ModuleID] = Seq(
    "org.flywaydb" % "flyway-core" % Versions.flyway
  )
  lazy val zioQuill: Seq[ModuleID] = Seq(
    "io.getquill" %% "quill-jdbc-zio" % Versions.zioQuill
  )
  lazy val postgres: Seq[ModuleID] = Seq(
    "org.postgresql" % "postgresql" % Versions.postgres
  )
  $endif$

  lazy val tapir: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server"    % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle"  % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-json-zio"           % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-prometheus-metrics" % Versions.tapir
  )
  lazy val zio: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio"        % Versions.zio,
    "dev.zio" %% "zio-stream" % Versions.zio
  )
  lazy val zioConfig: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-config"          % Versions.zioConfig,
    "dev.zio" %% "zio-config-magnolia" % Versions.zioConfig,
    "dev.zio" %% "zio-config-typesafe" % Versions.zioConfig
  )
  lazy val zioJson: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-json" % Versions.zioJson
  )
  lazy val zioLogging: Seq[ModuleID] = Seq(
    "dev.zio"       %% "zio-logging-slf4j" % Versions.zioLogging,
    "ch.qos.logback" % "logback-classic"   % Versions.logback
  )
  lazy val zioMetricsConnectors: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-metrics-connectors" % Versions.zioMetricsConnectors
  )
  lazy val zioPrelude: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-prelude" % Versions.zioPrelude
  )
}

object TestDependencies {
  lazy val zioTest: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio-test"          % Versions.zio % Test,
    "dev.zio" %% "zio-test-sbt"      % Versions.zio % Test,
    "dev.zio" %% "zio-test-magnolia" % Versions.zio % Test
  )

  lazy val zioTestContainers: Seq[ModuleID] = Seq(
    "io.github.scottweaver" %% "zio-2-0-testcontainers-postgresql" % Versions.zioTestContainers,
    "io.github.scottweaver" %% "zio-2-0-db-migration-aspect"       % Versions.zioTestContainers
  )
  lazy val tapirTest = Seq(
    "com.softwaremill.sttp.tapir"   %% "tapir-sttp-stub-server" % Versions.tapir % Test,
    "com.softwaremill.sttp.client3" %% "zio-json"               % Versions.sttp  % Test
  )
}
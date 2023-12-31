val zioVersion            = "2.0.18"
val zioJsonVersion        = "0.6.2"
val zioConfigVersion      = "3.0.7"
val zioLoggingVersion     = "2.1.14"
val logbackClassicVersion = "1.4.11"
val postgresqlVersion     = "42.6.0"
val testContainersVersion = "0.41.0"
val zioMockVersion        = "1.0.0-RC11"
val zioHttpVersion        = "3.0.0-RC2"
val quillVersion          = "4.8.0"

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        scalaVersion := "3.3.1"
      )
    ),
    name           := "zhttp-sandbox",
    libraryDependencies ++= Seq(
      "io.getquill"   %% "quill-jdbc-zio"      % quillVersion excludeAll ExclusionRule(organization =
        "org.scala-lang.modules"
      ),
      "org.postgresql" % "postgresql"          % postgresqlVersion,
      "dev.zio"       %% "zio"                 % zioVersion,
      "dev.zio"       %% "zio-streams"         % zioVersion,
      "dev.zio"       %% "zio-http"            % zioHttpVersion,
      "dev.zio"       %% "zio-config"          % zioConfigVersion,
      "dev.zio"       %% "zio-config-typesafe" % zioConfigVersion,
      "ch.qos.logback" % "logback-classic"     % logbackClassicVersion,
      "dev.zio"       %% "zio-json"            % zioJsonVersion,

      // logging
      "dev.zio"       %% "zio-logging"       % zioLoggingVersion,
      "dev.zio"       %% "zio-logging-slf4j" % zioLoggingVersion,
      "ch.qos.logback" % "logback-classic"   % logbackClassicVersion,

      // test
      "dev.zio"      %% "zio-test"                        % zioVersion            % Test,
      "dev.zio"      %% "zio-test-sbt"                    % zioVersion            % Test,
      "dev.zio"      %% "zio-test-junit"                  % zioVersion            % Test,
      "dev.zio"      %% "zio-mock"                        % zioMockVersion        % Test,
      "com.dimafeng" %% "testcontainers-scala-postgresql" % testContainersVersion % Test,
      "dev.zio"      %% "zio-test-magnolia"               % zioVersion            % Test,
    ),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
  )
  .enablePlugins(JavaAppPackaging)

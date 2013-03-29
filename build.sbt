/* basic project info */
name := "jerkson"

organization := "com.codahale"

version := "0.5.0"

licenses := Seq(
  ("The MIT License", url("http://codahale.com/mit.txt"))
)

/* scala versions and options */
scalaVersion := "2.10.1"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  // "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8",
  "-optimise"
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.10") List(
    // "-Xverify",
    // "-Ywarn-all",
    "-feature",
    "-language:postfixOps",
    "-language:reflectiveCalls",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:existentials"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq(
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.5",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.5"
)

libraryDependencies <+= scalaVersion {
  "org.scala-lang" % "scala-reflect" % _
}


/* testing */
parallelExecution in Test := false

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

offline := false

/* publishing */
publishMavenStyle := true

publishArtifact in Test := false


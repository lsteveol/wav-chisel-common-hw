// See README.md for license details.

ThisBuild / scalaVersion     := "2.12.15"
//ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.github.lsteveol"

val chiselVersion = "3.5.2"
lazy val rocketChip = RootProject(file("./rocket-chip"))

lazy val root = (project in file("."))
  .settings(
    name := "wav-wlink-hw",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3" % chiselVersion
    ),
    scalacOptions ++= Seq(
      "-Xsource:2.13",
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
      "-P:chiselplugin:genBundleElements",
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % chiselVersion cross CrossVersion.full)
  )
  .dependsOn(rocketChip)


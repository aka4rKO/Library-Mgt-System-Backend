name := """library-manager"""
organization := "com.librarymanager"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.7"

libraryDependencies += guice
libraryDependencies += jdbc

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41" 
name := "lib-jxbrowser-win"
organization := "com.teamdev"
version := "5.4"

scalaVersion := "2.11.7"

unmanagedJars in Compile += file("lib/jxbrowser-win-5.4.jar")

artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.copy(`classifier` = Some("assembly"))
}

addArtifact(artifact in (Compile, assembly), assembly)

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/mvn-repo")))
crossPaths := false

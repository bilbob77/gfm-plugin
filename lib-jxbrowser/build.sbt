name := "lib-jxbrowser"
organization := "com.teamdev"
version := "5.4"

scalaVersion := "2.11.7"

unmanagedJars in Compile += file("lib/jxbrowser-5.4.jar")

artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.copy(`classifier` = Some("assembly"))
}

addArtifact(artifact in (Compile, assembly), assembly)

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/mvn-repo"

libraryDependencies ++= Seq(
  "com.teamdev" % "lib-jxbrowser-linux32" % "5.4",
  "com.teamdev" % "lib-jxbrowser-linux64" % "5.4",
  "com.teamdev" % "lib-jxbrowser-mac" % "5.4",
  "com.teamdev" % "lib-jxbrowser-win" % "5.4"
)

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/mvn-repo")))

crossPaths := false

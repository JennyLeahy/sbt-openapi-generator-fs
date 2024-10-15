ThisBuild / organization := "org.openapitools.sbt-openapi-generator"
ThisBuild / organizationName := "OpenAPITools"
ThisBuild / organizationHomepage := Some(url("http://openapitools.org"))

ThisBuild / description := "openapi-generator sbt plugin."
ThisBuild / licenses := List(
  "Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")
)

ThisBuild / homepage := Some(url("https://github.com/openapitools/sbt-openapi-generator"))

ThisBuild / publishTo  := Some("Artifactory" at "https://moda.jfrog.io/moda/sbt")
// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true
ThisBuild / Test / publishArtifact := false
ThisBuild / resolvers += "Artifactory" at "https://moda.jfrog.io/moda/sbt"
ThisBuild / credentials ++= {
  (sys.env.get("JFROG_USER"), sys.env.get("JFROG_PASS")) match {
    case (Some(user), Some(pass))                          => Seq(Credentials("Artifactory Realm", "moda.jfrog.io", user, pass))
    case _ if (Path.userHome / "credentials.sbt").exists() => Seq(Credentials(Path.userHome / "credentials.sbt"))
    case _                                                 => Seq()
  }
}
